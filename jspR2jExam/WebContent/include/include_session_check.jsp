<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
String cookId = null;
String aname = "";
String anickname = "";
String ajob = "";
String agrade="";

if(session.getAttribute("cookId") == null) {
		out.println("<script>alert('로그인후 이용하세요.'); location.href='login.jsp';</script>");
		
}else {
		cookId = (String)session.getAttribute("cookId");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getSelectOne(cookId);
		
		 aname = dto.getName();
		 anickname = dto.getNickname();
		 agrade = dto.getGrade();
		
		 
		
		
		}%>