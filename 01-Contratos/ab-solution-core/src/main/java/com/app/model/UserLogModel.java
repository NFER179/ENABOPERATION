package com.app.model;

import com.app.model.dto.UserLogDTO;
import com.app.persistence.imp.UserLogImpl;

public class UserLogModel {
	
	private UserLogDTO _uldto;
	
	public UserLogModel() {
		this._uldto = new UserLogImpl();
	}
	
}