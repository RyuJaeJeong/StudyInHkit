<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="jspInterface_member.jspInterface_memberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jspInterface_member.jspInterface_memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<form name="listFrm">
	<h2 align="center">회원관리</h2>
		 <table border="1" align="center">
		 	<tr>
			 	<td>아이디</td>
			 	<td>비밀번호</td>
			 	<td>이름</td>
			 	<td>주민등록번호</td>
			 	<td>핸드폰</td>
			 	<td>이메일</td>
			 	<td>성별</td>
			 	<td>나이</td>
			 	<td>가입일</td>
		 	</tr>
<%
jspInterface_memberDAO dao = new jspInterface_memberDAO();

ArrayList<jspInterface_memberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	jspInterface_memberDTO dto = new jspInterface_memberDTO();
	dto = arr.get(i);
	
	 int no = dto.getNo();
	 String id = dto.getId();
	 String passwd = dto.getPasswd();
	 String nme = dto.getNme();
	 String sid = dto.getSid();
	 String phone = dto.getPhone();
	 String email = dto.getEmail();
	 String gender;
	 if(dto.getGender().equals("M")) {
			gender = "남자";
		}
		else{
			gender="여자";
		}
	 String age = dto.getAge();
	 Timestamp wdate = dto.getWdate(); %>
	 		
	 		<tr>
			 	<td><a href="#" onclick="goView('<%=no%>','<%=id%>');"><%=id%></a></td>
			 	<td><%=passwd%></td>
			 	<td><%=nme%></td>
			 	<td><%=sid%></td>
			 	<td><%=phone%></td>
			 	<td><%=email%></td>
			 	<td><%=gender%></td>
			 	<td><%=age%></td>
			 	<td><%=wdate%></td>
		 	</tr>
	 
		
<%}%>
 </table>
	 </form>
<script>

function goView(value1, value2) {
	location.href='view.jsp?no='+value1+'&id='+value2;
	
}

</script>













