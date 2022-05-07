package DAOMode;

import java.sql.SQLException;
import java.util.List;

//import java.util.List;

public interface IGreenDAO {
/*
	public List<Green>  queryAll() throws Exception;
	public Green findgGreen()throws Exception;
	public boolean insert() throws Exception;
	public boolean update() throws Exception;
	*/
	public List<Green> query() throws Exception;
	public void Insert() throws SQLException;
	public void Update()throws SQLException;
	public void Delete()throws SQLException;
	
	
}
