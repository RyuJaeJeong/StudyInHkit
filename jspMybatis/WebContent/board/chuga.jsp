<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="../include/inc_header.jsp" %>


<form name="DirForm">

	    <table align="center" border="1">
	      	<tr>
	      		<td colspan="2"> <h2>게시글 쓰기</h2> </td>
	      	<tr>
	        <tr>
	            <td  style="align:center;">작성자</td>
	            <td><input type="text" name="writer" id="writer" value=""></td>
	        </tr>
	        <tr>
	            <td  style="align:center;">이메일</td>
	            <td><input type="text" name="email" id="email" value=""></td>
	        </tr>
	        <tr>
	            <td  style="align:center;">비밀번호</td>
	            <td><input type="text" name="passwd" id="passwd" value=""></td>
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
	        	<td  style="align:center;">공지글</td>
	        	<td>
	        		<input type="text" name="noticeGubun" id="noticeGubun">
	            	<input type="checkbox" name="noticeGubunCheckBox" value="T" onclick="clickChk('noticeGubun');">
	        		공지글 체크
	        	</td>
	        </tr>
	        <tr>
	            <td  style="align:center;">비밀글</td>
	            <td>
	            	<input type="text" name="secretGubun" id="secretGubun">
	            	<input type="checkbox" name="secretGubunCheckBox" value="T" onclick="clickChk('secretGubun');">
	            	비밀글체크
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2" align="center">
	            	<button type="button" id="btnChuga">등록하기</button>
	            	<button type="button" id="btnList">목록으로</button>
	            </td>
	        </tr>
	    </table>


</form>
<script>
	
	$(document).ready(function(){
		$("#writer").focus();
		
		$("#btnChuga").click(function(){
			var writer = $("#writer").val()
			if(confirm('등록하시겠습니까')) {
				GoPage('chugaProc', '');
			}
		});
		
		$("#btnList").click(function(){
			GoPage('List', '');
		});
		
	});
</script>