<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h1>Login Page</h1>
	<form action="loginPost" method="post">
		ID : <input type="text" name="id"/><br/>
		PW : <input type="password" name="pwd"/><br/>
		<input type="submit" value="login"/>
	</form>
</body>
</html>