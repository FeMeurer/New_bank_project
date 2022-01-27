package de.telekom.sea7.inter.view;

import de.telekom.sea7.inter.model.GenericList;
import de.telekom.sea7.inter.model.Transaction;

public interface TransactionListView {

	void add();

	void remove();

	void show();

	void showOne();

	void getBalance();

	void menu();
	
	void exportCsv();
	
	void importCsv();
	
	void search();

}