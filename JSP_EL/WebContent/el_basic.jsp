<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("message", "pageContext message");
	request.setAttribute("message", "request message");
	session.setAttribute("message", "session message");
	application.setAttribute("message", "application message");
	
	pageContext.setAttribute("num", 1);
	pageContext.setAttribute("str", "1,2,3");
	
	MemberVO member = new MemberVO();
	member.setId("yaya");
	member.setPwd("hoho");
	
	request.setAttribute("member", member);
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("name", "nono");
	
	request.setAttribute("map", map);
	
	List<String> list = new ArrayList<String>();
	list.add("hello");
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>attribute message : ${message}</h3>
	<h3>attribute message : ${requestScope.message}</h3>
	<h3>attribute message : ${sessionScope.message}</h3>
	<h3>attribute message : ${applicationScope.message}</h3>
	<h3>parameter message : ${param.message}</h3>
	
	<ul>
		<li>산술연산 : ${num + 1}</li>
		<li>문자열 더하기 : ${num} ${message}</li>
		<li>비교연산 : ${num ge 1}</li>
		<li>유무연산 : ${empty num}, ${empty requestScope.member}</li>
	</ul>
	<ul>//일반메소드
		<li>str.split(',')[1] 					: ${str.split(',')[1]}</li>
		<li>MemberVO 호출 {member.getId()}	 	: ${ member.getId() }</li>
		<li>MemberVO 호출 {member.id} 			: ${ member.id }</li>
		<li>MemberVO 호출 {member.getIdnPwd()}  : ${ member.getIdnPwd() }</li>
		<li>MemberVO 호출 {member.idnPwd} 		: ${ member.idnPwd }</li>
		<li>Map 호출 {map.get("name")}			: ${ map.get("name") }</li>
		<li>Map 호출 {map.name} 				: ${ map.name }</li>
		<li>list 호출 {list.get(0)} 			: ${ list.get(0) }</li>
		<li>list 호출 {list[0]} 				: ${ list[0] }</li>
	</ul>
</body>
</html>