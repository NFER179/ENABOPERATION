package com.component.basic.structur;

import com.component.Component;

public class WebTable extends StructureComponent {

	private String _sHtml;
	private int _iColumns;
	private String _sHeader = "";
	private Component[] _asBody;
	
	public WebTable() {
		this._sHtml = "<table>\n%s</table>";
	}
	
	public WebTable(String[] columns) {
		this._iColumns = columns.length;
	}
	
	public void setHeader(String[] header) {
		this._iColumns = header.length;
		
		int iColumnHeader;
		
		this._sHeader = "<tr>\n";
		
		for(iColumnHeader = 0; iColumnHeader < this._iColumns; iColumnHeader++) {
			this._sHeader += "\t<th>" + header[iColumnHeader] + "</th>\n";
		}
		
		this._sHeader += "</tr>\n";
	}

}
