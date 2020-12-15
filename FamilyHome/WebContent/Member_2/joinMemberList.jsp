<%@page import="member_2.joinMemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member_2.joinMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
joinMemberDAO dao = new joinMemberDAO();
joinMemberDTO dto = new joinMemberDTO();
ArrayList<joinMemberDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	dto = arr.get(i);
	String no = dto.getNo();
	String id = dto.getId();
	String password = dto.getPassword();
	String name = dto.getNme();
	String phone = dto.getPhone();
	String email = dto.getEmail();
	String brithYear = dto.getBirthYear();
	%>
	
	<form>
		<table border="1">
			<tr>
				<td>
				아이디
				</td>
				<td>
				<a href="joinMemberView.jsp?no=<%=no%>&id=<%=id%>">
				 <%=id%>
				 </a>
				</td>
			</tr>
			<tr>
				<td>
				비밀번호
				</td>
				<td>
				 <%=password%>
				</td>
			</tr>
			<tr>
				<td>
				이름
				</td>
				<td>
				<%=name%>
				</td>
			</tr>
			<tr>
				<td>
				핸드폰
				</td>
				<td>
				 <%=phone%>
				</td>
			</tr>
			<tr>
				<td>
				이메일
				</td>
				<td>
				 <%=email%>
				</td>
			</tr>
			<tr>
				<td>
				출생년도
				</td>
				<td>
				 <%=brithYear %>
				</td>
			</tr>
		</table>
	</form>
	

<% }%>


