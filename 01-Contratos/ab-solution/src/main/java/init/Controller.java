package init;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import com.app.controllers.MainController;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	public void init() throws ServletException
    {
		MainController mc = new MainController();
		mc.toString();
    }
}