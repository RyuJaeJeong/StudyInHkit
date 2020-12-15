<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<% request.setCharacterEncoding("UTF-8"); %>


<%
MemberDAO dao = new MemberDAO();
ArrayList<MemberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	MemberDTO dto = arr.get(i);
	String id = dto.getId();
	String pw = dto.getPass();
	String name = dto.getNme();
	String phone = dto.getPhone();
	String email = dto.getEmail();
	String birth = dto.getBirthYear(); %>
	
	<table border="1" align="center" style="width:800">
	<tr>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
	<td>핸드폰</td>
	<td>이메일</td>
	<td>생년월일</td>
	</tr>
	<tr>
	<td><a href="#" onclick="view('<%=dto.getId()%>');"><%=dto.getId()%></a></td>
	<td><%=pw %></td>
	<td><%=name %></td>
	<td><%=phone %></td>
	<td><%=email %></td>
	<td><%=birth %></td>
	</tr>
	</table>	
	<br></br>

<%}%>

<script>
function view (value1) {
	location.href='view.jsp?id=' + value1
}
</script>