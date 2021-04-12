<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/inc_header.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${path}</title>
</head>
<body>
		
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
						${ip}
						${menu_gubun}
					</c:when>
					<c:when test="${menu_gubun == 'member_index' }">
						<jsp:include page="../member/index.jsp"/><br>
						${menu_gubun}
					</c:when>
					<c:when test="${menu_gubun == 'memo_index' }">
						<jsp:include page="../memo/index.jsp"/><br>
						${menu_gubun}
					</c:when>
					<c:when test="${menu_gubun == 'survey_index' }">
						<jsp:include page="../survey/index.jsp"/><br>
						${menu_gubun}
					</c:when>
					<c:when test="${menu_gubun == 'survey2_index' }">
						<jsp:include page="../survey2/index.jsp"/><br>
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
					<c:when test="${menu_gubun == 'mall_index' }">
						<jsp:include page="../shop/mall/index.jsp"/><br>
						${menu_gubun}
					</c:when>
					<%--
						 <c:when test="${menu_gubun == 'member_login' }">
							<jsp:include page="../member/login.jsp"/><br>
							${menu_gubun}
						</c:when>
					--%>
					<c:when test="${menu_gubun == 'chart_index' }">
						<jsp:include page="../chart/index.jsp"/><br>
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