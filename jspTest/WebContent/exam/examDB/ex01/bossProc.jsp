<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
int result=0;
String banjang = request.getParameter("a");
String bubanjang = request.getParameter("b");
String boss = request.getParameter("c");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPasswd = "1234";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
	System.out.println("--오라클 접속 성공 --");
	
	String sql = "insert into boss values(no.nextval,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, banjang);
	pstmt.setString(2, bubanjang);
	pstmt.setString(3, boss);
	result = pstmt.executeUpdate();
	
	if(result>0) {
		out.println("<script>");
		out.println("alert('정상 처리 되었습니다.');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.');");
		out.println("location.href='boss.jsp';");
		out.println("</script>");
	}
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
}


out.println("반장:     "+banjang+"<br>");
out.println("부반장:     "+bubanjang+"<br>");
out.println("회장:     "+boss+"<br>");
%>