<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	int total = (int) request.getAttribute("total");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post">
		<div class="form-group col-md-6">
			<table class="table table-bordered">
				<tr>
					<th>국어</th>
					<td id="in"><%= request.getParameter("kor") %></td>
				</tr>
				<tr>
					<th>수학</th>
					<td><%= request.getParameter("math") %></td>
				</tr>
				<tr>
					<th>영어</th>
					<td><%= request.getParameter("eng") %></td>
				</tr>
				<tr>
					<th>과학</th>
					<td><%= request.getParameter("sci") %></td>
				</tr>
				<tr>
					<th>총점</th>
					<td><%= total %></td>
				</tr>
				<tr>
					<th>평균</th>
					<td><%= total / (float) 4 %></td>
				</tr>
			</table>
			<input type="button" class="btn btn-primary" value="메인" onclick="location.href='scoreservlet'"/>
		</div>
	</form>
</body>
</html>