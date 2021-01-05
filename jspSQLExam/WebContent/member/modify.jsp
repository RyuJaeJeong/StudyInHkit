<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form name="modFrm">
		<table border="1" align="center">
			<tr>
				<th colspan="2"> <%@ include file="../include/include_menu.jsp" %></th>
			</tr>
			
			<tr height="500px">
				<td>
					
					<% 
					
					 
					 MemberDAO dao = new MemberDAO();
					 MemberDTO dto = dao.getSelectOne(cookNo);
					 String id = dto.getId();
					 String passwd = dto.getPasswd();
					 String name = dto.getName();
					 String gender = dto.getGender();
					 int bornYear = dto.getBornYear();
					 Timestamp wdate = dto.getWdate();
					
					%>
					
					<table align="center">
							<tr>
								<td  style=" width:100px; height:30px">아이디</td>
								<td><input type="text" name="id" value="<%=id%>" readonly></td>
							</tr>
							<tr>
								<td style=" width:100px; height:30px">비밀번호</td>
								<td><input type="text" name="passwd" value="<%=passwd%>"></td>
							</tr>
							<tr>
								<td style=" width:100px; height:30px">이름</td>
								<td><input type="text" name="name" value="<%=name%>"></td>
							</tr>
							<tr>
								<td style=" width:100px; height:30px">성별</td>
								<td>
									<input type="radio" name="gender" value="남자">남자
									<input type="radio" name="gender" value="여자">여자
								</td>
							</tr>
							<tr>
								<td style=" width:100px; height:30px">출생연도</td>
								<td><input type="text" name="bornYear" value="<%=bornYear%>"></td>
							</tr>
							<% Timestamp wwdate = new Timestamp(System.currentTimeMillis()); %>
							<tr>
								<td style=" width:100px; height:30px">가입일자</td>
								<td><%=wwdate%></td>
							</tr>
							<tr>
								<td style=" width:100px; height:30px" colspan="2" align="center"><a href="#" onclick=mod()>[수정하기]</a></td>
							</tr>
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
function mod() {
	if(confirm('수정하시겠습니까?')) {
		modFrm.method="post";
		modFrm.action="modifyProc.jsp";
		modFrm.submit();
	}
}
</script>