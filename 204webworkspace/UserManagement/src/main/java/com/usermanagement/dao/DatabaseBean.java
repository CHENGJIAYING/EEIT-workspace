package com.usermanagement.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private Connection con = null;

	public DatabaseBean() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/BakeYourLife");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean isConnectOK() {
		try (Connection con = dataSource.getConnection()) {
			return !con.isClosed();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() throws Exception {
		return con;
	}

	public void close() throws Exception {
		if (con != null) {
			con.close();
		}
	}
}
