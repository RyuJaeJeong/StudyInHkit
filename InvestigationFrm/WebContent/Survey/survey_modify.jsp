<%@page import="src.model.survey.dto.SurveyDTO"%>
<%@page import="src.model.survey.dao.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);

SurveyDAO dao = new SurveyDAO();
SurveyDTO dto = dao.getSelectOne(no);
%>

<form name=modFrm>
			<input type="hidden" name = "no" value="<%=no%>">
	<table align="center">
		<tr>
			<td>항목 제목</td>
			<td><input type="text" name="question" value="<%=dto.getQuestion()%>"></td>
		</tr>
		<tr>
			<td>선택지1</td>
			<td><input type="text" name="select1" value="<%=dto.getSelect1()%>"></td>
		</tr>
		<tr>
			<td>선택지2</td>
			<td><input type="text" name="select2" value="<%=dto.getSelect2()%>"></td>
		</tr>
		<tr>
			<td>선택지3</td>
			<td><input type="text" name="select3" value="<%=dto.getSelect3()%>"></td>
		</tr>
		<tr>
			<td>선택지4</td>
			<td><input type="text" name="select4" value="<%=dto.getSelect4()%>"></td>
		</tr>
		<tr>
			<td>조사 활성화 여부</td>
			<td>
				<input type="radio" name="serviceStatus" value="1">활성화
				<input type="radio" name="serviceStatus" value="0">비활성화
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="#" onclick="modify('<%=no%>')">[제출하기]</a></td>
		</tr>
	</table>
	
</form>


</body>
</html>

<script>
function modify(value1) {
	if(confirm('수정하시겠습니까?')) {
		modFrm.method = "post";
		modFrm.action = "survey_modifyProc.jsp";
		modFrm.submit();
	}
}
</script>