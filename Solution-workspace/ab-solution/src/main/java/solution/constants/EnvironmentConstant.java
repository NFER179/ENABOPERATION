package solution.constants;

public enum EnvironmentConstant {
	USER("user");
	
	private String _sVar;
	
	EnvironmentConstant(String var) {
		this._sVar = var;
	}
	
	public String var() {
		return this._sVar;
	}
}
