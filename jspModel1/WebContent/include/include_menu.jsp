<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ include file="./include_session_check.jsp" %>
 

<table border="1" align="center">
	<tr>
		<th colspan="5" align="center"><%=anickname%>님 어서오세요 <a href = "logout.jsp">[로그아웃]</a> </th>
	</tr>
<% if(agrade.equals("1")) { %>
	<tr>
		<td>회원관리(1)</td>
		<td>상품관리(2)</td>
		<td>배송관리(3)</td>
		<td>문의관리</td>
		<td>주문관리</td>
	</tr>
	<%}else if(agrade.equals("2")) {%>
		<tr>
		<td>상품관리(2)</td>
		<td>문의관리</td>
		<td>주문관리</td>
		</tr>
	<%}else if(agrade.equals("3")) {%>
		<tr>
		<td>배송관리(3)</td>
		<td>문의관리</td>
		<td>주문관리</td>
		</tr>
	<%}else if(agrade.equals("4")) {%>
		<tr>
			<td colspan="5">주문관리</td>
		</tr>
	<%}%>
</table>    