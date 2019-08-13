package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseConnection;
import dto.UserLog;
import model.UserLogModel;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String uname = request.getParameter("uName");
		String upass = request.getParameter("uPass");
		
		UserLog uLog = new UserLog(uname, upass);
		
		if(UserLogModel.logIn(uLog)) {
			HttpSession session = request.getSession();
			session.setAttribute("usr", uLog);
			/**/
			try {
				Connection con = DatabaseConnection.initializeDatabase();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM fnd_users_tbl");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|\t" + rs.getString(2) + "|\t" + rs.getString(3) + "|\t" + rs.getString(4) + "|\t" + rs.getString(5) + "|\t" + rs.getString(6) + "|\t");
				}
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("---------test");
			/**/
			response.sendRedirect("schema/main/mainmenu.jsp");
		} else {
			response.sendRedirect("schema/errorLogin.jsp");
		}
		
	}
}