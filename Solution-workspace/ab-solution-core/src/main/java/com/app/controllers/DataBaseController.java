package com.app.controllers;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.app.manager.LogMng;
import com.app.model.dto.ConnectionDTO;
import com.app.model.dto.ConnectionMySqlDTO;
import com.app.model.dto.ConnectionSqliteDTO;

public class DataBaseController {
	
	private static DataBaseController instance;
	private static String successful = "SUCCESSFUL", unsuccessful = "UNSUCCESSFUL";
	
	private Map<String, Properties> _mspDataBaseConfiguration;
	private ConnectionDTO _connection = null;
	private String _sConnectionStatus = successful;
	
	private DataBaseController() {
		this._mspDataBaseConfiguration = new HashMap<String, Properties>();
	}
	
	public static DataBaseController getInstance() {
		if (instance == null) {
			instance = new DataBaseController();
		}
		return instance;
	}

	public void setDataBasePropertiesFrom(File dataBaseConfiguration) {
		
		LogMng log = LogMng.getInstance();
		
		List<Node> lnConfiguration;
		NodeList nlConfigurationProperties;
		Node nPropertie;
		Properties pDataBaseConfiguration;
		String sName, sValue;
		
		lnConfiguration = XmlController.getXmlConfiguration(dataBaseConfiguration, "database");
		
		if(!lnConfiguration.isEmpty()) {
			for (Node nRoot: lnConfiguration) {
				/* ask if tag database have "active" attribute and this is "true". */
				if (nRoot.getAttributes().getNamedItem("active").getNodeValue().equals("true")) {
					pDataBaseConfiguration = new Properties();
					nlConfigurationProperties = nRoot.getChildNodes();
					for(int i = 0; i < nlConfigurationProperties.getLength(); i++) {
						nPropertie  = nlConfigurationProperties.item(i);
						if(nPropertie.hasChildNodes()) {
							/* Add values database properties into properties. */
							sName = nPropertie.getNodeName();
							sValue = nPropertie.getChildNodes().item(0).getNodeValue();
							pDataBaseConfiguration.put(sName, sValue);
						}
					}
					this._mspDataBaseConfiguration.put(pDataBaseConfiguration.getProperty("name"), pDataBaseConfiguration);
				}
			}
		} else {
			log.write(this, LogMng.INFO, "No existe configuración de base de datos.");
		}
	}
	
	public void setDataBasePropertiesFrom(List<Node> nodes) {
		
		LogMng log = LogMng.getInstance();
		
		NodeList nlConfigurationProperties;
		Node nPropertie;
		Properties pDataBaseConfiguration;
		String sName, sValue;
		
		if(!nodes.isEmpty()) {
			for (Node nRoot: nodes) {
				/* ask if tag database have "active" attribute and this is "true". */
				if (nRoot.getAttributes().getNamedItem("active").getNodeValue().equals("true")) {
					pDataBaseConfiguration = new Properties();
					nlConfigurationProperties = nRoot.getChildNodes();
					for(int i = 0; i < nlConfigurationProperties.getLength(); i++) {
						nPropertie  = nlConfigurationProperties.item(i);
						if(nPropertie.hasChildNodes()) {
							/* Add values database properties into properties. */
							sName = nPropertie.getNodeName();
							sValue = nPropertie.getChildNodes().item(0).getNodeValue();
							pDataBaseConfiguration.put(sName, sValue);
						}
					}
					this._mspDataBaseConfiguration.put(pDataBaseConfiguration.getProperty("name"), pDataBaseConfiguration);
				}
			}
		} else {
			log.write(this, LogMng.INFO, "No existe configuración de base de datos.");
		}
	}

	public String[] getDataBases() {
		
		String[] sDataBasesNames = new String[this._mspDataBaseConfiguration.size()];
		int i = 0;
		
		for(Map.Entry<String, Properties> entry: this._mspDataBaseConfiguration.entrySet()) {
			sDataBasesNames[i] = entry.getKey();
			i++;
		}
		
		return sDataBasesNames;
	}

	public void testDatabaseConnections() {
		this._mspDataBaseConfiguration.forEach(
			(k, v) -> this.testDataBase(k, v)
		);
	}
	
	private void testDataBase(String name, Properties p) {
		LogMng log = LogMng.getInstance();
		
		log.write(this, LogMng.INFO, "Start test connection of data base: " + name);
		
		if (this.propertiesConnectionAreOkTo(name)) {
			log.write(this, LogMng.INFO, "Connection: OK");
		} else {
			this._sConnectionStatus = unsuccessful;
			log.write(this, LogMng.INFO, "Connection: Faile");
		}
		log.write(this, LogMng.INFO, "End test connection of data base.");
	}
	
	private boolean propertiesConnectionAreOkTo(String dataBaseName) {
		
		ConnectionDTO connection;
		Properties properties = this._mspDataBaseConfiguration.get(dataBaseName);
		boolean bConnectionOk = false;
		
		connection = this.getConnection(properties);
		if(connection != null) {
			if (connection.successfulConnection()) {
				bConnectionOk = true;
			}
		}
		
		return bConnectionOk;
	}
	
	/**
	 * 
	 */
	private ConnectionDTO getConnection(Properties databaseProperties) {
		
		LogMng log = LogMng.getInstance();
		
		ConnectionDTO connection;
		
		switch(databaseProperties.getProperty("engine").toUpperCase()) {
			case "SQLITE":
				log.write(this, LogMng.INFO, "Get Connection sqlite.");
				connection = new ConnectionSqliteDTO(databaseProperties);
				break;
			case "MYSQL":
				log.write(this, LogMng.INFO, "Get Connection MySql.");
				connection = new ConnectionMySqlDTO(databaseProperties);
				break;
			default:
				log.write(this, LogMng.INFO, "No engine declare.");
				connection = null;
		}
		
		return connection;
	}

	/**
	 * 
	 * @return
	 */
	public String getConnectionStatus() {
		return this._sConnectionStatus;
	}
	
	/**
	 * 
	 * @param databaseid
	 */
	public void useDataBase(String databaseid) {
		
		LogMng log = LogMng.getInstance();
		
		Properties pDataBase;
		
		pDataBase = this._mspDataBaseConfiguration.get(databaseid);
		log.write(this, LogMng.INFO, "Get database: " + databaseid);
		this._connection = this.getConnection(pDataBase);
	}
	
	public ConnectionDTO getDataBaseInUse() {
		return this._connection;
	}
}