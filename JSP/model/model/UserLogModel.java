package model;

import dto.UserLog;

public class UserLogModel {

	public static boolean logIn(UserLog uLog) {
		/* Tiene que llamar a la base de datos. */
		return true;
	}
	
	public static UserLog newUser(UserLog usuario) {
		return usuario;
	}
}
