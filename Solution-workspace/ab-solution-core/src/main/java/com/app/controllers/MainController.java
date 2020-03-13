package com.app.controllers;

import java.io.File;
import java.util.List;

import org.w3c.dom.Node;

import com.app.manager.LogMng;
import com.app.model.dto.ConnectionDTO;

public class MainController {
	
	private PathController _pc;
	private DataBaseController _dbc;
	
	private LogMng _log;
	private FilesController _jspCtr;
	private String _sAbsoluteRootPath;
	
	private String _sClassName = this.getClass().getSimpleName();
	
	public MainController(String rootPath) {
		
		System.out.println("["+_sClassName+"] -> Start");
		System.out.println("["+_sClassName+"] -> Set root path.");
		this.setAbsoluteRootPath(rootPath);
		System.out.println("["+_sClassName+"] -> End root path.");
		
		/* File configuration. */
		File fConfiguration = this._pc.getFile("solution.xml");
		
		/* Get nodes configuration to each configuration. */
		// maybe a list map is better 
		List<Node> lnLogs = XmlController.getXmlConfiguration(fConfiguration, "log");
		List<Node> lnDataBases = XmlController.getXmlConfiguration(fConfiguration, "database");
		
		/* Load log configuration. */
		this._log = LogMng.getInstance();
		this._log.setLog(lnLogs);
		
		this._log.write(this, LogMng.INFO, "Log load: OK");
		
		/* Load file structure. */
		this._jspCtr = FilesController.getInstance();
		
		/* Load properties of data bases */
		this._log.write(this, LogMng.INFO, "Start read database from " + rootPath + ".");
		this._dbc = DataBaseController.getInstance();
		//this._dbc.setDataBasePropertiesFrom(fConfiguration);
		this._dbc.setDataBasePropertiesFrom(lnDataBases);
		this._dbc.testDatabaseConnections();
		this._log.write(this, LogMng.INFO, "Load data bases: " + this._dbc.getConnectionStatus());
		
		this._log.write(this, LogMng.INFO, "End");
	}
	
	public void writeLog(Object object, String logType, String msg) {
		this._log.write(object, logType, msg);
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