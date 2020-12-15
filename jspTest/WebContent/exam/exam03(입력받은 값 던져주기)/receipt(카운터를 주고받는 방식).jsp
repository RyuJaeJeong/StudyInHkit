<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>




<%
String counter_ = request.getParameter("counter");
int counter = Integer.parseInt(counter_);
for(int i=1; i<=counter; i++) { 
	out.println(request.getParameter("prod_nme"+i));
	out.println(".....");
	out.println(request.getParameter("prod_price"+i)+"<br>");
}
%>



