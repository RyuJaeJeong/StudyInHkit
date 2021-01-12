<%@page import="src.model.answer.dao.AnswerDAO"%>
<%@page import="src.model.answer.dto.AnswerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%

String survey_no_ = request.getParameter("survey_no");
String survey_answer_ = request.getParameter("survey_answer");

int survey_no = Integer.parseInt(survey_no_);
int survey_answer = Integer.parseInt(survey_answer_);

AnswerDTO dto = new AnswerDTO();
dto.setSurvey_no(survey_no);
dto.setSurvey_answer(survey_answer);

AnswerDAO dao = new AnswerDAO();

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert='입력이 완료되엇습니다.'");
	out.println("location.href='../Survey/survey_list.jsp'");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert='입력에 실패하였습니다.'");
	out.println("location.href='answer_write.jsp?no="+survey_no+"';");
	out.println("</script>");
}

%>