package com.component.tag;

import enumeration.TagName;

public class WebSubmit extends TagComponent {
	
	public WebSubmit(String value) {
		super.setTag(TagName.INPUT.getTag());
		super.setType("submit");
		super.setValue(value);
		super.createHtmlElement(true);
	}
}
