<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="../include/inc_header.jsp" %>
   
<table style="margin-left: 50px">
	
	<tr>	
		<td colspan="15" style="padding:0px 20px;" >
			<h3 class = "h1-clock" style="align:left;"> </h3>
		</td>		
		<td colspan="8" style="padding:0px 20px;">
			&nbsp;
		</td>
		<td style="padding:0px 20px;" align="right">
			 <c:if test="${sessionScope.cookNo == null ||sessionScope.cookNo == 0}">
	    			<a href="${path}/member_servlet/login.do">로그인</a>
	   		 </c:if>
	   		 
	   		 <c:if test="${sessionScope.cookNo != null && sessionScope.cookNo != 0}">
	   		 	${sessionScope.cookName} 님 환영합니다.&nbsp;&nbsp;
	   		 	<a href="#">[회원관리]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	   		 	<a href="#">[회원정보수정]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	   			<a href="${path}/member_servlet/logout.do?no=5">로그아웃</a>
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
			<a href="${path}/member_servlet/index.do">회원관리</a>
		</td>
		<td style="padding:0px 20px;" id="memo" >
			<a href="${path}/memo_servlet/index.do">메모장</a>
		</td>
		<td style="padding:0px 20px;" id="survey">
			<a href="${path}/survey_servlet/index.do">설문관리</a>
		</td>
		<td style="padding:0px 20px;" id="survey2">
			<a href="${path}/survey2_servlet/index.do">설문조사</a>
		</td>
		<td style="padding:0px 20px;" id="board">
			<a href="${path}/board_servlet/index.do">게시판(ajax)</a>
		</td>
		<td style="padding:0px 20px;" id="product">
			<a href="${path}/product_servlet/index.do">상품관리</a>
		</td>
		<td style="padding:0px 20px;" id="mall">
			<a href="${path}/mall_servlet/index.do">쇼핑몰</a>
		</td>
		<td style="padding:0px 20px;" id="chart">
			<a href="${path}/chart_servlet/index.do">매출분석</a>
		</td>
		<td style="padding:0px 20px;" id="smtpEmail">
			<a href="${path}/email_servlet/index.do">E-MAIL발송</a>
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
	<c:when test="${menu_str02 == 'survey2' }">
		<script>
			$("#survey2").css("background-color", "gray");	
		</script>
	</c:when>
	<c:when test="${menu_str02 == 'board' }">
		<script>
			$("#board").css("background-color", "gray");	
		</script>
	</c:when>
	<c:when test="${menu_str02 == 'product' }">
		<script>
			$("#product").css("background-color", "gray");	
		</script>
	</c:when>
	<c:when test="${menu_str02 == 'memo' }">
		<script>
			$("#memo").css("background-color", "gray");	
		</script>
	</c:when>
	<c:when test="${menu_str02 == 'mall' }">
		<script>
			$("#mall").css("background-color", "gray");	
		</script>
	</c:when>
	<c:when test="${menu_str02 == 'chart' }">
		<script>
			$("#chart").css("background-color", "gray");	
		</script>
	</c:when>
</c:choose>


<script>
const clock = document.querySelector('.h1-clock');
function getTime() {
	const time = new Date();
	const hour = time.getHours();
	const minutes = time.getMinutes();
	const seconds = time.getSeconds();
	
	var msg =  "";
	if(hour<10) {
		msg+='0'+hour;
	}else {
		msg+= hour;
	}
	
	msg += ':';
	
	if(minutes<10) {
		msg+='0'+minutes;
	}else {
		msg+= minutes;
	}
	
	msg += ':';
	
	if(seconds<10) {
		msg+='0'+seconds;
	}else {
		msg+= seconds;
	}
		
	
	
	clock.innerHTML = msg;
}
function init() {
	setInterval(getTime, 10);
}
init();
</script>