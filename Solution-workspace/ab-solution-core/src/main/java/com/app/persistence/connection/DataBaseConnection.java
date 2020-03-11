package com.app.persistence.connection;

import java.sql.Statement;

import com.app.controllers.DataBaseController;
import com.app.manager.LogMng;
import com.app.model.dto.ConnectionDTO;

public class DataBaseConnection {
	
	private ConnectionDTO connection;
	private Statement stm;
	
	public DataBaseConnection() {
		DataBaseController dbCtr = DataBaseController.getInstance();
		this.connection = dbCtr.getDataBaseInUse();
		
		this.stm = null;
	}
	
	public Statement getStatement() {
		LogMng log = LogMng.getInstance();
		
		if (this.stm == null) {
			log.write(this, LogMng.INFO, "stm was null");
			this.stm = this.connection.geStatement();
		}
		
		return this.stm;
	}
}