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
<h3>upload file info</h3>
	<ul>
		<li>title : ${title }</li>
		<li>originalFileName : ${originalFileName }</li>
		<li>uploadedFileName : ${uploadedFileName }</li>
		<li>uploadPath : ${uploadPath }</li>
	</ul>
</body>
</html>