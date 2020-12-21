<%@page import="jspInterfaceImplExam.model.resume.ResumeDAOImplOracle"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id = "dto" class="jspInterfaceImplExam.model.resume.ResumeDTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>

<% 
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);

ResumeDAO dao = new ResumeDAOImplOracle();

int result = dao.getUpdate(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'view.jsp?no="+no+"';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'modify.jsp?no="+no+"';");
	out.println("</script>");
}

%>