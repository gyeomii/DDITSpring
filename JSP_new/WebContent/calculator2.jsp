<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>GOC's Calculator</title>
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<h1>GOC's Calculator</h1>
	<div>

		<div class="wrapper">
			<div class="row">
				<input type="text" class="inputText" id="out" value="" style="" />
			</div>
			<div class="row">
				<input type="text" class="inputText" id="show"
					value="<%out.print(request.getAttribute("result"));%>" />
			</div>
			<br>
			<div class="row">
				<div class="col-md-1" onclick="getNum('7')">7</div>
				<div class="col-md-1" onclick="getNum('8')">8</div>
				<div class="col-md-1" onclick="getNum('9')">9</div>
				<div class="col-md-1 op" onclick="getOper('*')">*</div>
			</div>
			<div class="row">
				<div class="col-md-1" onclick="getNum('4')">4</div>
				<div class="col-md-1" onclick="getNum('5')">5</div>
				<div class="col-md-1" onclick="getNum('6')">6</div>
				<div class="col-md-1 op" onclick="getOper('-')">-</div>
			</div>
			<div class="row">
				<div class="col-md-1" onclick="getNum('1')">1</div>
				<div class="col-md-1" onclick="getNum('2')">2</div>
				<div class="col-md-1" onclick="getNum('3')">3</div>
				<div class="col-md-1 op" onclick="getOper('/')">/</div>
			</div>
			<div class="row">
				<div class="col-md-1" onclick="del()" id="del">DEL</div>
				<div class="col-md-1" onclick="getNum('0')">0</div>
				<div class="col-md-1" id="send">=</div>
				<div class="col-md-1 op" onclick="getOper('+')">+</div>
			</div>
			<div class="row">
				<div class="col-md-1 reset"
					onclick="location.href='/Calculator/calculator'">초기화</div>
			</div>
		</div>
		<form action="calculator" method="post" id="form">
			<input type="text" name="firstNum" id="first" /> <input type="text"
				name="operator" id="opper" /> <input type="text" name="secondNum"
				id="second" />
		</form>
	</div>
	<script type="text/javascript" src="js/script.js"></script>

</body>
</html>