package com.app.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlController {

	public static List<Node> getXmlConfiguration(File xmlFile, String nodeName) {

		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		NodeList nl;
		List<Node> nlConfiguration = new ArrayList<Node>();
		
		dbf = DocumentBuilderFactory.newInstance();
		
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(xmlFile);
			doc.getDocumentElement().normalize();
			nl = doc.getChildNodes();
			
			nlConfiguration = XmlController.getNode(nl, nodeName);
			//nlConfiguration = XmlController.getNodeTest(nl, nodeName, "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nlConfiguration;
	}
	
	public static List<Node> getNode(NodeList nodeList, String value) {
		
		List<Node> lnNodes = new ArrayList<Node>();
		List<Node> lnRecursion = new ArrayList<Node>();
		Node node;
		int i;
		
		for(i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			
			if (node.hasChildNodes()) {
				if (node.getNodeName().equals(value)) {
					lnNodes.add(node);
				} else {
					lnRecursion = XmlController.getNode(node.getChildNodes(), value); 
					if(!lnRecursion.isEmpty()) {
						lnNodes.addAll(lnRecursion);
					}
				}
			}
		}
		return lnNodes;
	}
	
	public static List<Node> getNodeTest(NodeList nodeList, String value, String tab) {
		
		List<Node> lnNodes = new ArrayList<Node>();
		List<Node> lnRecursion = new ArrayList<Node>();
		Node node;
		int i;
		
		for(i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			System.out.println(tab + node.getNodeName());
			
			if (node.hasChildNodes()) {
				if (node.getNodeName().equals(value)) {
					System.out.println(tab + "if (" + value + "): " + node.getNodeName() + ": " + node.getNodeValue());
					lnNodes.add(node);
				} else {
					System.out.println(tab + "else (" + value + "): " + node.getNodeName() + ": " + node.getNodeValue());
					lnRecursion = XmlController.getNodeTest(node.getChildNodes(), value, tab+"\t"); 
					if(!lnRecursion.isEmpty()) {
						lnNodes.addAll(lnRecursion);
					}
				}
			}
		}
		System.out.println(tab + lnNodes.size());
		return lnNodes;
	}
}