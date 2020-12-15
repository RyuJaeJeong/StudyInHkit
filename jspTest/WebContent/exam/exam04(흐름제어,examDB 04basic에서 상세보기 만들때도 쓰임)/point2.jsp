<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name = request.getParameter("name"); 
   //String kor = request.getParameter("kor");
   //String mat = request.getParameter("mat");
   //String eng = request.getParameter("eng");
   String total = request.getParameter("tot"); 
   //String avg = request.getParameter("avg");
   //String grade = request.getParameter("grade");
   out.println("name:"+name+"<br>");
   //out.println("국어:"+kor+"<br>");
   //out.println("국어:"+kor+"<br>");
   //out.println("영어:"+eng+"<br>");
   //out.println("수학:"+mat+"<br>");
   out.println("합계:"+total+"<br>");
   //out.println("평균:"+avg+"<br>");
   //out.println("등급:"+grade+"<br>");
%>
</body>
</html>