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

<form name="delForm" method="post" action="delProc.jsp">
		아이디 : <input type="text" name="id" value=<%=id%> readonly> <br></br>
		비밀번호: <input type="text" name="pass" value=<%=pw%>><br></br>
		이름 : <input type="text" name="nme" value=<%=name%>><br></br>
		핸드폰 : <input type="text" name="phone" value=<%=phone%>><br></br>	
		이메일 : <input type="text" name="email" value=<%=email%>><br></br>
		출생년도 : <input type="text" name="birthYear" value=<%=birth%>><br></br>
</form>
<a href="#" onclick="del()"><img src="./del.png" width="300"></a>
<script>
function del() {
	if(confirm('삭제하시겠습니까?')) {
		delForm.method='post';
		delForm.action='delProc.jsp?id=<%=id%>';
		delForm.submit();
	}
}
</script>