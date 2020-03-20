package com.app.controllers;

import java.io.File;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.app.manager.LogMng;
import com.app.utils.TreeStructure;

public class FilesController {

	private TreeStructure<String> _ts;
	
	private static FilesController instance;
	
	
	private FilesController() {
		this._ts = new TreeStructure<String>();
	}
	
	public static FilesController getInstance() {
		if (instance == null) {
			instance = new FilesController();
		}
		return instance;
	}
	
	public void getStructureFrom(String path) {
		File f = new File(path);
		
		this._ts.setElement(f.getName());
		
		if (f.isDirectory()) {
			this.createTreeStructure(this._ts, f);
		}
	}
	
	public void setRootPath(List<Node> lsNodes) {
		LogMng log = LogMng.getInstance();
		
		NodeList nlConfigurationProperties;
		Node nPropertie;
		String sValue = "";
		
		if(!lsNodes.isEmpty()) {
			for (Node nRoot: lsNodes) {
				nlConfigurationProperties = nRoot.getChildNodes();
				for(int i = 0; i < nlConfigurationProperties.getLength(); i++) {
					nPropertie  = nlConfigurationProperties.item( i );
					if(nPropertie.hasChildNodes()) {
						/* Add values database properties into properties. */
						sValue = nPropertie.getChildNodes().item( 0 ).getNodeValue();
					}
				}
				getStructureFrom(sValue);
			}
		} else {
			log.write(this, LogMng.INFO, "No existe configuración para estructura.");
		}
	}
	
	private void createTreeStructure(TreeStructure<String> ts, File file) {
		
		for (File f: file.listFiles()) {
			if (f.isFile()) {
				ts.addChilndren(new TreeStructure<String>(f.getName()));
			} else if (f.isDirectory()) {
				TreeStructure<String> branch = new TreeStructure<String>(f.getName());
				ts.addChilndren(branch);
				createTreeStructure(branch, f);
			} else {
				ts.addChilndren(new TreeStructure<String>(f.getName()));
			}
		}
	}
	
	/* Get absolute path to element. */
	public String getAbsolutPathTo(String fileName) {
		String sAbsolutePath = "";
		
		for(TreeStructure<String> ts: this._ts.getCompleteBranch(fileName)) {
			sAbsolutePath = sAbsolutePath + File.separator + ts.getElement();
		}
		
		return sAbsolutePath;
	}

	/* Description */
	public String getPathFromFileToFile(String fromFile, String toFile) {
		
		List<TreeStructure<String>> tsBranchOrigin = this._ts.getCompleteBranch(fromFile);
		List<TreeStructure<String>> tsBranchDestination = this._ts.getCompleteBranch(toFile);
		
		String path = "";
		
		int j=0;
		
		/* Looking for the folder root */
		boolean noFoundFolder = true;
		for (int i = tsBranchOrigin.size() - 2; i >= 0 && noFoundFolder; i-- ) {
			j = 0;
			for(TreeStructure< String > tsbd: tsBranchDestination) {
				j++;
				if ( tsBranchOrigin.get( i ).getElement().equals( tsbd.getElement() ) ) {
					noFoundFolder = false;
					break;
				}
			}
			if (noFoundFolder) {
				if (path.isEmpty()) {
					path += "..";
				} else {
					path += File.separator + "..";
				}
			}
		}
		
		/* Write the path */
		for(int k = j; k < tsBranchDestination.size(); k++) {
			path += File.separator + tsBranchDestination.get(k).getElement();
		}
		
		return path;
	}
}
