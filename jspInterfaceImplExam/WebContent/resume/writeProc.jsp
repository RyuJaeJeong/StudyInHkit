<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAOImplOracle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id = "dto" class="jspInterfaceImplExam.model.resume.ResumeDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%

ResumeDAO dao = new ResumeDAOImplOracle();

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'write.jsp';");
	out.println("</script>");
}




%>