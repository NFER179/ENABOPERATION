package com.app.persistence.connection;

import java.sql.Statement;

import com.app.controllers.DataBaseController;
import com.app.model.dto.ConnectionDTO;

public class DataBaseConnection {
	
	private ConnectionDTO connection;
	private Statement stm;
	
	public DataBaseConnection() {
		DataBaseController dbCtr = DataBaseController.getInstance();
		this.connection = dbCtr.getDataBaseInUse();
	}
	
	public Statement getStatement() {
		if (this.stm == null) {
			this.stm = this.connection.geStatement();
		}
		
		return this.stm;
	}
}