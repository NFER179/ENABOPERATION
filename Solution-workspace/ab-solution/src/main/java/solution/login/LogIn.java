package solution.login;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.manager.LogMng;
import com.app.model.dto.UserLogDTO;

import solution.constants.JspTagNameConstant;
import solution.constants.VarSessionConst;
import solution.controller.AppController;

/**
 * Servlet implementation class LogIn
 */
@WebServlet(
		description = "Servlet to log", 
		urlPatterns = { "/LogIn" }, 
		initParams = { 
				@WebInitParam(name = "Name", value = "value", description = "Description")
		})
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doPost");
		//doGet(request, response);
		//doTrace(request, response);
		
		HttpSession session = request.getSession();
		AppSession appSession;
		AppController app = AppController.getInstance();
		UserLogDTO userLog;
		String database, user, pass;
		
		app.writeLog(this, LogMng.INFO, "Start log in");
		
		database = request.getParameter(JspTagNameConstant.DATABASEID.var());
		user = request.getParameter(JspTagNameConstant.USERID.var());
		pass = request.getParameter(JspTagNameConstant.PASSWROD.var());
		
		app.writeLog(this, LogMng.INFO, "Set vars " + database);
		
		app.setDataBase(database);
		userLog = new UserLogDTO(user, pass);
		
		appSession = new AppSession(app, userLog);
		if (appSession.logInOk()) {
			session.setAttribute(VarSessionConst.APPSESSION.var(), appSession);
			response.sendRedirect("solution-structure/commons/main.jsp");
		} else {
			app.writeLog(this, LogMng.INFO, "Usuario no existe");
		}
		app.writeLog(this, LogMng.INFO, "End log in");
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(response.getLocale());
	}

}
