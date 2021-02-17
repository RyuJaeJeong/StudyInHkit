<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<span ></span>

<span style="display:none;" id="span_pageNumber">${pageNumber}</span>
<div id="chuga"></div>
<div id="list"></div>

<script>
$(document).ready(function(){
	GoChuga();
	GoList();
});


</script>

<script>
function GoChuga() {
	var param = {}
	$.ajax ({
		type: "post",
		data: param,
		url: "${path}/memo_servlet/chuga.do",
		success: function(data) {
			$("#chuga").html(data);
		}
	});
}
function GoChugaProc() {
	$.ajax ({
		type: "post",
		data: $('form').serialize(),
		url: "${path}/memo_servlet/chugaProc.do",
		success: function(data) {
			$("#name").val("");
			$("#content").val("");
			GoList();
		}
	});
}

function GoList() {
	var param = {
		 "pageNumber" : $("#span_pageNumber").text()	
	}
	$.ajax ({
		type: "post",
		data: param,
		url: "${path}/memo_servlet/list.do",
		success: function(data) {
			$("#list").html(data);
		}
	});
}

function suntaek_page(value1) {
 $("#span_pageNumber").text(value1);
 GoList();
}

</script>