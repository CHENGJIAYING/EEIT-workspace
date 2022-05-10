package com.usermanagement.dao;

import java.sql.Connection;

import java.util.List;

import com.usermanagement.bean.User;

public interface UserDao {
	public Connection getConnection() throws Exception;

	public void doCreate(User user);

	public List<User> findAll();

	public User findByUserid(int Userid);

	public boolean deleteByUserid(int Userid);

	public boolean doUpdate(User user);
}
