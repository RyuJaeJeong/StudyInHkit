<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<span style="display: ;" id="span_CommentPageNumber">${CommentPageNumber}</span>

<script>
$(document).ready(function(){
	GoCommentPage('list','');
	$('#btnCommentSave').click(function(){
		GoCommentPage('writeProc', '');	
	});
});

function GoCommentPage(value1, value2) {
	var url = "${path}/board_comment_servlet/"+value1+".do";
	
	if(value1 == "writeProc") {
		var param={
				"no" : $("#span_no").text(),
				"writer" : $("#writer").val(),
				"passwd" : $("#passwd").val(),
				"contents" : $("#contents").val()
		    }
	}else if(value1 == "list"){
		var param = {
				 "no" : $("#span_no").text(),
				 "CommentPageNumber" : $("#span_CommentPageNumber").text()	
			}
	} 
	
	$.ajax({
		type: "post",
		data: param,
		url: url,
		success: function(result) {
			if(value1 == "writeProc") {
			GoCommentPage('list','');
			$("#writer").val("");
			$("#passwd").val("");
			$("#contents").val("");
			
			} else if(value1 == "list") {
				$("#comment_list").html(result);
			}
			
		}
	});
	
}  

function suntaek_page(value1) {
	$("#span_CommentPageNumber").text(value1);
	$("span_no").text("");
	GoCommentPage('list','');
}

	</script>

<form>
	<table align="center">
	    <tr>
	        <td>이름 : &nbsp; <input type="text" name="writer" id="writer" style="width: 100px;"></td>
	        <td>&nbsp; 비밀번호 : &nbsp; <input type="text" name="passwd" id="passwd"  style="width: 100px;"> </td>
	    </tr>
	    <tr>
	        <td colspan="2">
	            댓글 : &nbsp; <input type="text" name="content" id="contents" style="width: 250px;">
	            <button type="button" id="btnCommentSave">확인</button>
	        </td>
	    </tr>
	</table>
</form>

<div id="comment_list"></div>

</body>
</html>