<%@page import="java.sql.Timestamp"%>
<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/include_ipcheck.jsp" %>
<%@ include file="../include/include_menu.jsp" %>
<% 

String id = request.getParameter("id");

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

<form name ="viewFrm">
<h3 align="center"><%=nickname%>님의 회원정보 상세보기</h3>
	<table  align="center">
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
			<td align="center"><button type="button" onclick="move('M','<%=id%>')">수정하기</button></td>
			<td align="center"><button type="button" onclick="move('D','<%=id%>')">삭제하기</button></td>
		</tr>
	
	</table>
</form>

<script>
function move (value1, value2) {
	
	if(value1=='M') {
		location.href='modify.jsp?id='+value2;
	}else if(value1=='D') {
		location.href='delete.jsp?id='+value2;
	}
	
}

</script>