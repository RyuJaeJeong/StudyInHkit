<%@page import="java.sql.Timestamp"%>
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

<form name=delFrm>
		<table border="1" align="center" width="350px">
			<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=passwd%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>주민등록번호</td>
			<td><%=sid%></td>
		</tr>
		<tr>
			<td>별명</td>
			<td><%=nickname%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=phone%></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=gender%></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=age%></td>
		</tr>
		<tr>
			<td>회원등급</td>
			<td><%=grade%></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td><%=wdate%></td>
		</tr>
		<tr>
			<td>ip</td>
			<td><%=userIp%></td>
		</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="삭제하기" onclick="del('<%=id%>')"></td>
			</tr>
			
		</table>
</form>

<script>
function del(value1) {
	
	if(confirm('삭제하시겠습니까?')) {
		delFrm.method="post";
		delFrm.action="deleteProc.jsp?id="+value1;
		delFrm.submit();
	}
}

</script>