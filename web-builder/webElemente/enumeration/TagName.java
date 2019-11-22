package enumeration;

public enum TagName {
	
	INPUT("input");
	
	private String value;
	
	TagName(String value) {
		this.value = value;
	}
	
	public String getTag() {
		return this.value;
	}
}
