/**
 * 
 */
package com.component.tag;

import com.component.Component;

import interfaces.ComponentInt;

/**
 * @author NFERNANDEZ
 *
 */
public class TagComponent extends Component implements ComponentInt{

	private String _sTag = "";
	private String _sType = "";
	private String _sId = "";
	private String[] _asClass = {};
	private String _sClass = "";
	private String _sText = "";
	private String _sValue = "";
	
	private static String stag = "${tag}";
	private static String stype = " type='%s'";
	private static String sid = " id='%s'";
	private static String sclass = " class='%s'";
	private static String stext = "%s";
	private static String svalue = " value='%s'";
	
	//private String _sHtmlOpenClose = "<"+stag+" "+stype+sid+sclass+">"+stext+"</"+stag+">";
	private String _sHtmlOpenClose = "<%s%s>%s</%s>";
	private String _sHtmlOpenOnly = "<%s%s />";
	
	private String _sHtml = "";
	
	@Override
	public String getHtml() {
		return this._sHtml;
	}
	
	public void setTag(String tag) {
		this._sTag = tag;
	}

	public void setType(String type) {
		this._sType = String.format(stype, type);
	}
	
	public void setId(String Id) {
		this._sId = String.format(sid, Id);
	}
	
	public void setText(String text) {
		this._sText = String.format(stext, text);
	}
	
	public void setValue(String value) {
		this._sValue = String.format(svalue, value);
	}
	
	public void addClass(String className) {
		
	}
	
	public void addClasses(String... classesName) {
		
	}
	
	public void createHtmlElement(boolean openOnly) {
		String sProperties = "";
		
		if (openOnly) {
			sProperties += this._sType + this._sId + this._sClass + this._sValue;
			
			this._sHtml = String.format(this._sHtmlOpenOnly, this._sTag, sProperties);
		} else {
			sProperties += this._sType + this._sId + this._sClass;
			
			this._sHtml = String.format(this._sHtmlOpenClose, this._sTag, sProperties, this._sText, this._sTag);
		}
	}
}