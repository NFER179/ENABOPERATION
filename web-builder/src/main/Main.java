package main;

import builder.HTMLBuilder;
import testcomponents.MainBuilder;

public class Main {

	public static void main(String[] args) {
		
		HTMLBuilder htmlb = new MainBuilder();
		
		htmlb.InitComponents();
		
		System.out.println(htmlb.GetHTML());
	}
}