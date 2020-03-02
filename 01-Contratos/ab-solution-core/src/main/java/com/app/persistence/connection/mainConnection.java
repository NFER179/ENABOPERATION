package com.app.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mainConnection {

	public static void main(String[] args) {
	 	String url = "C:\\Users\\NFERNANDEZ\\Desktop\\Herramientas\\01-DB\\SQLiteStudio\\ENAB-SCHEMA-V01.db";
		Connection connect;
		
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:"+url);
			if (connect!=null) {
				System.out.println("Conectado");
			}
			connect.close();
		}catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
		}
	}
}