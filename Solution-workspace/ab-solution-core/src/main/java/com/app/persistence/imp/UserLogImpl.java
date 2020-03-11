package com.app.persistence.imp;

import java.sql.ResultSet;
import java.sql.Statement;

import com.app.constant.DataBaseConst;
import com.app.manager.LogMng;
import com.app.model.UserModel;
import com.app.model.dto.UserDTO;
import com.app.model.dto.UserLogDTO;
import com.app.persistence.connection.DataBaseConnection;
import com.app.persistence.dao.UserLogDAO;

public class UserLogImpl implements UserLogDAO {

	private DataBaseConnection connection;
	
	public UserLogImpl() {
		connection = new DataBaseConnection();
	}
	
	@Override
	public UserDTO getUser(UserLogDTO userLog) {
		
		LogMng log = LogMng.getInstance();
		
		Statement stm;
		String sqlString = "SELECT * FROM " + DataBaseConst.tbl_user.var();
		ResultSet rs;
		UserDTO user = null;
		
		try {
			stm = this.connection.getStatement();
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				user = UserModel.newUser(rs);
			}
			
		} catch(Exception e) {
			log.writeError(this, e.toString(), e.getStackTrace());
		}
			
		return user;
	}
}