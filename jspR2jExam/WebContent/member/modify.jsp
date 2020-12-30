<%@page import="java.sql.Timestamp"%>
<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ include file="../include/include_ipcheck.jsp" %>
<%@ include file="../include/include_menu.jsp" %>
<% 
out.println("<hr>");
String id = request.getParameter("id");
System.out.println(id);
MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getSelectOne(id);

int no = dto.getNo();

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

<form name=modifyFrm>
		<table border="1" align="center" width="350px">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=id %>" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" value="<%=passwd%>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td align="center"><input type="text" name="sid1" value="<%=sid1 %>" style="width:100px" >-<input type="text" name="sid2" value="<%=sid2 %>" style="width:100px" ></td>
			</tr>
			<tr>
				<td>별명</td>
				<td><input type="text" name="nickname" value="<%=nickname%>"></td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><input type="text" name="phone" value="<%=phone%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="수정하기" onclick="mod()"></td>
			</tr>
			
		</table>
</form>
<script>
function mod() {
	if(confirm('수정하시겠습니까?')) {
		modifyFrm.method="post";
		modifyFrm.action="modifyProc.jsp"
		modifyFrm.submit();
	}
}

</script>