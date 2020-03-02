package com.app.persistence.dao;

import com.app.model.dto.UserDTO;
import com.app.model.dto.UserLogDTO;

public interface UserLogDAO {
	
	/**
	 * @author nfernandez
	 * @param user log data
	 */
	public UserDTO getUser(UserLogDTO userLog);
}