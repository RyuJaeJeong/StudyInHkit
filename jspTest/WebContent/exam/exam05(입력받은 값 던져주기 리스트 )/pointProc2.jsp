<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<table align="center">
<%
String[] scores = request.getParameterValues("score"); 

for(int i=0; i<12; i+=4) {
	String name = scores[i];
	int kor = Integer.parseInt(scores[i+1]);
	int eng = Integer.parseInt(scores[i+2]);
	int mat = Integer.parseInt(scores[i+3]);
	int tot = kor+eng+mat;
	double avg = tot/3.; %>
	
	<table border="1">
	<tr>
	<td>이름</td>
	<td>국어</td>
	<td>영어</td>
	<td>수학</td>
	<td>총점</td>
	<td>평균</td>
	</tr>
	<tr>
	<td><%=name%></td>
	<td><%=kor%></td>
	<td><%=eng%></td>
	<td><%=mat%></td>
	<td><%=tot%></td>
	<td><%=avg%></td>
	</tr>
	</table>
	
<%}%>
</table>



