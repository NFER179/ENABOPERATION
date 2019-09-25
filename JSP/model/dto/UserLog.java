package dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;

public class UserLog {

	private String _sNick;
	private String _sPass;
	private String _sName;
	private String _sPhoto;
	
	public UserLog(String nick, String pass) {
		this._sNick = nick;
		this._sPass = pass;
		
		/* Trata la conexion a la base de datos. */
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FND_USERS_TBL WHERE USER_ID = '" + this._sNick + "'");
			while(rs.next()) {
				this._sName = rs.getString("LAST_NAME") + ", " + rs.getString("FIRST_NAME") + " " + rs.getString("SECOND_NAME");
				this._sPhoto = rs.getString("PHOTO");
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas en la conexión con la base de datos.");
		}
	}

	public String getNick() {
		return _sNick;
	}

	public void setNick(String nick) {
		this._sNick = nick;
	}

	public String getPass() {
		return _sPass;
	}

	public void setPass(String pass) {
		this._sPass = pass;
	}
	
	public String getName() {
		return this._sName;
	}
	
	public void setName(String name) {
		this._sName = name;
	}
	
	public String getPhoto() {
		return this._sPhoto;
	}
	
	public void setPhoto(String photo) {
		this._sPhoto = photo;
	}
}