<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td><input type="text" class="form-control" name="kor" required placeholder="00"/></td>
				</tr>
				<tr>
					<th>수학</th>
					<td><input type="text" class="form-control" name="math" required placeholder="00"/></td>
				</tr>
				<tr>
					<th>영어</th>
					<td><input type="text" class="form-control" name="eng" required placeholder="00"/></td>
				</tr>
				<tr>
					<th>과학</th>
					<td><input type="text" class="form-control" name="sci" required placeholder="00"/></td>
				</tr>
			</table>
				<input type="submit" class="btn btn-primary" value="전송" required placeholder="00"/>
		</div>
	</form>
</body>
</html>