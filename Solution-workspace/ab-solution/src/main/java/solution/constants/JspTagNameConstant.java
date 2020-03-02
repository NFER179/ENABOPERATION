package solution.constants;

public enum JspTagNameConstant {
	DATABASEID("databaseid"),
	PASSWROD("userpss"),
	USERID("userid");
	
	private String _sVar;
	
	JspTagNameConstant(String var) {
		this._sVar = var;
	}
	
	public String var() {
		return this._sVar;
	}
}