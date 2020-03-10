<%@page import="solution.login.AppSession"%>
<%@page import="solution.constants.VarSessionConst"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="../varios/title.jsp"></jsp:include>
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hello <%
			AppSession as = (AppSession)request.getSession().getAttribute(VarSessionConst.APPSESSION.var());
			out.print(as.getUserName());
		%></h1>
	</body>
</html>