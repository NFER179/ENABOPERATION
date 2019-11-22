package com.component.tag;

public class WebTextField extends TagComponent {
	
	public WebTextField() {
		super.setTag("input");
		super.setType("text");
		super.createHtmlElement(true);
	}
}