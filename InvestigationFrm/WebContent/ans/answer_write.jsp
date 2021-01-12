<%@page import="src.model.survey.dto.SurveyDTO"%>
<%@page import="src.model.survey.dao.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);

SurveyDAO dao = new SurveyDAO();
SurveyDTO dto = dao.getSelectOne(no); 

String question = dto.getQuestion();
String select1  = dto.getSelect1();
String select2 = dto.getSelect2();
String select3 = dto.getSelect3();
String select4 = dto.getSelect4();
String serviceStatus = dto.getServiceStatus();

%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="ansFrm">

	<table align="center">
		<tr>
			<td><%=question%></td>
		</tr>
		<tr>
			<td><%=select1 %></td>
			<td><input type="radio" name="survey_answer" value="1"></td>
		</tr>
		<tr>
			<td><%=select2 %></td>
			<td><input type="radio" name="survey_answer" value="2"></td>
		</tr>
		<tr>
			<td><%=select3 %></td>
			<td><input type="radio" name="survey_answer" value="3"></td>
		</tr>
		<tr>
			<td><%=select4 %></td>
			<td><input type="radio" name="survey_answer" value="4"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="button" onclick="ans()">제출하기</button></td>
		</tr>
	</table>
	<input type="hidden" name = "survey_no" value="<%=no%>">
</form>

</body>
</html>

<script>
	function ans() {
		if(confirm('제출하시겠습니까?')) {
				ansFrm.method = "post";
				ansFrm.action = "answer_writeProc.jsp";
				ansFrm.submit();
		}
	}
</script>
