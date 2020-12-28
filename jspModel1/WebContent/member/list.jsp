

<%@page import="etc.member.memberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="etc.member.memberDAOImplOracle"%>
<%@page import="etc.member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../include/include_check.jsp" %>
<%@ include file="../include/include_menu.jsp" %>

	
	
<form name="listFrm">
<h2 align="center">회원관리</h2>
	 <table border="1" align="center">
	 	<tr>
		 	<td>아이디</td>
		 	<td>비밀번호</td>
		 	<td>이름</td>
		 	<td>닉네임</td>
		 	<td>이메일</td>
		 	<td>전화번호</td>
		 	<td>주소</td>
		 	<td>성별</td>
		 	<td>직업</td>
		 	<td>회원등급</td>
		 	<td>가입일</td>
	 	</tr>
<%
memberDAO dao = new memberDAOImplOracle();

ArrayList<memberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
memberDTO dto = new memberDTO();
dto = arr.get(i);

 int no = dto.getNo();
 String id = dto.getId();
 String passwd = dto.getPasswd();
 String name = dto.getName();
 String nickname = dto.getNickname();
 String email = dto.getEmail();
 String phone = dto.getPhone();
 String address = dto.getAddress();
 String gender;
 if(dto.getGender().equals("M")) {
		gender = "남자";
	}
	else{
		gender="여자";
	}
 String job = dto.getJob();
 String grade = dto.getGrade();
 String regi_date = dto.getRegi_date(); %>
 		
 		<tr>
		 	<td><a href="#" onclick="goView('<%=no%>','<%=id%>');"><%=id%></a></td>
		 	<td><%=passwd%></td>
		 	<td><%=name%></td>
		 	<td><%=nickname%></td>
		 	<td><%=email%></td>
		 	<td><%=phone%></td>
		 	<td><%=address%></td>
		 	<td><%=gender%></td>
		 	<td><%=job%></td>
		 	<td><%=grade%></td>
		 	<td><%=regi_date%></td>
	 	</tr>
 
	
<%}%>
</table>
 </form>
<script>

function goView(value1, value2) {
location.href='view.jsp?no='+value1+'&id='+value2;

}

</script>



