<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<% request.setCharacterEncoding("UTF-8"); %>

<h3>회원정보 상세보기</h3>
<br></br>
<%
MemberDAO dao = new MemberDAO();
String dbid = request.getParameter("id");
MemberDTO dto = dao.view(dbid);

String id = dto.getId();
String pw = dto.getPass();
String name = dto.getNme();
String phone = dto.getPhone();
String email = dto.getEmail();
String birth = dto.getBirthYear();

%>

<table border="1" align="center" style="width:800">
	<tr>
	<td>아이디</td>
	<td><%=id%></td>
	</tr>
	<tr>
	<td>비밀번호</td>
	<td><%=pw%></td>
	</tr>
	<tr>
	<td>이름</td>
	<td><%=name%></td>
	</tr>
	<tr>
	<td>핸드폰</td>
	<td><%=phone%></td>
	</tr>
	<tr>
	<td>이메일</td>
	<td><%=email%></td>
	</tr>
	<tr>
	<td>출생년도</td>
	<td><%=birth%></td>
	</tr>
</table>	

<br><br>
<a href="#" onclick="move('M', '<%=id %>')"><img src="./mod.png" width="300"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" onclick="move('D', '<%=id %>')"><img src="./del.png" width="300"></a>

<script>
function move(value1, value2) {
	if(value1=='M'){
			location.href='modify.jsp?id=' + value2
	}else if(value1=='D') {
			location.href='delete.jsp?id=' + value2
	}
}
</script>