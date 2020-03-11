package com.app.manager;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LogMng {
	
	private static LogMng instance;
	public static String INFO = "info";
	public static String DEBUG = "debug";
	public static String ALL = "all";
	public static String ERROR = "error";
	
	private Map<String, String> mapLog;
	
	private LogMng() {
		this.mapLog = new HashMap<String, String>();
	}
	
	public static LogMng getInstance() {
		if (instance == null) {
			instance = new LogMng();
		}
		
		return instance;
	}
	
	public void setLog(List<Node> nodes) {
		
		NodeList nl;
		Node n;
		String sAttributeValue_LogType = "", sPath = "";
		
		if(!nodes.isEmpty()) {
			for (Node nRoot: nodes) {
				/* ask if tag database have "active" attribute and this is "true". */
				sAttributeValue_LogType = nRoot.getAttributes().getNamedItem("logType").getNodeValue();
				if (!sAttributeValue_LogType.equals("none")) {
					nl = nRoot.getChildNodes();
					for(int i = 0; i < nl.getLength(); i++) {
						n  = nl.item(i);
						if(n.hasChildNodes()) {
							/* Add path of log associate to type of log. */
							sPath = n.getChildNodes().item(0).getNodeValue();
							this.mapLog.put(sAttributeValue_LogType, sPath);
							this.createFileLogIfNotExists(sPath);
							this.write(this, sAttributeValue_LogType, "Set log type: " + sAttributeValue_LogType);
							this.write(this, sAttributeValue_LogType, "Set log path: " + sPath);
						}
					}
				}
			}
		} else {
			this.write(this, "none", "No hay configuración para el log.");
		}
	}
	
	private void createFileLogIfNotExists(String sPath){
		File f;
		
		try {
			f = new File(sPath);
			if (f.exists()) {
				f.delete();
				f.createNewFile();
			}
			else {
				f.createNewFile();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void write(Object object, String logType, String msg) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		FileWriter wr;
		String path = this.mapLog.get(logType);
		File flog;
		
		if (path != null) {
			try {
				flog = new File(path);
				
				wr = new FileWriter(flog, true);
				wr.append("[" + logType + "] [" + dtf.format(now) + "] - [" + object.getClass().getSimpleName() + "] -> " + msg);
				wr.write(13);
				wr.close();
			} catch(Exception e) {
				//e.printStackTrace();
			}
		} else {
			System.out.println("[" + logType + "] [" + dtf.format(now) + "] - [" + object.getClass().getSimpleName() + "] -> " + msg);
		}
	}
	
	public void writeError(Object object, String msg) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		FileWriter wr;
		
		File flog;
		
		for (Map.Entry<String, String> entry : this.mapLog.entrySet()) {
			try { 
				flog = new File(entry.getValue());
				
				wr = new FileWriter(flog, true);
				wr.append("[" + ERROR + "] [" + dtf.format(now) + "] - [" + object.getClass().getSimpleName() + "] -> " + msg);
				wr.write(13);
				
				wr.close();
			} catch(Exception e) {
				//e.printStackTrace();
			}
		}
	}
	
	public void writeError(Object object, String msg, StackTraceElement[] msgs) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		FileWriter wr;
		
		File flog;
		
		for (Map.Entry<String, String> entry : this.mapLog.entrySet()) {
			try { 
				flog = new File(entry.getValue());
				
				wr = new FileWriter(flog, true);

				wr.write("[" + ERROR + "] [" + dtf.format(now) + "] - [" + object.getClass().getSimpleName() + "] -> " + msg);
				wr.write(13);
				for (StackTraceElement str: msgs) { 
					wr.write("\t" + str);
					wr.write(13);
				}
				
				wr.close();
			} catch(Exception e) {
				//e.printStackTrace();
			}
		}
	}

}