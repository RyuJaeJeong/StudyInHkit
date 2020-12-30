<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form name="listFrm">
			<table border="1" align="center">
				<tr>
					<th colspan="2"><%@ include file="../include/include_menu.jsp" %></th>
				</tr>
				<tr>
					<td>
					<% 
					 String no_ = request.getParameter("no");
					 int no = Integer.parseInt(no_);
					 if(cookNo!=no){
					 out.println("<script>");
					 out.println("location.href='list.jsp';");
					 out.println("</script>");
					 }
					 MemberDAO dao = new MemberDAO();
					 MemberDTO dto = dao.getSelectOne(no);
					 String id = dto.getId();
					 String passwd = dto.getPasswd();
					 String name = dto.getName();
					 String gender = dto.getGender();
					 int bornYear = dto.getBornYear();
					 Timestamp wdate = dto.getWdate();
					
					%>
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
								<td>성별</td>
								<td><%=gender%></td>
							</tr>
							<tr>
								<td>출생연도</td>
								<td><%=bornYear%></td>
							</tr>
							<tr>
								<td>가입일자</td>
								<td><%=wdate%></td>
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