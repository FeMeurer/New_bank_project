package de.telekom.sea7.impl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.DBConnection;

public class DBConnectionImpl extends BaseObjectImpl implements DBConnection {
	
	private String userName;
	private String password;
	private String dbms;
	private String serverName;
	private String portNumber;
	private String dbName;
	
	public DBConnectionImpl(Object parent, String userName, String password, String dbms, String serverName, String portNumber, String dbName) {
		super(parent);
		this.userName = userName;
		this.password = password;
		this.dbms = dbms;
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.dbName = dbName;
	}
	
	
	@Override
	public Connection getConnection() throws SQLException {

	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    Connection conn = DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName + ":" + this.portNumber + "/" + this.dbName, connectionProps);
        
	    System.out.println("Connected to database");
	    return conn;
	}

	@Override
	public String getDbms() {
		return dbms;
	}


	@Override
	public String getServerName() {
		return serverName;
	}


	@Override
	public String getPortNumber() {
		return portNumber;
	}


	@Override
	public String getDbName() {
		return dbName;
	}
}
