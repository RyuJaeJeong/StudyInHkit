<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>    
<%@ include file = "../include/include_ipcheck.jsp" %>

<jsp:useBean id = "dto" class="etc.member.MemberDTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>

<%
String sid1 = dto.getSid1();
String sid2 = dto.getSid2();
String genderchk = sid2.substring(0,1);
String ageCal_ = sid1.substring(0, 2);
int ageCal = Integer.parseInt(ageCal_);
if(genderchk.equals("1")||genderchk.equals("3")) {
	dto.setGender("남자");
}else if(genderchk.equals("2")||genderchk.equals("4")) {
	dto.setGender("여자");
}else{
	out.println("<script>alert('주민등록번호가 잘못입력되었습니다.'); location.href = 'join.jsp';</script>");
}

if(genderchk.equals("1")||genderchk.equals("2")) {
	int age_ = 2020-(1900+ageCal)+1;
	String age = Integer.toString(age_);
	dto.setAge(age);
}else if(genderchk.equals("3")||genderchk.equals("4")) {
	int age_ = 20-ageCal+1;
	String age = Integer.toString(age_);
	dto.setAge(age);
}

dto.setIp(ip);
MemberDAO dao = new MemberDAO();

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'login.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'join.jsp';");
	out.println("</script>");
} 



%>