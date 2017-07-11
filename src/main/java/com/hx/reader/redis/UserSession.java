package com.hx.reader.redis;

import java.io.Serializable;

public class UserSession implements Serializable{

	private static final long serialVersionUID = -6011241820070393952L;
	
	private String userid;
	
	private String sessionid;

	public UserSession(){
		
	}
	
	public UserSession(String userid, String sessionid) {
		super();
		this.userid=userid;
		this.sessionid = sessionid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
}
