<%@page import="javaIotProject2.model.db.HumanDTO"%>
<%@page import="javaIotProject2.model.db.Db"%>
<%@page import="javaIotProject2.model.db.DbImplOracle"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<table border="1" align="center"> 
	<tr>
		<td>아파트아이디</td>
		<td>현관</td>
		<td>전등</td>
		<td>에어컨</td>
		<td>tv</td>
		<td>밥솥</td>
	</tr>

<% 
Db db = new DbImplOracle();
ArrayList<HumanDTO> arr = db.getListAll();

for(int i=0; i<arr.size(); i++) {
	HumanDTO dto = new HumanDTO();
	dto = arr.get(i); 
	String aptId = dto.getAptId();
	String security = dto.getSecurity();
	String light = dto.getLight();
	String aircondition = dto.getAircondition();
	String tv = dto.getTv();
	String cucu = dto.getCucu(); %>
	
	<tr>
		<td><%=aptId%></td>
		<td><%=security%></td>
		<td><%=light%></td>
		<td><%=aircondition%></td>
		<td><%=tv%></td>
		<td><%=cucu%></td>
	</tr>




<%}%>