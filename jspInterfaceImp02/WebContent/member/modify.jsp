<%@page import="model.member.MemberDAOImplOracle"%>
<%@page import="model.member.MemberDTO"%>
<%@page import="model.member.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>


<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
MemberDAO dao = new MemberDAOImplOracle();
MemberDTO dto =  dao.getSelectOne(no); 

String id = dto.getId();
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
			<td><input type="text" name="id" value="<%=id%>" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="passwd" value="<%=passwd%>"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="nme" value="<%=nme%>"></td>
		</tr>
		<tr>
			<td>주민등록번호</td>
			<td><input type="text" name="sid" value="<%=sid%>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="<%=phone%>"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="<%=email%>"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
			<input type="radio" name="gender" value="M">남자
			<input type="radio" name="gender" value="F">여자
		</td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="<%=age%>"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td><input type="text" name="age" value="<%=wdate%>" readonly></td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td>&nbsp</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="button" onclick="mod()">수정하기</button></td>
		</tr>
			<input type="hidden" name="no" value="<%=no%>">
	</table>
</form>
</body>
</html>

<script>
function mod() {
	if(confirm('수정하시겠습니까?')) {
		viewFrm.method="post";
		viewFrm.action="modifyProc.jsp"
		viewFrm.submit();
	}
}

</script>