package com.lcpan.m07;

import java.sql.*;

public class BatchUpdatePreStatement2 {
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String SQL =
			"UPDATE employee SET salary = ? WHERE empno = ?";
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 70000);
			pstmt.setString(2, "1004");
			pstmt.addBatch();
			pstmt.setInt(1, 40000);
			pstmt.setString(2, "1005");
			pstmt.addBatch();
			pstmt.setInt(1, 47000);
			pstmt.setString(2, "1006");
			pstmt.addBatch();
			pstmt.executeBatch();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
