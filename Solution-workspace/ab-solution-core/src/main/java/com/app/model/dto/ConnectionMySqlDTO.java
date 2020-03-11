package com.app.model.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import com.app.manager.LogMng;

public class ConnectionMySqlDTO extends ConnectionDTO {

	public ConnectionMySqlDTO(Properties dataBaseProperties) {
		super(dataBaseProperties);
		// TODO Auto-generated constructor stub
	}
	
	public ConnectionMySqlDTO(String sUrl, String sDataBaseName, String sDBUser, String sDBPass) {
		super(sUrl, sDataBaseName, sDBUser, sDBPass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean successfulConnection() {
		
		LogMng log = LogMng.getInstance();
		
		Connection conn = null;
		String url = "jdbc:mysql://" + this.getsUrl() + "/" + this.getsDataBaseName() + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
		boolean successful = false;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, this.getsDBUser(), this.getsDBPass());
			
			successful = true;
		}
		catch(Exception e) {
			log.writeError(this, url);
			log.writeError(this, e.toString(), e.getStackTrace());
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
					log.write(this, LogMng.INFO, "conn close");
				}
			} catch(Exception e) {
				log.writeError(this, e.getMessage());
			}
		}
		
		return successful;
	}

	@Override
	public Statement geStatement() {
		Statement stm = null;
		Connection conn = null;
		String url = "jdbc:mysql://" + this.getsUrl() + "/" + this.getsDataBaseName() + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, this.getsDBUser(), this.getsDBPass());
			
			stm = conn.createStatement();
		} catch(Exception e) {
			LogMng log = LogMng.getInstance();
			log.writeError(this, e.getMessage(), e.getStackTrace());
			e.printStackTrace();
		}
		
		return stm;
	}

}
