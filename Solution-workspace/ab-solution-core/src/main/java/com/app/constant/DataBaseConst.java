package com.app.constant;

public enum DataBaseConst {
	tbl_user("AB_USER_TBL"), 
	
	fldCountry(""),
	fldMail(""),
	fldPass("PWD"),
	fldRoleId("ROLE_ID"),
	fldUserId("USER_ID"),
	;
	
	private String _var;
	
	DataBaseConst(String var) {
		this._var = var;
	}
	
	public String var() {
		return this._var;
	}
}