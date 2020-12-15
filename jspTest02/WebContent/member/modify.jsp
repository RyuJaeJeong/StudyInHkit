<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<h3>회원정보 수정하기</h3>
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

<form name="modForm" method="post" action="modProc.jsp">
		아이디 : <input type="text" name="id" value=<%=id%> readonly> <br></br>
		비밀번호: <input type="text" name="pass" value=<%=pw%>><br></br>
		이름 : <input type="text" name="nme" value=<%=name%>><br></br>
		핸드폰 : <input type="text" name="phone" value=<%=phone%>><br></br>	
		이메일 : <input type="text" name="email" value=<%=email%>><br></br>
		출생년도 : <input type="text" name="birthYear" value=<%=birth%>><br></br>
</form>
<a href="#" onclick="mod()"><img src="./mod.png" width="300"></a>
<script>
function mod() {
	if(confirm('수정하시겠습니까?')) {
		modForm.method='post';
		modForm.action='modProc.jsp?id=<%=id%>';
		modForm.submit();
	}
}
</script>