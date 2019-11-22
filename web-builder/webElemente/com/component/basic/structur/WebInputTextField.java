package com.component.basic.structur;

import com.component.tag.WebLabel;
import com.component.tag.WebTextField;

import enumeration.Tag;

public class WebInputTextField extends StructureComponent {
	
	private String _sHtml = "<div>\n%s</div>";
	private WebLabel _wl;
	private WebTextField _wtf;
	private String _sLabel;
	private String _sStructure;
	
	public WebInputTextField(String label) {
		this._sLabel = label;
		
		this._wl = new WebLabel(this._sLabel);
		this._wtf = new WebTextField();
		
		this._sStructure = "\t" + this._wl.getHtml() + "\n";
		this._sStructure += "\t" + Tag.BR.tag() + "\n";
		this._sStructure += "\t" + this._wtf.getHtml()+ "\n";
	}
	
	@Override
	public String getHtml() {
		return String.format(this._sHtml, _sStructure);
	}
}