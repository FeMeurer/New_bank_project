package de.telekom.sea7.inter.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

	Connection getConnection() throws SQLException;

	String getDbms();

	String getServerName();

	String getPortNumber();

	String getDbName();

}