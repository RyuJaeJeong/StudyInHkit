<%@page import="src.model.survey.dao.SurveyDAO"%>
<%@page import="src.model.survey.dto.SurveyDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%

String no_ = request.getParameter("no");
System.out.println(no_);
int no = Integer.parseInt(no_);
String question = request.getParameter("question");
String select1  = request.getParameter("select1");
String select2 = request.getParameter("select2");
String select3 = request.getParameter("select3");
String select4 = request.getParameter("select4");
String serviceStatus = request.getParameter("serviceStatus");

SurveyDTO dto = new SurveyDTO();
dto.setNo(no);
dto.setQuestion(question);
dto.setSelect1(select1);
dto.setSelect2(select2);
dto.setSelect3(select3);
dto.setSelect4(select4);
dto.setServiceStatus(serviceStatus);

SurveyDAO dao = new SurveyDAO();

int result = dao.getUpdate(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert='수정이 완료되엇습니다.'");
	out.println("location.href='survey_list.jsp'");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert='입력에 실패하였습니다.'");
	out.println("location.href='survey_modify.jsp?no="+no+"';");
	out.println("</script>");
}

%>