<%@page import="src.model.survey.dao.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>


<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
SurveyDAO dao = new SurveyDAO();
int result = dao.getDelete(no);

if(result>0){
	out.println("<script>");
	out.println("alert('삭제가 완료되었습니다.')");
	out.println("location.href ='survey_list.jsp'");
	out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('삭제에 실패하었습니다.')");
		out.println("location.href ='survey_list.jsp'");
		out.println("</script>");	
	}

%>