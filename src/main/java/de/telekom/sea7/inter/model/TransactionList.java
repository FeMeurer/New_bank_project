package de.telekom.sea7.inter.model;

import java.io.IOException;
import java.util.Iterator;

public interface TransactionList extends Iterable {

	void add(Transaction transaction);
	
	Transaction getTransaction(int index);

	void remove(int index);

	void remove(Transaction transaction);

	int size();
	
	int getIndex(Transaction transaction);
	
	float getBalance();

	Iterator iterator();
	
	boolean checkIndex(int index);
	
	void exportCsv(String fileName);
	
	void importCsv(String fileName);
}