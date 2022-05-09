package com.usermanagement.bean;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private String uname;
	private String uemail;
	private String uphone;
	private String ubirth;
	private String ugender;
	private String uaddess;

	public User() {
		super();
	}

	public User(int userid, String uname, String uemail, String uphone, String ubirth, String ugender, String uaddess) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.ubirth = ubirth;
		this.ugender = ugender;
		this.uaddess = uaddess;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public String getUaddess() {
		return uaddess;
	}

	public void setUaddess(String uaddess) {
		this.uaddess = uaddess;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
