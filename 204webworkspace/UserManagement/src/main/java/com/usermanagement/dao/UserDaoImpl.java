package com.usermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.usermanagement.bean.*;

public class UserDAOImpl implements UserDao{
	private final String sql_create = "INSERT INTO users (userName,userEmail,userPhone,userBirth,userGender,userAddress) VALUES(?,?,?,?,?,?)";
	private final String sql_findall = "SELECT * FROM users";
	private final String sql_findbyuserid = "SELECT * FROM users WHERE userId=?";
	private final String sql_update = "UPDATE users SET username = ?,useremail = ?,userphone = ?,userbirth = ?,usergender = ?,useraddress = ? WHERE userid = ?";
	private final String sql_delete = "DELETE FROM users WHERE userId = ?";

	private Connection conn;
	private DataSource ds;
	private PreparedStatement pstat;
	
	public UserDAOImpl() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/BakeYourLife");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doCreate(User user) {
		// TODO Auto-generated method stub
		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(sql_create);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getUseremail());
			pstat.setString(3, user.getUserphone());
			pstat.setString(4, user.getUserbirth());
		    pstat.setString(5, user.getUsergender());
			pstat.setString(6, user.getUseraddress());
			pstat.executeUpdate();
			pstat.close();

		} catch (SQLException e) {
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(sql_findall);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUseremail(rs.getString("useremail"));
				user.setUserphone(rs.getString("userphone"));
				user.setUserbirth(rs.getString("userbirth"));
				user.setUsergender(rs.getString("usergender"));
				user.setUseraddress(rs.getString("useraddress"));
				list.add(user);
			}
			rs.close();
			pstat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}

	@Override
	public User findByUserid(int userId) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(sql_findbyuserid);
			pstat.setInt(1, userId);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {

				user = new User();
				user.setUserid(rs.getInt("userId"));
				user.setUsername(rs.getString("userName"));
				user.setUseremail(rs.getString("userEmail"));
				user.setUserphone(rs.getString("userPhone"));
				user.setUserbirth(rs.getString("userBirth"));
				user.setUsergender(rs.getString("userGender"));
				user.setUseraddress(rs.getString("userAddress"));
				
			}
			rs.close();
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
		
	}

	@Override
	public boolean deleteByUserid(int userId) {
		// TODO Auto-generated method stub
		boolean rowDeleted = false;
		try {
			conn = ds.getConnection();
			pstat = conn.prepareStatement(sql_delete);
			pstat.setInt(1, userId);
			pstat.execute();
			rowDeleted = pstat.executeUpdate() > 0;
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowDeleted;
	}

	@Override
	public boolean doUpdate(User user) {
		// TODO Auto-generated method stub
		boolean rowupdated = false;
		try {
			conn = ds.getConnection();
			pstat = null;
			pstat = conn.prepareStatement(sql_update);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getUseremail());
			pstat.setString(3, user.getUserphone());
			pstat.setString(4, user.getUserbirth());
		    pstat.setString(5, user.getUsergender());
			pstat.setString(6, user.getUseraddress());
			pstat.setInt(7, user.getUserid());
			pstat.executeUpdate();
			rowupdated = pstat.executeUpdate() > 0;
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowupdated;

	}
	
	
	
}