package com.app.model.dto;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

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
		
		Connection conn = null;
		String url = "jdbc:sqlite:" + this.getsUrl() + File.separator + this.getsDataBaseName(); 
		boolean successful = false;
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			
			successful = true;
		}
		catch(Exception e) {
			System.out.println(url);
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				
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
			e.printStackTrace();
		}
		
		return stm;
	}

}