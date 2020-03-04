/* old object */
package init;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	public void init() throws ServletException
    {
		//MainController mc = new MainController(getServletContext().getRealPath(File.separator));
		//mc.toString();
		//System.out.println(getServletContext().getRealPath("webapp"));
		//mc.setAbsoluteRootPath(getServletContext().getRealPath(File.separatorChar + ""));
		/**
		 * Work, We have generate the code to read the information.
		 */
		System.out.println("[INFO] - Start create folder");
//		String filePath = mc.getAbsoluteRootPath()+File.separatorChar+"WEB-INF"+File.separatorChar+"solution.xml";
//		System.out.println(filePath);
//		File fSolutionConection = new File(filePath);
//		if (!fSolutionConection.exists()) {
//			try {
//				fSolutionConection.createNewFile();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		System.out.println("[INFO] - Finish create folder");
		System.out.println("-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z-z");
    }
}