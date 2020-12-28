<%@page import="jspInterfaceExam.model.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jspInterfaceExam.model.member.MemberDAOImplMariaDB"%>
<%@page import="jspInterfaceExam.model.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form name="listFrm">
	<h2 align="center">회원리스트</h2>
		 <table border="1" align="center">
		 	<tr>
			 	<td>아이디</td>
			 	<td>비밀번호</td>
			 	<td>이름</td>
			 	<td>핸드폰</td>
			 	<td>직업</td>
		 	</tr>


<%

MemberDAO dao = new MemberDAOImplMariaDB();
ArrayList<MemberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	MemberDTO dto = new MemberDTO();
	dto = arr.get(i);
	
	String id = dto.getId();
	String pwd = dto.getPwd();
	String nme = dto.getNme();
	String phone = dto.getPhone();
	String job = dto.getJob(); %>
	
	<tr>
 	<td><a href="#" onclick="goView('<%=id%>');"><%=id%></a></td>
 	<td><%=pwd%></td>
 	<td><%=nme%></td>
 	<td><%=phone%></td>
 	<td><%=job%></td>
	</tr>
	
<%}%>

</table>
	 </form>

<script>

function goView(value1) {
	location.href='view.jsp?id='+value1;
}

</script>

