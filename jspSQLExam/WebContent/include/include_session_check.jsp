<%@page import="Member.model.MemberDTO"%>
<%@page import="Member.model.MemberDAO"%>
<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 

String ip = Inet4Address.getLocalHost().getHostAddress();

int cookNo = 0;
String sName = "";
if (session.getAttribute("cookNo") != null) {
	cookNo = (int) session.getAttribute("cookNo");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelectOne(cookNo);
	sName = dto.getName();
}

out.println(cookNo + "<hr>");




%>