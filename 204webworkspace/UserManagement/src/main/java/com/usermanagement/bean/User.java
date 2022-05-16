package com.usermanagement.bean;


import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userid;
	private String username;
	private String useremail;
	private String userphone;
	private String userbirth;
	private String usergender;
	private String useraddress;
	
	
	public User() {
		super();
	}


	public User(String username, String useremail, String userphone, String userbirth, String usergender,
			String useraddress) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
		this.userbirth = userbirth;
		this.usergender = usergender;
		this.useraddress = useraddress;
	}


	public User(int userid, String username, String useremail, String userphone, String userbirth, String usergender,
			String useraddress) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
		this.userbirth = userbirth;
		this.usergender = usergender;
		this.useraddress = useraddress;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getUserphone() {
		return userphone;
	}


	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}


	public String getUserbirth() {
		return userbirth;
	}


	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}


	public String getUsergender() {
		return usergender;
	}


	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}


	public String getUseraddress() {
		return useraddress;
	}


	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}