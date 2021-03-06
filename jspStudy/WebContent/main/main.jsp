<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/inc_header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<body>
	
	
<%-- 	<c:choose>
		<c:when test="${menu_gubun == 'index' }">
			<jsp:include page="./a.jsp" />
		</c:when>
		<c:when test="${menu_gubun == 'index2' }">
			<jsp:include page="./b.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="./c.jsp" />
		</c:otherwise>
	</c:choose>
	--%>
	
	<%--JSTL 문법임. IF문
	
	<c:choose>
		<c:when test="EL표현식">
			내용
		</c:when>
		<c:when test="EL표현식">
			내용
		</c:when>
		<c:otherwise>
			내용
		</c:otherwise>
	</c:choose>
	
	
	 --%>
	
	<table border="1" align="center">
		<tr>
			<td style="padding:20px 20px;">
				<jsp:include page="../include/inc_menu.jsp"></jsp:include>
			</td>
		</tr>
		
		<tr>
			<td align="center" style="padding:50px 50px;">
				<%--
					
					path : ${path} <br>
					url : ${url}	<br>
					uri : ${uri}<br>
					${menu_gubun}

				--%>
				
				<c:choose>
				<c:when test="${menu_gubun == 'index_' }">
					<jsp:include page="../main/main_sub.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'member_chuga' }">
					<jsp:include page="../member/chuga.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'member_login' }">
					<jsp:include page="../member/login.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'member_list' }">
					<jsp:include page="../member/list.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'member_view' }">
					<jsp:include page="../member/view.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'member_modify' }">
					<jsp:include page="../member/modify.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'member_error' }">
					<jsp:include page="../member/error.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'memo_index' }">
					<jsp:include page="../memo/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'calculator_index' }">
					<jsp:include page="../calculator/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'survey_index' }">
					<jsp:include page="../survey/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'questionBank_makeQuestion' }">
					<jsp:include page="../questionBank/makeQuestion.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'board_index' }">
					<jsp:include page="../board/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'product_index' }">
					<jsp:include page="../shop/product/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'subBoard_list' }">
					<jsp:include page="../subBoard/list.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'subBoard_chuga' }">
					<jsp:include page="../subBoard/chuga.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'subBoard_view' }">
					<jsp:include page="../subBoard/view.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'mall_index' }">
					<jsp:include page="../shop/mall/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'chart_index' }">
					<jsp:include page="../chart/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'chart_googleChartJson' }">
					<jsp:include page="../chart/googleChartJson.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:when test="${menu_gubun == 'email_index' }">
					<jsp:include page="../email/index.jsp"/><br>
					${menu_gubun}
				</c:when>
				<c:otherwise>
					${menu_gubun}
				</c:otherwise>
				</c:choose>
				<%--include file 특징, 변수공유. --%>
			</td>
		</tr>
		<tr>
			<td style="padding:20px 20px;" align="center">
				<jsp:include page="../include/inc_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	
</body>
</html>