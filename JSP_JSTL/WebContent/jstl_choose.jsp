<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		int k = 90;
		if(k >= 90){
			out.println("A");
		}else if(k>=80){
			out.println("B");
		}else if(k>=70){
			out.println("C");
		}else if(k>=60){
			out.println("D");
		}else{
			out.println("F");
		}
	%>
	<hr/>
	<c:set var="k" value="90" />
	<c:choose>
		<c:when test="${k ge 90 }">
			A
		</c:when>
		<c:when test="${k ge 80 }">
			B
		</c:when>
		<c:when test="${k ge 70 }">
			C
		</c:when>
		<c:when test="${k ge 60 }">
			D
		</c:when>		
		<c:otherwise>
			F
		</c:otherwise>
	</c:choose>
</body>
</html>














