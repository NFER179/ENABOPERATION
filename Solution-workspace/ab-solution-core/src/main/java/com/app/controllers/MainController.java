package com.app.controllers;

import com.app.model.dto.ConnectionDTO;

public class MainController {
	
	private PathController _pc;
	private DataBaseController _dbc;
	
	private String _sAbsoluteRootPath;
	
	private String _sClassName = this.getClass().getName();
	
	public MainController(String rootPath) {
		System.out.println("["+_sClassName+"] -> Start");
		
		System.out.println("["+_sClassName+"] -> Set root path.");
		this.setAbsoluteRootPath(rootPath);
		
		/* Load properties of data bases */
		System.out.println("["+_sClassName+"] -> Start read database from " + rootPath + ".");
		this._dbc = DataBaseController.getInstance();
		this._dbc.setDataBasePropertiesFrom(this._pc.getFile("solution.xml"));
		this._dbc.testDatabaseConnections();
		System.out.println("["+_sClassName+"] -> Load data bases: " + this._dbc.getConnectionStatus());
		
		System.out.println("["+_sClassName+"] -> End");
	}
	
	/**
	 * 
	 * @param path
	 */
	public void setAbsoluteRootPath(String path) {
		this._sAbsoluteRootPath = path;
		
		/*
		 * Start path controller */
		this._pc = PathController.getInstance(this._sAbsoluteRootPath);
	}
	
	/**
	 * 
	 */
	public String[] getDataBases() {
		return this._dbc.getDataBases();
	}
	
	public ConnectionDTO useDataBase(String dataBaseId) {
		this._dbc.useDataBase(dataBaseId);
		
		return this._dbc.getDataBaseInUse();
	}
}