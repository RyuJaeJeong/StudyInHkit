<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="../include/inc_header.jsp" %>
   
<table>
	<tr>
		<td colspan="100" align="right">
		 <c:if test="${sessionScope.cookNo == null ||sessionScope.cookNo == 0}">
    	<a href="${path}/member_servlet/login.do">로그인</a>
   		 </c:if>
   		 
   		 <c:if test="${sessionScope.cookNo != null && sessionScope.cookNo != 0}">
   		 	${sessionScope.cookName} 님 환영합니다.&nbsp;&nbsp;
   		 	<a href="#">[회원관리]</a>&nbsp;&nbsp;&nbsp;&nbsp;
   		 	<a href="#">[회원정보수정]</a>&nbsp;&nbsp;&nbsp;&nbsp;
   			<a href="${path}/member_servlet/logout.do">로그아웃</a>
    	</c:if>
		
		</td>
	
	</tr>
	<c:set var="menu_str01" value="${fn:indexOf(menu_gubun, '_') }"></c:set>
	<c:set var="menu_str02" value="${fn:substring(menu_gubun,0, menu_str01) }"></c:set>
	<tr>
		
		   
	<td colspan="15" style="padding:0px 20px;" id="home">
		<a href="${path}">Home</a>
	</td>
				
			
	<td style="padding:0px 20px;" id="member">
		<a href="${path}/member_servlet/list.do">회원관리</a>
	</td>
				
		
		<td style="padding:0px 20px;">
			<a href="${path}/memo_servlet/write.do">메모장</a>
		</td>
		<td style="padding:0px 20px;">
			<a href="#">방명록</a>
		</td>
		<td style="padding:0px 20px;" id="survey">
			<a href="${path}/survey_servlet/index.do">설문조사</a>
		</td>
		<td style="padding:0px 20px;">
			<a href="${path}/cal_servlet/index.do">계산기</a>
		</td>
		<td style="padding:0px 20px;">
			<a href="#">게시판</a>
		</td>
		<td style="padding:0px 20px;">
			<a href="#">쇼핑몰</a>
		</td>
		<td style="padding:0px 20px;">
			<a href="#">관리자</a>
		</td>
	</tr>


</table>





<c:set var="aaa" value="010-1111-2222"></c:set>
<%-- ${fn:length(aaa) }<br>
${fn:substring(menu_gubun,0,6)}<br>

${fn:indexOf(aaa,'-')}<br> --%>

<%--

member
-controller
-model
	-dao
	-dto
-------------------
controller
-member
-board
model
-member
-board


--%>


<c:choose>
	<c:when test="${menu_str02 == 'index'}">
		<script>
			$("#home").css("background-color", "gray");	
		</script>
	</c:when> 
	<c:when test="${menu_str02 == 'member' }">
		<script>
			$("#member").css("background-color", "gray");	
		</script>
	</c:when>
	<c:when test="${menu_str02 == 'survey' }">
		<script>
			$("#survey").css("background-color", "gray");	
		</script>
	</c:when>
</c:choose>