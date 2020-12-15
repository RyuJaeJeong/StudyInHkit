<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="test.Test10DTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>


<%
String boss_1 = dto.getA();
String boss_2 = dto.getB();
String boss_3 = dto.getC();
String boss_4 = dto.getD();
String boss_5 = dto.getE();

out.println("1번회장은 " + boss_1);
out.println("2번회장은 " + boss_2);
out.println("3번회장은 " + boss_3);
out.println("4번회장은 " + boss_4);
out.println("5번회장은 " + boss_5);
%>

