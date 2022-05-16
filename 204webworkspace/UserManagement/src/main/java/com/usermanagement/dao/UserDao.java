package com.usermanagement.dao;

import java.util.List;

import com.usermanagement.bean.User;

public interface UserDao {

	public void doCreate(User user);

	public List<User> findAll();

	public User findByUserid(int UserId);

	public boolean deleteByUserid(int UserId);

	public boolean doUpdate(User user);
}
