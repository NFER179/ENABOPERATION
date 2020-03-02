package com.app.model;

import java.sql.ResultSet;

import com.app.constant.DataBaseConst;
import com.app.model.dto.UserDTO;

public class UserModel {
	
	public UserModel() {
	}

	public static UserDTO newUser(ResultSet rs) {
		
		UserDTO user = null;
		String sUserId, sPass, sRoleId, sMail, sCountry;
		
		try {
			sUserId = rs.getString(DataBaseConst.fldUserId.var());
			sPass = rs.getString(DataBaseConst.fldPass.var());
			sRoleId = rs.getString(DataBaseConst.fldRoleId.var());
			sMail = rs.getString(DataBaseConst.fldMail.var());
			sCountry = rs.getString(DataBaseConst.fldCountry.var());
			
			user = new UserDTO(sUserId, sPass, sRoleId, sMail, sCountry);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}