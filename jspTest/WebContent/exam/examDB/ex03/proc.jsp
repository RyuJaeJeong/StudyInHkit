<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<% 		
String about = request.getParameter("about");

String name = request.getParameter("nme");
String mob1 = request.getParameter("mob1");
String mob2 = request.getParameter("mob2");
String mob3 = request.getParameter("mob3");
String mail1 = request.getParameter("mail1");
String mail2 = request.getParameter("mail2");

String sub = request.getParameter("sub");
String content = request.getParameter("content");


Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int result1 = 0;
int result2 = 0;
int result3 = 0;
try{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPasswd = "1234";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
	System.out.println("--오라클 접속 성공 --");
	
	String sql1 = "insert into whatAbout values(no_3.nextval,?)";
	pstmt = conn.prepareStatement(sql1);
	pstmt.setString(1, about);
	result1=pstmt.executeUpdate();
	
	if(result1>0) {
		out.println("<script>");
		out.println("alert('정상 처리 되었습니다.1');");
		out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.1');");
		out.println("</script>");
	}
	String sql2 = "insert into ident values(no_4.nextval,?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql2);
	pstmt.setString(1, name);
	pstmt.setString(2, mob1);
	pstmt.setString(3, mob2);
	pstmt.setString(4, mob3);
	pstmt.setString(5, mail1);
	pstmt.setString(6, mail2);
	result2=pstmt.executeUpdate();
	
	if(result2>0) {
		out.println("<script>");
		out.println("alert('정상 처리 되었습니다.2');");

		out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.2');");
		out.println("</script>");
	}
	
	
	String sql3 = "insert into cont values(no_5.nextval,?,?,no_3.currval,no_4.currval)";
	pstmt = conn.prepareStatement(sql3);
	pstmt.setString(1, sub);
	pstmt.setString(2, content);
	result3=pstmt.executeUpdate();
	
	if(result3>0) {
		out.println("<script>");
		out.println("alert('정상 처리 되었습니다.3');");
		out.println("location.href='list.jsp';");
		out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.3');");
		out.println("location.href='layout.jsp';");
		out.println("</script>");
	}
	
}
	catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
}






%>