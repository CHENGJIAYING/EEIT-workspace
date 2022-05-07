package com.usermanagement.bean;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memno;
	private String mname;
	private String email;
	
	public User() {
		super();
	}
	public User(int memno, String mname, String email) {
		super();
		this.memno = memno;
		this.mname = mname;
		this.email = email;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
