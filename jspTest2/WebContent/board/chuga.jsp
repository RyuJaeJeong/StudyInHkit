<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../include/inc_header.jsp" %>


<form name="DirForm">

	    <table border ="2"  align="center" style="width:1000px; margin-top: 200px;">
	      	<tr>
	      		<td colspan="2"> <h2>게시글 쓰기</h2> </td>
	      	<tr>
	        <tr>
	            <td  style="align:center; width:100px;">작성자</td>
	            <td><input type="text" name="writer" id="writer" value="" style="width:900px"></td>
	        </tr>
	        <tr>
	            <td  style="align:center;">비밀번호</td>
	            <td><input type="text" name="passwd" id="passwd" value="" style="width:900px"></td>
	        </tr>
	        <tr>
	            <td  style="align:center;">제목</td>
	            <td><input type="text" name="subject" id="subject" value="${dto.subject}" style="width:900px"></td>
	        </tr>
	        <tr>
	        	<td style="align:center;">내용</td>
	            <td align="center"><textarea name="content"  id="content" style="width: 900px; height: 300px;" wrap="hard">${dto.content}</textarea></td>
	        </tr>
	        
	        <tr>
	            <td colspan="2" align="center">
	            	<button type="button" id="btnChuga" onclick="chugaProc()">등록하기</button>
	       
	            </td>
	        </tr>
	    </table>


</form>

<script>
	function chugaProc() {
		DirForm.method = "post";
		DirForm.action = "${path}/board_controller/chugaProc.do";
		DirForm.submit();
	}
</script>