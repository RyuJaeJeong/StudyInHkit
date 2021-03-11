<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../include/inc_header.jsp" %>


<form name="DirForm">
<input type="hidden" name="no" id="no" value="${dto.no}">
	    <table align="center" border="1">
	      	<tr>
	      		<td colspan="2"> <h2>게시글 수정</h2> </td>
	      	<tr>
	        <tr>
	            <td  style="align:center;">작성자</td>
	            <td><input type="text" name="writer" id="writer" value="${dto.writer }"></td>
	        </tr>
	        <tr>
	            <td  style="align:center;">비밀번호</td>
	            <td><input type="text" name="passwd" id="passwd" value="${dto.passwd }"></td>
	        </tr>
	        <tr>
	            <td  style="align:center;">제목</td>
	            <td><input type="text" name="subject" id="subject" value="${dto.subject}"></td>
	        </tr>
	        <tr>
	        	<td style="align:center;">내용</td>
	            <td colspan="2"><textarea name="content"  id="content" style="width: 300px; height: 100px;" wrap="hard">${dto.content}</textarea></td>
	        </tr>
	        
	        <tr>
	            <td colspan="2" align="center">
	            	<button type="button" id="btnChuga" onclick="sujungProc()">등록하기</button>
	            	<button type="button" onclick="GoPage('list','1','${dto.no}');">목록으로</button>
	            </td>
	        </tr>
	    </table>


</form>

<script>
	function sujungProc() {
		DirForm.method = "post";
		DirForm.action = "${path}/board_controller/sujungProc.do";
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