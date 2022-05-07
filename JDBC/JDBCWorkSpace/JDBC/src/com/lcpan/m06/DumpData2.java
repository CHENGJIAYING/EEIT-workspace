package com.lcpan.m06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.*;

public class DumpData2 {
	private static final String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String SQL =
			"SELECT * FROM employee";
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()) {
	     		for(int j = 1; j <= count; j++)
	         		System.out.print(rs.getString(j) + ",");
	     		System.out.print("\n");
	     		
			}
			try ( FileOutputStream fos = new FileOutputStream("C:/java/greeneweeee.csv");
					OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF8");//可以指定編碼
					){
				while(rs.next()) {
		     		for(int i = 1; i <= count; i++) 
		     			
		     			osw.write(rs.getString(i)+",");
		     			osw.write("\n");
		     			osw.flush();
		     			
		     		
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*
			while(rs.next()) {
	     		for(int j = 1; j <= count; j++)
	         		System.out.print(rs.getString(j) + ",");
	     		System.out.print("\n");
	     		
			}
			*/
			rs.close();
			stmt.close();
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
