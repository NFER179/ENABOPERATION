package solution.controller;

import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class AppPathController extends HttpServlet {

	private String _sRootPath = "";
	
	public AppPathController() {
		System.out.println("[AppPathController] - Start");
		//this._sRootPath = getServletContext().getRealPath(File.separator);
		System.out.println("[AppPathController] - End");
	}
	
	public String getRootPath(){
		return this._sRootPath;
	}
}