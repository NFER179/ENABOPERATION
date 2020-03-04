package solution.controller;

import java.io.File;

import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class AppStartController extends HttpServlet {
	
	AppController ac;
	
	@Override
	public void init() {
		System.out.println("[AppStartController] -> Start StartController");
		ac = AppController.getInstance();
		// The root path is get into the application controller.
		/* test */
		/*String rootpath = getServletContext().getRealPath(File.separator) + File.separatorChar + "WEB-INF" + File.separatorChar + "test.txt";
		System.out.println(rootpath);
		File f = new File(rootpath);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		/* test */
		
		ac.setPathRoot(getServletContext().getRealPath(File.separator)); 
		System.out.println("[AppStartController] -> End StartController");
	}
}