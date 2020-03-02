package com.app.controllers;

import java.io.File;
import java.util.HashMap;

public class PathController {
	
	private static PathController instance;
	private static String fs = File.separator;
	private String _sPath;
	private HashMap<String, String> _hmPaths;
	
	private PathController(String path) {
		this._sPath = path;
		this._hmPaths = new HashMap<String, String>();
		String solutionKey = "solution.xml";
		this._hmPaths.put(solutionKey, "WEB-INF" + fs + "conf" + fs + solutionKey);
	}
	
	public static PathController getInstance(String path) {
		if (instance == null) {
			instance = new PathController(path);
		}
		return instance;
	}
	
	public String getRootPath() {
		return this._sPath;
	}

	public File getFile(String fileName) {
		File f = new File(this._sPath + fs + this._hmPaths.get(fileName));
		if (f.exists()) {
			return f;
		}else {
			return null;
		}
	}
}