package de.telekom.sea7.impl.model;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import de.telekom.sea7.impl.BaseObject;
import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.GenericList;

public class GenericListImpl<T> extends BaseObjectImpl implements Iterable<T>, GenericList<T> {
	
	private List<T> genericList;
	
	public GenericListImpl(Object parent) {
		super(parent);
		genericList = new ArrayList<T>();
	}
	
	
	public List<T> getGenericList() {
		return genericList;
	}


	@Override
	public T getOneObject(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			return genericList.get(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void add(T tObject) {
		this.genericList.add(tObject);
	}
	
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			this.genericList.remove(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void remove(T tObject) {
		this.genericList.remove(tObject);
	}
	
	@Override
	public int size() {
		return this.genericList.size();
	}
	
	@Override
	public int getIndex(T tObject) {
		return this.genericList.indexOf(tObject);
	}

	@Override
	public Iterator<T> iterator() {
		return genericList.iterator();
	}
	
	@Override
	public boolean checkIndex(int index) {
		return index >= 0 && index < genericList.size();
	}
	
	@Override
	public GenericList<T> search(String input) {
		GenericList<T> foundTransactionList = new GenericListImpl<T>(this);
		for (T e : genericList) {
			compare(input, e, foundTransactionList);
		}
		return foundTransactionList;
	}
	
	@Override
	public void compare(String input, T tObject, GenericList<T> foundTransactionList) {
		if (tObject instanceof BaseObject) {
			BaseObject baseobject = (BaseObject)tObject;
		
			for (String str : baseobject.getValues()) {
				if (str.contains(input)) {
					foundTransactionList.add(tObject);
					return;
				}
			}
		}
	}
	
	public void exportCsv(String fileName) {
		try {
			try (Writer out = new FileWriter(fileName)) {
				CSVFormat format = CSVFormat.Builder.create().build();
				try (CSVPrinter printer = new CSVPrinter(out, format)) {
					boolean headerCreated = false;
					for (T tObject : genericList) {
						if (tObject instanceof BaseObject) {
							BaseObject baseobject = (BaseObject)tObject;
							if (!headerCreated) {
								printer.printRecord(baseobject.getPropertyNames());	
								headerCreated = true;
							}
							printer.printRecord(baseobject.getValues());
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//	public void importCsv(String fileName) {
//		try {
//			try (Reader in = new FileReader(fileName)) {
//				CSVFormat format = CSVFormat.Builder.create().setSkipHeaderRecord(true).build();
//				try (CSVParser parser = new CSVParser(in, format)) {
//					for (CSVRecord record : parser) {
//						float amount = Float.parseFloat(record.get("amount"));
//						String receiver = record.get("receiver");
//						String iban = record.get("iban");
//						String bic = record.get("bic");
//						String purpose = record.get("purpose");
//						LocalDateTime date = LocalDateTime.parse(record.get("date"));
//						Transaction transaction = new TransactionImpl(this,amount,receiver,iban,bic,purpose,date);
//						transactionList.add(transaction);
//					}
//				}
//			}
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
}
