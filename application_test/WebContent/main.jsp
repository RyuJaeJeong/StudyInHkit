<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String cookId =(String)session.getAttribute("cookId");
	String cookDate_ = (String)session.getAttribute("cookDate");
	double cookDate = Double.parseDouble(cookDate_); 
	if(cookDate > 6) {
		out.println("<script>");
		out.println("alert('6개월동안 비밀번호를 변경하지 않으셨습니다. 비밀번호 변경 페이지로 이동합니다.');");
		out.println("location.href='change.jsp';");
		out.println("</script>");
	}
	
	if(cookId == null||cookId.length()==0) {
		out.println("<script>");
		out.println("alert('로그인후 이용해주세요');");
		out.println("location.href='login.jsp';");
		out.println("</script>");
	}
	%>
	
	<h2><%=cookId %>님 환영합니다.! 메인페이지입니다.</h2>
	<a href="logout.jsp">[로그아웃]</a>

</body>
</html>