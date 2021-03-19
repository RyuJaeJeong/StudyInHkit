<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../include/inc_header.jsp" %>
 
 <form name='founderFrm'>
	 <h3 align="center"> 아이디찾기 </h3>
	 <table align="center" border="1">
	 	<tr>
	 		<td>아이디</td>
	 		<td><input type="text" name="id" id="id" value="${id}"></td>
	 	</tr>
	 	<tr>
	 		
		 		<c:choose>
					<c:when test="${result>0 }">
						<td colspan="2" align="center">
						아이디를 사용 할 수 없습니다.
						</td>
					</c:when>
					<c:when test="${result<0 }">
					
					</c:when>
					<c:otherwise>
					<td colspan="2" align="center">
						아이디를 사용 할 수 있습니다.
					</td>	
					</c:otherwise>
				</c:choose>
	 		
	 	</tr>
	 	<tr>
	 		<td colspan="2" align="center" style="height:50px;">
	 			<button type="button" onclick="search();">검색</button>
	 			<button type="button" onclick="save();">적용</button>
	 		</td>
	 		
	 	</tr>
	 	
	 </table>
	 <input type="text" name="use_id" id="use_id" value="${id}">
 </form>
 
 <script>
	 function search(){
		 if(confirm('진행할까요?')) {
			 founderFrm.method="post";
			 founderFrm.action="${path}/member_servlet/id_check_win_proc.do";
			 founderFrm.submit();
		 }
	 }
	 function save() {
		 if(confirm('적용할까요?')) {
			 if(${result>0}) {
				alert('중복된 아이디입니다.')
				$("#id").val("");
				$("#id").focus();
				return;
			 }
			 var id = document.getElementById("use_id").value;
			 //alert(id);
			 opener.document.getElementById("id").value = id;
			 window.close();
		 }
	 }
 </script>