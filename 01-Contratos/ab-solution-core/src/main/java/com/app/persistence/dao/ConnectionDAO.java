package com.app.persistence.dao;

import java.sql.Statement;

public interface ConnectionDAO {
	

	public abstract boolean successfulConnection();

	public abstract Statement geStatement();	
}