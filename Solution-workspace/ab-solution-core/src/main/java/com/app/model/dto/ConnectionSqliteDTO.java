package com.app.model.dto;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import com.app.manager.LogMng;

public class ConnectionSqliteDTO extends ConnectionDTO {

	public ConnectionSqliteDTO(Properties properties) {
		super(properties);
	}
	
	public ConnectionSqliteDTO(String sUrl, String sDataBaseName, String sDBUser, String sDBPass) {
		super(sUrl, sDataBaseName, sDBUser, sDBPass);
	}

	/**
	 * 
	 */
	@Override
	public boolean successfulConnection() {
		
		LogMng log = LogMng.getInstance();
		
		Connection conn = null;
		String url = "jdbc:sqlite:" + this.getsUrl() + File.separator + this.getsDataBaseName(); 
		boolean successful = false;
		
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			conn = DriverManager.getConnection(url);
			
			successful = true;
		}
		catch(Exception e) {
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
				log.writeError(this, e.toString(), e.getStackTrace());
			}
		}
		
		return successful;
	}

	@Override
	public Statement geStatement() {
		Statement stm = null;
		Connection conn = null;
		String url = "jdbc:slqite:" + this.getsUrl() + File.separator + this.getsDataBaseName(); 
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			
			stm = conn.createStatement();
		} catch(Exception e) {
			LogMng log = LogMng.getInstance();
			log.writeError(this, e.toString(), e.getStackTrace());
		}
		
		return stm;
	}

}