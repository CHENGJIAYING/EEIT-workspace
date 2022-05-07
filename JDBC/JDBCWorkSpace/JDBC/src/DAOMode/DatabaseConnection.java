package DAOMode;
import java.sql.*; 
public class DatabaseConnection {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	private static final String USER = "sa"; 
	private static final String PASSWORD ="passw0rd";
	private Connection con = null;
	public DatabaseConnection()throws Exception{ 
		Class.forName(DRIVER); 
		con = DriverManager.getConnection(DB_URL,USER,PASSWORD); 
		} 
	public Connection getConnection()throws Exception{ 
	return con; 
	}
	public void close()throws Exception{ 
	if(con!=null){ 
	con.close(); 
	} 
	} 
	} 
	
	
	
	
	
	

