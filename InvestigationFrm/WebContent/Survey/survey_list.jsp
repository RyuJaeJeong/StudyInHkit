
<%@page import="src.model.survey.dto.SurveyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.model.survey.dao.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form>
	<table border="1" align="center">
		<tr>
			<td>조사번호</td>
			<td>질문</td>
			<td>응답1</td>
			<td>응답2</td>
			<td>응답3</td>
			<td>응답4</td>
			<td>활성화여부</td>
			<td>수정하기</td>
			<td>삭제하기</td>
		</tr>
	

<%
SurveyDAO dao = new SurveyDAO();
ArrayList<SurveyDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	SurveyDTO dto = new SurveyDTO();
	dto = arr.get(i);
	int no = dto.getNo();
	String question = dto.getQuestion();
	String select1  = dto.getSelect1();
	String select2 = dto.getSelect2();
	String select3 = dto.getSelect3();
	String select4 = dto.getSelect4();
	String serviceStatus = dto.getServiceStatus(); %>
	
	<tr>
		<%if(serviceStatus.equals("1")) { %>
			<td><a href="#" onclick="move('l','<%=no%>')"><%=no%></a></td>
		<%}%><%else { %>
			<td><%=no%></td>
		<%}%>
		<%if(serviceStatus.equals("1")) { %>
			<td><a href="#" onclick="move('s','<%=no%>')"><%=question%></a></td>
		<%}%><%else { %>
			<td><%=question%></td>
		<%}%>..
		<td><%=select1%></td>
		<td><%=select2%></td>
		<td><%=select3%></td>
		<td><%=select4%></td>
		<td><%=serviceStatus%></td>
		<td><a href="#" onclick="move('m','<%=no%>')">[수정하기]</a></td>
		<td><a href="#" onclick="move('d','<%=no%>')">[삭제하기]</a></td>
	</tr>
	
<%}%>
	</table>
</form>



<script>
function move(value1, value2) {
	if(value1=='m') {
		location.href='survey_modify.jsp?no='+value2;
	}else if(value1=='d'){
		location.href='survey_delete.jsp?no='+value2;
	}else if(value1=='s') {
		location.href='../ans/answer_write.jsp?no='+value2;
	}else{
		location.href='../ans/answer_list.jsp?no='+value2;
	}
}
</script>