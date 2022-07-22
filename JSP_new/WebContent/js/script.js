    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = "js/jquery-3.6.0.min.js";

    // Then bind the event to the callback function.
    // There are several events for cross browser compatibility.
    script.onreadystatechange = handler;
    script.onload = handler;

    // Fire the loading
    head.appendChild(script);

    function handler(){
       console.log('jquery added :)');
    }
    
    let value = ["😍","AC", "DEL", "/", 
		 "7", "8", "9", "*",
		 "4", "5", "6", "-",
		 "1", "2", "3", "+",
		 "0", ".", "🥰", "="];
		 
let clazz = ["col-md-1 num", "col-md-1 op"];

let script ="";
script += `<tr class="row">
		<td colspan="4"><input class="inputText" id="out" value="<%out.print(request.getAttribute("formula"));%>"/></td>
	   	</tr>
		<tr class="row">
		<td colspan="4"><input class="inputText" id="show" value='<%out.print(request.getAttribute("result"));%>'/></td>
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
		$(location).attr('href', '/Calculator/calculator');
	}else if (key == "DEL"){
		del()
	}else{
		if (key == "😍"|| key == "🥰") {
		alert("😍😍완전소중~🥰🥰")
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
	numbers = num;
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
}
}