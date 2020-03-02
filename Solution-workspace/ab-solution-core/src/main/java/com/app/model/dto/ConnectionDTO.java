package com.app.model.dto;

import java.io.File;
import java.util.Properties;

import com.app.persistence.dao.ConnectionDAO;

public abstract class ConnectionDTO implements ConnectionDAO {
	
	private String sUrl;
	private String sDataBaseName;
	private String sDBUser;
	private String sDBPass;
	
	public ConnectionDTO(Properties dataBaseProperties) {
		this.sUrl = dataBaseProperties.getProperty("url");
		this.sDataBaseName = dataBaseProperties.getProperty("databasename");
		this.sDBUser = dataBaseProperties.getProperty("user");
		this.sDBPass = dataBaseProperties.getProperty("password");
	}
	
	public ConnectionDTO(String sUrl, String sDataBaseName, String sDBUser, String sDBPass) {
		this.sUrl = sUrl;
		this.sDataBaseName = sDataBaseName;
		this.sDBUser = sDBUser;
		this.sDBPass = sDBPass;
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
		return sUrl.replace("/", File.separator).replace("\\", File.separator);
	}

	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}

}