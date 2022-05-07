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
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstat;

	public UserDaoImpl() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/UserDB");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doCreate(User user) {

		try {
			String sql_create = "INSERT INTO users (memno,mname,email)";
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_create);
			pstat.setInt(1, user.getMemno());
			pstat.setString(2, user.getMname());
			pstat.setString(3, user.getEmail());
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
	public List<User> findAll() throws Exception {

		List<User> list = new ArrayList<User>();
		try {
			String sql_findall = "SELECT * FROM users";
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_findall);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setMemno(rs.getInt("memno"));
				user.setMname(rs.getString("mname"));
				user.setEmail(rs.getString("email"));
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
	public User findByMemno(int memno) throws Exception {
		User user = new User();
		try {
			String sql_findbymemno = "SELECT * FROM users WHERE memno=?";
			con = ds.getConnection();
			pstat = con.prepareStatement(sql_findbymemno);
			pstat.setInt(1, memno);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				user.setMemno(rs.getInt("memno"));
				user.setMname(rs.getString("mname"));
				user.setEmail(rs.getString("email"));
				

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
	public void deleteByMemno(int memno) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean doupdate(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


}
