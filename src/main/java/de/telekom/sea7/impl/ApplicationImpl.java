package de.telekom.sea7.impl;

import java.sql.Connection;
import java.util.Scanner;

import de.telekom.sea7.impl.model.DBConnectionImpl;
import de.telekom.sea7.impl.model.TransactionListTableImpl;
import de.telekom.sea7.impl.view.TransactionListViewImpl;
import de.telekom.sea7.inter.model.DBConnection;
import de.telekom.sea7.inter.model.TransactionListTable;
import de.telekom.sea7.inter.view.TransactionListView;

public class ApplicationImpl extends BaseObjectImpl implements Application {

	public ApplicationImpl(Object parent) {
		super(parent);
	}

	@Override
	public void run() {
		DBConnection dbconnection = new DBConnectionImpl(this, "admin", "sea13", "mariadb", "localhost", "3306", "bank");
		try {
			try (Connection connection = dbconnection.getConnection()) {
				try (TransactionListTable transactionListTable = new TransactionListTableImpl(this, connection)) { 
					try (Scanner scanner = new Scanner(System.in)) {
						TransactionListView transactionListView = new TransactionListViewImpl(this, scanner, transactionListTable.getTransactionList());
						transactionListView.menu();
					}
				}
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
