<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../include/inc_header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

proc : <span id="span_proc"></span> <br>
menu_gubun : ${menu_gubun}<br>
naljaMap : ${naljaMap}<br>
ip : ${ip}<br>
pageNumber : <span id="span_pageNumber">${span_pageNumber}</span><br>
pageSize : <span id="span_pageSize">${span_pageSize}</span><br>
no : <span id="span_no">${no}</span><br>
search_option : <span id="span_search_option">${search_option}</span><br>
search_data : <span id="span_search_data">${search_data}</span><br>
span_amount : <span id="span_amount">${amount}</span><br>
<div id="result" style="border: 1px solid red; height: inherit; "></div>


<script>

$(document).ready(function(){
<c:if test="${menu_gubun == 'mall_index'}">
	suntaek_proc('mall_list','1', '');
</c:if>
});

function suntaek_proc(value1, value2, value3) {
	if(value1 != '') {
		$("#span_proc").text(value1);
	}
	
	if(value1 =='cart_chuga') {
		alert($("#amount").val())
		$("#span_amount").text($("#amount").val());
	}else if(value1 =='cart_list') {
		$("#span_amount").text("");
		$("#span_no").text("");
	}else if(value1 =='cart_view') {
		if(confirm('제품상세보기 페이지로 이동하시겠습니까?')) {
			value1 = 'mall_view';
		}else {
			return;
		}
	}else if(value1 == 'cart_clear') {
		if(confirm('정말 비우시겠습니까?')) {
			$("#span_no").text("");
			$("#span_amount").text("");
		}else {
			return;
		}
	}
	
	if(value2 != '') {
		$("#span_pageNumber").text(value2);
	} 
	
	if(value3 != '') {
		$("#span_no").text(value3);
	}
	
	
	GoPage(value1);
	
}

function GoPage(value1) {
	var param = {};
	var url = "${path}/mall_servlet/" + value1 + ".do";
	
	if(value1 == "mall_list") {
		param = {};
		param.pageNumber = $("span_pageNumber").text();
		param.search_option = $("span_search_option").text();
		param.search_data = $("span_search_data").text();
	}else if(value1 == "mall_view") {
		param.no = $("#span_no").text();
	}else if(value1 == "cart_chuga") {
		//param.search_option = $("span_search_option").text();
		//param.search_data = $("span_search_data").text();
		param.no = $("#span_no").text();
		param.amount = $("#span_amount").text();
	}else if(value1 == "cart_list") {
		param = {};
		param.pageNumber = $("#span_pageNumber").text();
	}else if(value1 == 'cart_clear') {
		var chk_no = '';
		$('input[type="checkbox"]:checked').each(function(index){
			if(index != 0) {
				chk_no += ',';
			}
			chk_no  += $(this).val();
			
		});
		param = {};
		param.chk_no = chk_no;
		
	}
	
	$.ajax({
		type : "post",
		data : param,
		url : url,
		success : function(data) {
				if(value1 == 'cart_chuga' || value1 == 'cart_clear') {
					value1 = "cart_list";
					suntaek_proc(value1, '1', '');
				} else if (value1 == "sujungProc") {
					suntaek_proc('view', '', $("#span_no").text())
				} else {
					$("#result").html(data);
				}
				
			
				
		}
	});
	
	
}
</script>


</body>
</html>