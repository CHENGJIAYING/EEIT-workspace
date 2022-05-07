package DAOMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GreenDAOImpl2 implements IGreenDAO {
	private Connection con; 
	private PreparedStatement pstat = null; 
	public GreenDAOImpl2(Connection con){ 
	this.con = con; 
	} 
	@Override
	public List<Green> query() throws Exception {
		String sql = "SELECT * from green ";
		pstat = con.prepareStatement(sql); 
		ResultSet rs = pstat.executeQuery(); 
		List<Green> list = new ArrayList<Green>(); 
		while (rs.next()) {
			System.out.print(rs.getString("編號"));
			System.out.print(","+rs.getString("餐廳名稱"));
			System.out.print(","+rs.getString("電話"));
			System.out.println(","+rs.getString("地址"));
		}
		rs.close();
		pstat.close();
		return list ;
	}

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		
	}
}