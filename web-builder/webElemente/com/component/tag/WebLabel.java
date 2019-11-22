package com.component.tag;

public class WebLabel extends TagComponent {
	
	public WebLabel(String text) {
		super.setTag("label");
		super.setText(text);
		super.createHtmlElement(false);
	}
	
}
