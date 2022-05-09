package com.usermanagement.dao;



public class usertest {

	public static void main(String[] args) {
		
		UserDaoImpl dao = new UserDaoImpl();
		System.out.println(dao.findAll());
		
		

	}

}
