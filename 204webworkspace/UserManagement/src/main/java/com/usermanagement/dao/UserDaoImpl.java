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

import com.usermanagement.bean.User;

public class UserDaoImpl implements UserDao {

	private final String sql_create = "INSERT INTO users (userid,uname,uemail,uphone,ubirth,ugender,uaddess) VALUES(?,?,?,?,?,?,?)";
	private final String sql_findall = "SELECT * FROM users";
	private final String sql_findbyuserid = "SELECT * FROM users WHERE userid=?";
	private final String sql_update = "UPDATE users SET uname = ?,uemail = ?,uphone = ?,ubirth = ?,ugender = ?,uaddress = ? WHERE userId = ?";
	private final String sql_delete = "DELETE FROM users WHERE userid = ?";

	private Connection con;
	private DataSource ds;
	private PreparedStatement pstat;

	public UserDaoImpl() {
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

		try {
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_create);
			pstat.setInt(1, user.getUserid());
			pstat.setString(2, user.getUname());
			pstat.setString(3, user.getUemail());
			pstat.setString(4, user.getUphone());
			pstat.setString(5, user.getUbirth());
			pstat.setString(6, user.getUgender());
			pstat.setString(7, user.getUaddess());
			pstat.executeUpdate();
			pstat.close();

		} catch (SQLException e) {
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<User> findAll() {

		List<User> list = new ArrayList<User>();
		try {
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_findall);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUname(rs.getString("uname"));
				user.setUemail(rs.getString("uemail"));
				user.setUphone(rs.getString("uphone"));
				user.setUbirth(rs.getString("ubirth"));
				user.setUgender(rs.getString("ugender"));
				user.setUaddess(rs.getString("uaddess"));
				list.add(user);

			}
			rs.close();
			pstat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public User findByUserid(int userid) {
		User user = new User();
		try {
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_findbyuserid);
			pstat.setInt(1, userid);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setUname(rs.getString("uname"));
				user.setUemail(rs.getString("uemail"));
				user.setUphone(rs.getString("uphone"));
				user.setUbirth(rs.getString("ubirth"));
				user.setUgender(rs.getString("ugender"));
				user.setUaddess(rs.getString("uaddess"));

			}
			rs.close();
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public boolean doUpdate(User user) {
		boolean rowupdated = false;
		try {
			con = ds.getConnection();
			pstat = null;
			pstat = con.prepareStatement(sql_update);
			pstat.setString(1, user.getUname());
			pstat.setString(2, user.getUemail());
			pstat.setString(3, user.getUphone());
			pstat.setString(4, user.getUbirth());
			pstat.setString(5, user.getUgender());
			pstat.setString(6, user.getUaddess());
			pstat.setInt(7, user.getUserid());
			pstat.executeUpdate();
			rowupdated = pstat.executeUpdate() > 0;
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowupdated;

	}

	@Override
	public boolean deleteByUserid(int userid) {
		boolean rowDeleted = false;
		try {
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_delete);
			pstat.setInt(1, userid);
			pstat.execute();
			rowDeleted = pstat.executeUpdate() > 0;
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowDeleted;

	}

}
