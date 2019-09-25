package com.helper;

import java.io.File;

public class XmlReader {
	
	private String _folderPath;
	private String _filePath;
	
	public XmlReader() {
		
		this._folderPath = "nicolas-jsp-test" + File.separator + "conf";
		File folder = new File(this._folderPath);
		
		
		try {
			if(!folder.exists()) {
				folder.mkdir();
				System.out.println("Intenta crear carpeta");
			}
		} catch(Exception e) {
			System.out.println("lala");
			e.printStackTrace();
		}
		
		//try {
			//File f = new File("lalalakk.txt");
			/*if(f.createNewFile()) {
				System.out.print("create");
			}*/
			System.out.println("imprimio");	
		//} catch(Exception e) {
			
		//}
	}

}
