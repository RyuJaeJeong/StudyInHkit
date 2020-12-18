<%@page import="java.sql.Timestamp"%>
<%@page import="model.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.member.MemberDAOImplMaria"%>
<%@page import="model.member.MemberDAO"%>
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
MemberDAO dao = new MemberDAOImplMaria();

ArrayList<MemberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	MemberDTO dto = new MemberDTO();
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