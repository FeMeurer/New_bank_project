package de.telekom.sea7.impl.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

public class TransactionListImpl<T> extends BaseObjectImpl implements Iterable, TransactionList {
	
	private List transactionList;
	
	public TransactionListImpl(Object parent) {
		super(parent);
		transactionList = new ArrayList();
	}
	
	@Override
	public Transaction getTransaction(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			return (Transaction)transactionList.get(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void add(Transaction transaction) {
		this.transactionList.add(transaction);
	}
	
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			this.transactionList.remove(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void remove(Transaction transaction) {
		this.transactionList.remove(transaction);
	}
	
	@Override
	public int size() {
		return this.transactionList.size();
	}
	
	@Override
	public int getIndex(Transaction transaction) {
		return this.transactionList.indexOf(transaction);
	}

	@Override
	public Iterator iterator() {
		return transactionList.iterator();
	}
	
	@Override
	public boolean checkIndex(int index) {
		return index >= 0 && index < transactionList.size();
	}
	
	@Override
	public float getBalance() {
		float amount = 0.00f;
		for (Object o : transactionList) {
			Transaction transaction = (Transaction)o;
			amount = amount + transaction.getAmount();
		}
		return amount;
	}
	
	@Override
	public void exportCsv(String fileName) {
		try {
			try (Writer out = new FileWriter(fileName)) {
				CSVFormat format = CSVFormat.Builder.create().setHeader("amount","receiver","iban","bic","purpose","date").build();
				try (CSVPrinter printer = new CSVPrinter(out, format)) {
					for (Object e : transactionList) {
						Transaction t = (Transaction)e;
						printer.printRecord(t.getAmount(),
											t.getReceiver(),
											t.getIban(),
											t.getBic(),
											t.getPurpose(),
											t.getDate());
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void importCsv(String fileName) {
		try {
			try (Reader in = new FileReader(fileName)) {
				CSVFormat format = CSVFormat.Builder.create().setSkipHeaderRecord(true).setHeader("amount","receiver","iban","bic","purpose","date").build();
				try (CSVParser parser = new CSVParser(in, format)) {
					for (CSVRecord record : parser) {
						float amount = Float.parseFloat(record.get("amount"));
						String receiver = record.get("receiver");
						String iban = record.get("iban");
						String bic = record.get("bic");
						String purpose = record.get("purpose");
						LocalDateTime date = LocalDateTime.parse(record.get("date"));
						Transaction transaction = new TransactionImpl(this,amount,receiver,iban,bic,purpose,date);
						add(transaction);
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
