package de.telekom.sea7.impl.model;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import de.telekom.sea7.impl.Application;
import de.telekom.sea7.impl.ApplicationImpl;
import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Transaction;

public class RepositoryZahlungen extends BaseObjectImpl {
	
	String sqlForInsert = "";
	String sqlForUpdate = "";
	String sqlForGetAll = "SELECT * FROM transactions";
	
	Connection connection = ApplicationImpl.getApplication().connection;
	
	PreparedStatement psForGetAll = connection.prepareStatement(sqlForGetAll);
	
	public RepositoryZahlungen(Object parent) throws SQLException {
		super(parent);
	}
	
	public List<Transaction> getAll() throws SQLException {
		ResultSet rs = psForGetAll.executeQuery();
		while (rs.next()) {
			Float amount = rs.getBigDecimal("amount").setScale(2, RoundingMode.DOWN).floatValue();
			String receiver_ID = Integer.toString(rs.getInt("name"));
			String iban_ID = Integer.toString(rs.getInt("iban_ID"));
			
		}
	} 
}
