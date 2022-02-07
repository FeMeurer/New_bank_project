package de.telekom.sea7.inter.model;

import java.sql.SQLException;

public interface TransactionListTable extends AutoCloseable {

	GenericList<Transaction> getTransactionList() throws SQLException;

	void close() throws Exception;

}