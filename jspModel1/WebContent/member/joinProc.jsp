<%@page import="java.net.Inet4Address"%>
<%@page import="etc.member.memberDAOImplOracle"%>
<%@page import="etc.member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../include/include_check.jsp" %>

<jsp:useBean id = "dto" class="etc.member.memberDTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>


<%--
<%
String ip = Inet4Address.getLocalHost().getHostAddress(); //접속한 아이피값을 찍어준다
out.println("ip : " + ip);
//118.45.201.179
if(!ip.equals("118.45.204.179")) {
	//resuponse.sendRedirect("join.jsp");   멘트없이 튕기기
	
		<script>
		alert('허용된 ip가 아닙니다.')
		location.href = 'join.jsp';
	    </script>	<% 
}
 --%>


<% 

dto.setIp(ip);
memberDAO dao = new memberDAOImplOracle();

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'join.jsp';");
	out.println("</script>");
} 




%>