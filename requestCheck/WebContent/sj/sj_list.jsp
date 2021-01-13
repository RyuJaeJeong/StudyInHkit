<%@page import="src.sj.sjDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.sj.sjDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<td>이름</td>
		<td>시험명</td>
		<td>문제1</td>
		<td>문제2</td>
		<td>문제3</td>
		<td>문제4</td>
		<td>문제5</td>
		<td>점수</td>
	</tr>




<%
sjDAO dao = new sjDAO();
ArrayList<sjDTO> arr = dao.getListAll();

for(int i=0; i<arr.size(); i++) {
	sjDTO dto = arr.get(i);
	
	 String nme = dto.getNme();
	 String sNme = dto.getsNme();
	 int mun_1 = dto.getMun_1();
	 int mun_2 = dto.getMun_2();
	 int mun_3 = dto.getMun_3();
	 int mun_4 = dto.getMun_4();
	 int mun_5 = dto.getMun_5();
	 String mun_ox_1 = dto.getMun_ox_1();
	 String mun_ox_2 = dto.getMun_ox_2();
	 String mun_ox_3 = dto.getMun_ox_3();
	 String mun_ox_4 = dto.getMun_ox_4();
	 String mun_ox_5 = dto.getMun_ox_5();
	 int jumsu = dto.getJumsu(); %>
	 
	 <tr>
		<td><%=nme %></td>
		<td><%=sNme %></td>
		<td><%=mun_1 %>/1</td>
		<td><%=mun_2 %>/2</td>
		<td><%=mun_3 %>/3</td>
		<td><%=mun_4 %>/4</td>
		<td><%=mun_5 %>/3</td>
		<td><%=jumsu %></td>
	</tr>
	
<%}%>

</table>

</body>
</html>