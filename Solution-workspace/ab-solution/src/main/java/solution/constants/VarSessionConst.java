package solution.constants;

public enum VarSessionConst {
	APPSESSION("AplicationSession");
	
	private String _var;
	
	VarSessionConst(String var) {
		this._var = var;
	}
	
	public String var() {
		return this._var;
	}
}