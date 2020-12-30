<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../include/include_ipcheck.jsp" %>
<%@ include file="../include/include_menu.jsp" %>

<form name="listFrm">
	<h2 align="center">회원관리</h2>
		 <table border="1" align="center">
		 	<tr>
			 	<td>아이디</td>
			 	<td>비밀번호</td>
			 	<td>이름</td>
			 	<td>주민등록번호</td>
			 	<td>별명</td>
			 	<td>휴대폰</td>
			 	<td>성별</td>
			 	<td>나이</td>
			 	<td>회원등급</td>
			 	<td>가입일</td>
			 	<td>접속ip</td>
		 	</tr>
<%
MemberDAO dao = new MemberDAO();

ArrayList<MemberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	MemberDTO dto = new MemberDTO();
	dto = arr.get(i);
	
	 int no = dto.getNo();
	 String id = dto.getId();
	 String passwd = dto.getPasswd();
	 String name = dto.getName();
	 String sid1 = dto.getSid1();
	 String sid2 = dto.getSid2();
	 String nickname = dto.getNickname();
	 String phone = dto.getPhone();
	 String gender = dto.getGender();
	 String age = dto.getAge();
	 String grade = dto.getGrade();
	 Timestamp wdate = dto.getWdate();
	 String userIp = dto.getIp();
	 String sid = sid1 + sid2;
	 %>
	 		
	 		<tr>
			 	<td><a href="#" onclick="goView('<%=id%>');"><%=id%></a></td>
			 	<td><%=passwd%></td>
			 	<td><%=name%></td>
			 	<td><%=sid%></td>
			 	<td><%=nickname%></td>
			 	<td><%=phone%></td>
			 	<td><%=gender%></td>
			 	<td><%=age%></td>
			 	<td><%=grade%></td>
			 	<td><%=wdate%></td>
			 	<td><%=userIp%></td>
		 	</tr>
	 
		
<%}%>
 </table>
	 </form>
<script>

function goView(value1) {
	location.href='view.jsp?id='+value1;
	
}

</script>