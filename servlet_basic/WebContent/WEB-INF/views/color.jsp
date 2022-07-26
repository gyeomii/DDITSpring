<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String color = request.getParameter("color"); %>
<html>
<head>
<meta charset="UTF-8">
<title>배경화면 바꾸기</title>
<style>
	body{
		background : <%=color%>
	}
</style>
</head>
<body>
<h1>color.jsp</h1>
</body>
</html>