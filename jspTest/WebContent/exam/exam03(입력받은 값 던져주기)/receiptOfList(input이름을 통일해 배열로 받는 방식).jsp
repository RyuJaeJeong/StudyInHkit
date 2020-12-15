<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>  
    
<% 
String[] names = request.getParameterValues("nme");
String[] prices = request.getParameterValues("price");
out.println(names.length);
out.println(prices.length);
for(int i=0; i<names.length; i++) {
	String name = names[i];
	String price = prices[i];
	
	out.println(name + "..." + price + "<br>");
}
%>