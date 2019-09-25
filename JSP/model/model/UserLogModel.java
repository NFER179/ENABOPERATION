package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;
import dto.UserLog;

public class UserLogModel {

	public static boolean logIn(UserLog uLog) {
		/* Tiene que llamar a la base de datos. */
		/* Trata la conexion a la base de datos. */
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FND_USERS_TBL WHERE USER_ID = '" + uLog.getNick() + "'");
			while(rs.next()) {
				if (rs.getString("USER_ID").equals(uLog.getNick())) {
					System.out.print("Usuario encontrado.");
					if(rs.getString("USER_PWD").equals(uLog.getPass())) {
						return true;
					}
				}
			}
			con.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas en la conexión con la base de datos.");
			return true;
		}
	}
	
	public static UserLog newUser(UserLog usuario) {
		return usuario;
	}
}
