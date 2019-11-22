package com.component.basic.structur;

import com.component.Component;
import com.component.tag.WebSubmit;

import enumeration.FormMethod;
import enumeration.FormTarget;

public class WebForm extends StructureComponent {
	
	private String _sOpenTag = "<form %s>";
	private String _sCloseTag = "</form>";
	private String _sHtml;
	private String _sMethod = "";
	private String _sStructure;
	private WebSubmit _ws;
	private boolean _bSubmit;
	
	public WebForm() {
		this._sHtml = String.format(this._sOpenTag, "") + "\n" + this._sCloseTag;
		this._sStructure = "";
		this._bSubmit = false;
	}
	
	public WebForm(String action, FormTarget target) {
		String properties = "action='" + action + "' target='" + target + "'";
		this._sHtml = String.format(this._sOpenTag, properties) + "\n%s" + this._sCloseTag;
		this._sStructure = "";
		this._bSubmit = false;
	}
	
	public WebForm(String action, FormMethod method) {
		String properties = "action='" + action + "' method='" + method + "'";
		this._sHtml = String.format(this._sOpenTag, properties) + "\n%s" + this._sCloseTag;
		this._sStructure = "";
		this._bSubmit = false;
	}
	
	public WebForm(String action, FormMethod method, FormTarget target) {
		String properties = "action='" + action + "' method='" + method + "' target='" + target + "'";
		this._sHtml = String.format(this._sOpenTag, properties) + "\n%s" + this._sCloseTag;
		this._sStructure = "";
		this._bSubmit = false;
	}

	public void setSubmit(String value, boolean submit) {
		this._ws = new WebSubmit(value);
		
		this._bSubmit = submit;
	}
	
	public void add(Component... component) {
		int iComponent;
		String structure = this._sStructure;
		
		for(iComponent = 0; iComponent < component.length; iComponent++) {
			structure += "\t" + component[iComponent].getHtml().replaceAll("\n", "\n\t") + "\n";
		}
		
		this._sStructure = structure;
	}
	
	@Override
	public String getHtml() {
		if (this._bSubmit)
			this._sStructure += "\t" + this._ws.getHtml() + "\n";
		
		return String.format(this._sHtml, this._sStructure);
	}
}