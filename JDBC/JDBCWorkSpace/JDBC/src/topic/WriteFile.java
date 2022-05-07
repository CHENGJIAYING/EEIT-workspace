package topic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class WriteFile {
	private  static final  String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private  static final String USER = "sa";
	private  static final String PASSWORD = "passw0rd";
	private  static final String SQL =
	"SELECT * from green where 地址 like ? ";
	
	public void write(String find,String path) {
		
		Connection conn = null;
		try {
		
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1,find );
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			//String a = "C:/java/greenew.csv"
			try ( FileOutputStream fos = new FileOutputStream(path+".csv");
					OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF8");//可以指定編碼
					){
				while(rs.next()) {
		     		for(int i = 1; i <= count; i++)
		     			osw.write(rs.getString(i)+",");
		     			osw.write("\n");
		     			osw.flush();
		     		
				}
				System.out.println("輸出完成");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
		
	}
	
}
