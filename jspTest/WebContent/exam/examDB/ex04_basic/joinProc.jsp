<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
String temp = "";
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
temp = passwd.trim();
if(!passwd.equals(temp)) {
	out.println("<script>alert('비밀번호를 입력하세요.');history.back();</script>");
}
String passcheck = request.getParameter("passcheck");
String name  = request.getParameter("nme");

String phone  = request.getParameter("phone");
String mail  = request.getParameter("mail");
String birth  = request.getParameter("birth");

int result = 0;

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
out.println(name+id+passwd+passcheck+phone+mail+birth);
try{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPasswd = "1234";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
	System.out.println("--오라클 접속 성공 --");
	
	String sql = "insert into personal_info values(?,?,?,num4.nextval)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, phone);
	pstmt.setString(3, birth);
	pstmt.executeUpdate();
	
	String sql2 = "insert into member_info values(?,?,?,?,num4.currval)";
	pstmt = conn.prepareStatement(sql2);
	pstmt.setString(1, id);
	pstmt.setString(2, passwd);
	pstmt.setString(3, passcheck);
	pstmt.setString(4, mail);
	result = pstmt.executeUpdate();
	
	if(result>0) {
		out.println("<script>");
		out.println("alert('정상 처리 되었습니다.');");
		out.println("location.href='joinlist.jsp';");
		out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.');");
		out.println("location.href='joinForm.jsp';");
		out.println("</script>");
	}
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
} 


%>