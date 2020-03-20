package com.app.controllers;

import com.app.utils.TreeStructure;

public class FilesController {

	private TreeStructure<String> _ts;
	
	private static FilesController instance;
	
	private FilesController() {
		this._ts = new TreeStructure<String>();
	}
	
	public static FilesController getInstance() {
		if (instance == null) {
			instance = new FilesController();
		}
		return instance;
	}
	
	public void getStructureFrom(String Path) {
		
		
	}
}