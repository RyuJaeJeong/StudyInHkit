<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>    
    
<div id="screen" style="width: 300px; height: 100px; border: 1px solid black;" >
</div><br>
<span id="value2"></span>
<div id="result" style="width:300px;"></div>

<script>
$(document).ready(function(){
	
	GoControl();
	
});

</script>

<script>
var number = "";
var oper = "";


function GoControl() {
	var param = {}
	$.ajax ({
		type: "post",
		data: param,
			url: "${path}/cal_servlet/control.do",
			success: function(result) {
				$("#result").html(result);
			}
	});
	
} 


var count = 1;
function inp(value1) {
	
		if(count == 1) {
			$("#a"+value1).css("background-color", "gray");
			count = 0;
		}else {
			$("#a"+value1).css("background-color", "white");
			count = 1;
		}
		
	number += value1;
	$("#screen").text(number);
	
}



function solve() {
	number=eval(number);
	$("#screen").text(number);
	
}

function cancel() {
	number="";
	$("#screen").text(number);
}
</script>