package com.app.model.dto;

/* User Data Transfer Object */
public class UserDTO {
	
	private String sUserId;
	private String sPass;
	private String sRoleName;
	private String sMail;
	private String sCountry;
	
	public UserDTO(String sUserId, String sPass, String sRoleName, String sMail, String sCountry) {
		this.sUserId = sUserId;
		this.sPass = sPass;
		this.sRoleName = sRoleName;
		this.sMail = sMail;
		this.sCountry = sCountry;
	}

	public String getsUserId() {
		return sUserId;
	}

	public void setsUserId(String sUserId) {
		this.sUserId = sUserId;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public String getsRoleName() {
		return sRoleName;
	}

	public void setsRoleName(String sRoleName) {
		this.sRoleName = sRoleName;
	}

	public String getsMail() {
		return sMail;
	}

	public void setsMail(String sMail) {
		this.sMail = sMail;
	}

	public String getsCountry() {
		return sCountry;
	}

	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}
}