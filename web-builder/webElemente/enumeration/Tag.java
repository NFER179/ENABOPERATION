package enumeration;

public enum Tag {
	
	BR("</br>");
	
	private String _sTag;
	
	private Tag(String tag) {
		this._sTag = tag;
	}
	
	public String tag() {
		return this._sTag;
	}
}