package com.usermanagement.dao;

import java.util.List;

import com.usermanagement.bean.User;

public interface UserDao {
	
	public void doCreate(User user); 
	public List<User> findAll()throws Exception;
	public User findByMemno(int memno)throws Exception; 
	public void deleteByMemno(int memno);
	public boolean doupdate(User user)throws Exception; 
}
