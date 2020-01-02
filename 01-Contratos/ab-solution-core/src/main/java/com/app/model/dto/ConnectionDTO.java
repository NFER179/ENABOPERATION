package com.app.model.dto;

public class ConnectionDTO {
	
	private String sDataBaseName;
	private String sDBUser;
	private String sDBPass;
	private String sUrl;
	
	public ConnectionDTO(String sDataBaseName, String sDBUser, String sDBPass, String sUrl) {
		super();
		this.sDataBaseName = sDataBaseName;
		this.sDBUser = sDBUser;
		this.sDBPass = sDBPass;
		this.sUrl = sUrl;
	}

	public String getsDataBaseName() {
		return sDataBaseName;
	}

	public void setsDataBaseName(String sDataBaseName) {
		this.sDataBaseName = sDataBaseName;
	}

	public String getsDBUser() {
		return sDBUser;
	}

	public void setsDBUser(String sDBUser) {
		this.sDBUser = sDBUser;
	}

	public String getsDBPass() {
		return sDBPass;
	}

	public void setsDBPass(String sDBPass) {
		this.sDBPass = sDBPass;
	}

	public String getsUrl() {
		return sUrl;
	}

	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}
}