<%@page import="java.sql.Timestamp"%>
<%@page import="model.member.MemberDAOImplMaria"%>
<%@page import="model.member.MemberDTO"%>
<%@page import="model.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%             
String no_ = request.getParameter("no");
String id = request.getParameter("id");
int no = Integer.parseInt(no_);

MemberDAO dao = new MemberDAOImplMaria();

MemberDTO dto =  dao.getSelectOne(no); 

String passwd = dto.getPasswd();
String nme = dto.getNme();
String sid = dto.getSid();
String phone = dto.getPhone();
String email = dto.getEmail();
String gender;
if(dto.getGender().equals("M")) {
		gender = "남자";
	}
	else{
		gender="여자";
	}
String age = dto.getAge();
Timestamp wdate = dto.getWdate();

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
			<td><%=passwd %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=nme %></td>
		</tr>
		<tr>
			<td>주민등록번호</td>
			<td><%=sid %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=phone%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=email%></td>
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
			<td>가입일자</td>
			<td><%=wdate%></td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td>&nbsp</td>
		</tr>
		<tr>
			<td align="center"><button type="button" onclick="move('M','<%=no%>')">수정하기</button></td>
			<td align="center"><button type="button" onclick="move('D','<%=no%>')">삭제하기</button></td>
		</tr>
	
	</table>
</form>

<script>
function move (value1, value2) {
	if(value1=='M') {
		location.href='modify.jsp?no='+value2
	}else if(value1=='D') {
		location.href='delete.jsp?no='+value2
	}
	
}

</script>