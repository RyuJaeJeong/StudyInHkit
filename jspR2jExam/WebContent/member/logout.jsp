<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file = "../include/include_ipcheck.jsp" %>
<% 
session.invalidate(); //세션제거
out.println("<script>alert('로그아웃되었습니다.'); location.href='login.jsp';</script>");


%>