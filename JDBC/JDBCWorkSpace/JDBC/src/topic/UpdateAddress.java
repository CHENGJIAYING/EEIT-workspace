package topic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAddress {

	private static final String DB_URL =
			"jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa";
	private static final String PASSWORD ="passw0rd";
	private static final String SQL =
			"UPDATE green SET �a�}= ? WHERE �\�U�W�� = ?";
	
	//public static void main(String[] args) {
		public void resadUpdate(String address,String name){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			//String address = "��饫�����Ϥ��s�n��123��";
			//String name = "�G�a�p�]";
			pstmt.setString(1, address);
			pstmt.setString(2, name);
			
			int count = pstmt.executeUpdate();
			if (count==0) {
				System.err.println("�d�L���\�U'"+name+"'��s���ѽЭ��s�ާ@");
			}else {
				System.out.println("���\��s" + count + "�����");
				
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