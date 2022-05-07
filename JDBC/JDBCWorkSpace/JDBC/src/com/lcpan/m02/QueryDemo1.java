package com.lcpan.m02;

import java.sql.*;

public class QueryDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//¨S¼g¦^¶Ç­Èclass<?>= cls =class.forName.......
			String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(url, "sa", "passw0rd");
		
			String sql = "select ename , salary  from employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename"));
				System.out.println(", salary = " + rs.getInt("salary"));
			}
		
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}
}
