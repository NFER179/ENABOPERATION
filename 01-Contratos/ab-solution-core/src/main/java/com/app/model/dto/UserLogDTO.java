package com.app.model.dto;

public class UserLogDTO {
	
	private String sUserName;
	private String sUserPass;
	
	public UserLogDTO(String sUserName, String sUserPass) {
		super();
		this.sUserName = sUserName;
		this.sUserPass = sUserPass;
	}

	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}

	public String getsUserPass() {
		return sUserPass;
	}

	public void setsUserPass(String sUserPass) {
		this.sUserPass = sUserPass;
	}
}