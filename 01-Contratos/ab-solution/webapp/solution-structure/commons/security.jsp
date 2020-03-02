<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="solution.constants.EnvironmentConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	</head>
	<body>
		<%
			/* ask if the session is open. */
			if (session.getAttribute(EnvironmentConstant.USER.var())==null) {
				String url = request.getRequestURI().toString();
				String urlHome = url + "index.jsp";
				String query = request.getQueryString();
				if (query != null)
					url += "?" + query;
				
				/* Pass this url to controller */
				
				response.sendRedirect(urlHome);
			}
		%>
	</body>
</html>