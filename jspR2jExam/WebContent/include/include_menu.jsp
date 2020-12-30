<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<%@ include file="./include_session_check.jsp" %>

<table border="1" align="center">
	<tr>
		<th colspan="5" align="center" style="width:800px"><%=anickname%>(<%=agrade%>)님 어서오세요 <a href = "logout.jsp">[로그아웃]</a> </th>
	</tr>
<% if(agrade.equals("1")) { %>
	<tr>
		<td style="width:150px">회원관리(1)</td>
		<td style="width:150px">상품관리(2)</td>
		<td style="width:150px">배송관리(3)</td>
		<td style="width:150px">문의관리</td>
		<td style="width:150px">주문관리</td>
	</tr>
	<%}else if(agrade.equals("2")) {%>
		<tr>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">상품관리(2)</td>
		<td style="width:150px">문의관리</td>
		<td style="width:150px">주문관리</td>
		</tr>
	<%}else if(agrade.equals("3")) {%>
		<tr>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">배송관리(3)</td>
		<td style="width:150px">문의관리</td>
		<td style="width:150px">주문관리</td>
		</tr>
	<%}else if(agrade.equals("4")) {%>
		<tr>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">&nbsp</td>
		<td style="width:150px">주문관리</td>
		</tr>
	<%}%>
</table>    