<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="practice.receiptDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<% 
String name1 = dto.getNme1();
String price1 = dto.getPri1();
String name2 = dto.getNme2();
String price2 = dto.getPri2();
String name3 = dto.getNme3();
String price3 = dto.getPri3();
int total = dto.tot();

out.println(name1+" ----- "+price1+"<br>");
out.println(name2+" ----- "+price2+"<br>");
out.println(name3+" ----- "+price3+"<br>");
out.println("합계 ----- "+total);

%>
