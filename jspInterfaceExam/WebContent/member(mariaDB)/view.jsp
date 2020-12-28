<%@page import="jspInterfaceExam.model.member.MemberDTO"%>
<%@page import="jspInterfaceExam.model.member.MemberDAOImplMariaDB"%>
<%@page import="jspInterfaceExam.model.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% request.setCharacterEncoding("UTF-8"); %>
 
 <%             
String id = request.getParameter("id");


MemberDAO dao = new MemberDAOImplMariaDB();

MemberDTO dto =  dao.getSelectOne(id); 


String pwd = dto.getPwd();
String nme = dto.getNme();
String phone = dto.getPhone();
String job = dto.getJob(); 

%>

<form name ="viewFrm">
<h3 align="center"><%=nme%>님의 회원정보 상세보기</h3>
	<table align="center">
		<tr>
			<td>아이디</td>
			<td><%=id %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=pwd %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=nme%></td>
		</tr>
		
		<tr>
			<td>전화번호</td>
			<td><%=phone%></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%=job%></td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td>&nbsp</td>
		</tr>
		<tr>
			<td align="center"><button type="button" onclick="move('M','<%=id%>')">수정하기</button></td>
			<td align="center"><button type="button" onclick="move('D','<%=id%>')">삭제하기</button></td>
		</tr>
	
	</table>
</form>

<script>
function move (value1, value2) {
	if(value1=='M') {
		location.href='modify.jsp?id='+value2
	}else if(value1=='D') {
		if(confirm('삭제하시겠습니까?')){
		location.href='delete.jsp?id='+value2
		}
	}
	
}
</script>
