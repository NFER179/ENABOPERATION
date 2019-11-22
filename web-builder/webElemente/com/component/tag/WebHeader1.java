package com.component.tag;

public class WebHeader1 extends TagComponent {
	
	public WebHeader1(String text) {
		super.setTag("h1");
		super.setText(text);
		super.createHtmlElement(false);
	}
}