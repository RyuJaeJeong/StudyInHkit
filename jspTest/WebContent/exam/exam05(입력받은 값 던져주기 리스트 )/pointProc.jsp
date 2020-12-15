<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<table align="center">
<%
String[] names = request.getParameterValues("nme"); 
String[] kors = request.getParameterValues("kor");
String[] engs = request.getParameterValues("eng");
String[] mats = request.getParameterValues("math");
for(int i=0; i<3; i++) {
	String name = names[i];
	int kor = Integer.parseInt(kors[i]);
	int eng = Integer.parseInt(engs[i]);
	int mat = Integer.parseInt(mats[i]);
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



