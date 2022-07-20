<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int result = (int) request.getAttribute("result"); %>
<h1>계산 결과</h1>
<div><%= result %></div>
<input type="button" value="메인" onclick="location.href='calculator'"/>
</body>
</html>