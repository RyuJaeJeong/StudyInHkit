<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../include/inc_header.jsp" %>  

<form name="DirForm">
 <input type="hidden" name="no" id="no" value="${dto.no}">

	
	
		<table border="1" align="center" width="80%">
			<tr>
				<td colspan="2">
					<h1>글 삭제하기</h1>
				</td>
			</tr>
			<tr>
				<td width="150">작성자 : </td>
				<td>${dto.writer}</td>
			</tr>
			<tr>
	            <td  style="align:center;">비밀번호</td>
	            <td><input type="text" name="inputPasswd" id="inputPasswd" value=""></td>
	        </tr>
			<tr>
				<td width="150">제목 : </td>
				<td>${dto.subject}</td>
			</tr>
			<tr>
				<td width="150">내용 : </td>
				<td id="content">${dto.content}</td>
			</tr>
				
			<tr>
				<td colspan="2">
					<button type="button" onclick="sakjeProc();">삭제하기</button>
					<button type="button" onclick="GoPage('list','1','${dto.no}');">목록으로</button>
				</td>
			</tr>
			
			<input type="hidden" name="passwd" id="passwd" value="${dto.passwd }">
		</table>
</form>  

<script>
function sakjeProc() {
	DirForm.method = "post";
	DirForm.action = "${path}/board_controller/sakjeProc.do"
	DirForm.submit();
} 

function GoPage(value1, value2, value3) {
	if(value1=='list') {
		location.href = '${path}/board_controller/list.do?pageNumber=' + value2;
	}else if(value1 =='sujung') {
		location.href = '${path}/board_controller/sujung.do?pageNumber=' + value2 + '&no=' + value3;
	}else if(value1 =='chuga') {
		location.href = '${path}/board_controller/chuga.do';
	}else if(value1 == 'sakje') {
		location.href = '${path}/board_controller/sakje.do?pageNumber=' + value2 + '&no=' + value3;
	}
}
</script>
	

