<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<form name="listFrm">
		<table border="1" align="center">
			<tr>
				<th colspan="2"><%@ include file="../include/include_menu.jsp" %></th>
			</tr>
			<tr height="1000px">
				<td>
					<table align="center" border="1">
						<tr>
			 				<td>아이디</td>
			 				<td>비밀번호</td>
			 				<td>이름</td>
			 				<td>성별</td>
			 				<td>출생연도</td>
			 				<td>가입일</td>
		 				</tr>
					
					<%
					MemberDAO dao = new MemberDAO();
					ArrayList<MemberDTO> arr = dao.getListAll();
					
					for(int i=0; i<arr.size(); i++) {
						MemberDTO dto = new MemberDTO();
						dto=arr.get(i);
						
						 int no = dto.getNo();
						 String id = dto.getId();
						 String passwd = dto.getPasswd();
						 String name = dto.getName();
						 String gender = dto.getGender();
						 int bornYear = dto.getBornYear();
						 Timestamp wdate = dto.getWdate();
						 
						 %>
						 
						 <tr >
						 	<%System.out.println(no); %>
						 	<%if(cookNo==no) { %>
						 	<td><a href="#" onclick="view('<%=no%>');"><%=id%></a></td>
						 	<%}else{%>
			 				<td><%=id%></td>
			 				<%}%>
			 				<td><%=passwd %></td>
			 				<td><%=name %></td>
			 				<td><%=gender %></td>
			 				<td><%=bornYear%></td>
			 				<td><%=wdate%></td>
		 				</tr>
					<%}%>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2"><%@ include file="../include/include_bottom.jsp" %></td>
			</tr>	
		</table>
	</form>
</body>
</html>

<script>
function view(value1) {
	location.href='view.jsp?no='+value1;
}
</script>