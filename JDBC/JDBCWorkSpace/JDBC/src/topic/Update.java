package topic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	private static final String DB_URL =
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD ="passw0rd";
	private static final String SQL =
			"UPDATE green SET 電話= ? WHERE 餐廳名稱 = ?";
	
	//public static void main(String[] args) {
		public void resUpdate(String phone,String name){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			//String phone = "03-4758692";
			//String name = "鄭家小館";
			pstmt.setString(1, phone);
			pstmt.setString(2, name);
			
			int count = pstmt.executeUpdate();
			if (count==0) {
				System.err.println("查無此餐廳'"+name+"'更新失敗請重新操作");
			}else {
				System.out.println("成功更新" + count + "筆資料");
				
			}
		} catch (SQLException e) {
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
