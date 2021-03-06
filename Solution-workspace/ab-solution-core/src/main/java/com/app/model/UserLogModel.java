package com.app.model;


import com.app.manager.LogMng;
import com.app.model.dto.UserDTO;
import com.app.model.dto.UserLogDTO;
import com.app.persistence.dao.UserLogDAO;
import com.app.persistence.imp.UserLogImpl;

public class UserLogModel {
	
	private UserLogDAO _uldto;
	
	public UserLogModel() {
		this._uldto = new UserLogImpl();
	}
	
	public boolean existsUser(UserLogDTO userLog) {
		LogMng log = LogMng.getInstance();
		
		UserDTO user;
		boolean exists = false;
		
		user = this._uldto.getUser(userLog);
		
		if (user != null) {
			exists = true;
			log.write(this, LogMng.INFO, "user not null.");
		}
		
		return exists;
	}
	
	public UserDTO getUser(UserLogDTO userLog) {
		return null;
	}
}