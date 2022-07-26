<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style2.css">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<table id="calTable" border="2px">
		</table>
	</div>
	<div>
		<form action="calculator" method="post" id="form">
			<input type="hidden" name="firstNum" id="first"	value="${result}" />
			<input type="hidden" name="operator" id="opper"	value="${operater}" />
			<input type="hidden" name="secondNum" id="second" />
			<input type="hidden" name="secondOpper" id="secondOpper" value="${secondOpper}" />
		</form>
	</div>
	<script>
	window.onload = function(){
		if(document.getElementById("show").value + 1 > 9223372036854775807){
			alert("9223372036854775807 이하만 표현 가능합니다.")
			document.getElementById("out").value = ""
			document.getElementById("show").value = ""
		}
	}
		
		
let value = ["😍","AC", "DEL", "/", 
			 "7", "8", "9", "*",
			 "4", "5", "6", "-",
			 "1", "2", "3", "+",
			 "0", ".", "🥰", "="];
			 
let clazz = ["col-md-1 num", "col-md-1 op"];

let script ="";
script += `<tr class="row">
			<td colspan="4"><input class="inputText" id="out" value="${formula}"/></td>
		   	</tr>
			<tr class="row">
			<td colspan="4"><input class="inputText" id="show" value='${result}'/></td>
			</tr>`;
			
let cnt = 0;

for(let i = 0; i < 5; i++){
	script += "<tr class='row'>";
	for(let j = 0; j < 4; j++){
		script += "<td>";
		if(j == 3){
			script += "<input type='button' class='" + clazz[1] + "' value='" + value[cnt] + "'/>";						
		}else{
			script += "<input type='button' class='" + clazz[0] + "' value='" + value[cnt] + "'/>";						
		}
		cnt++
		script += "</td>";
	}
}
document.getElementById("calTable").innerHTML = script;
		
	$(".num").on('click', (e) => { 
		key = e.target.value;
		if (key == "AC"){
			$(location).attr('href', 'calculator');
		}else if (key == "DEL"){
			del()
		}else{
			if (key == "😍"|| key == "🥰") {
			alert("😍😍")
			}else{
			getNum(key);
			}
		}
		document.getElementById('secondOpper').value = "";
	});
	
		var myform = document.getElementById("form");

 $(".op").on('click', (e) => {
		key = e.target.value;
		if(key == "="){
			submits();
		}
		else if (document.getElementById('secondOpper').value == ""){
			getOper(key);
		}else{
			document.getElementById('opper').value = key;
			out = document.getElementById('out');
			outValue = out.value.substring(0, out.value.length - 1);
			outValue += key;
			document.getElementById('out').value = outValue;
		}
	});
	
var out = document.getElementById('out')	
var numbers="";
	
function getOper(key) {
	numbers = document.getElementById('show').value;
	if(numbers != ""){
		if(document.getElementById('opper').value == ""){
			document.getElementById('first').value = numbers;
			document.getElementById('opper').value = key;
			document.getElementById('out').value = numbers + key;
			numbers = "";
			document.getElementById('show').value = numbers;
		}else{
			document.getElementById('secondOpper').value = key;
			submits();
		}
	}
	}
function del() {
		if (document.getElementById('show').value != "") {
			numbers = numbers.substring(0, numbers.length - 1);
		}
		document.getElementById('show').value = numbers;
	}
function outDel(key) {
		if (document.getElementById('oper').value != "") {
			out = out.substring(0, out.length - 1);
		}
		document.getElementById('out').value = out;
	}

function getNum(num) {
	if (document.getElementById('show').value == '0') {
		if (num == ".") {
		numbers += num;		
		} else {
		numbers = num;
		}
	} else {
		numbers += num;
	}
	document.getElementById('show').value = numbers;
}


function submits() {
	if (numbers != "") {
		if (document.getElementById('opper').value != "") {
			document.getElementById('second').value = numbers;
			myform.submit();
		}
}}
	</script>
</body>
</html>