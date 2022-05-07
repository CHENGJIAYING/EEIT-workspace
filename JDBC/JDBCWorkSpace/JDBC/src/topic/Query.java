package topic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Query {
	//private static final String JDBC_DRIVER = 
		//	"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private  static final  String DB_URL = 
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private  static final String USER = "sa";
	private  static final String PASSWORD = "passw0rd";
	private  static final String SQL =
	"SELECT * from green where 地址 like ? ";
	
	//public static void smain(String[] args){
		public void resQuery(String  area){
			
		Connection conn = null;
		try {
		
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			
			pstmt.setString(1,area );
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				System.out.print(rs.getString("餐廳名稱"));
				System.out.print(","+ rs.getString("電話"));
				System.out.println(","+rs.getString("地址"));
				
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