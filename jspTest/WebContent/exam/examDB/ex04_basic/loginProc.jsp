<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
String id = request.getParameter("iden");
String pass = request.getParameter("pass");
 

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

int result = 0;

try{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPasswd = "1234";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
	System.out.println("--오라클 접속 성공 --");
	
	String sql = "select passwd from member_info where id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	rs = pstmt.executeQuery();
	String dbpass;
	if(rs.next()) {
		dbpass = rs.getString("passwd");
	}else {
		dbpass = "";
	}
	
	String cookid = null;
	
	if(dbpass!="") {
		session.setAttribute("cookid",id);
		out.println("<script>");
		out.println("alert('정상적으로 로그인되었습니다.');");
		out.println("location.href='joinlist.jsp'");
		out.println("</script>");
	}else {
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호가 다릅니다.');");
			out.println("location.href=login.jsp'");
			out.println("</script>");
			
	}
	
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
} 	

%>