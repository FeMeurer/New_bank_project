package de.telekom.sea7.impl.model;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.GenericList;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionListTable;

public class TransactionListTableImpl extends BaseObjectImpl implements AutoCloseable, TransactionListTable {

	private Connection connection;
	private Statement statement;
	
	public TransactionListTableImpl(Object parent, Connection connection) throws SQLException {
		super(parent);
		this.connection = connection;
		this.statement = this.connection.createStatement();
	}
	
	@Override
	public GenericList<Transaction> getTransactionList() throws SQLException {
		GenericList<Transaction> transactionList = new GenericListImpl<Transaction>(this);
		ResultSet rs = this.statement.executeQuery("select * from showTransactions");
		while (rs.next()) {
			Float amount = rs.getBigDecimal("amount").setScale(2, RoundingMode.DOWN).floatValue();
			String name = rs.getString("name");
			String iban = rs.getString("iban");
			String bic = rs.getString("bic");
			String purpose = rs.getString("purpose");
			LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
			Transaction transaction = new TransactionImpl(this, amount, name, iban, bic, purpose, date);
			transactionList.add(transaction);
		}
		
		return transactionList;
	}

	@Override
	public void close() throws Exception {
		statement.close();
	}
}
