<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<%
String id = request.getParameter("id");
String mail = request.getParameter("mail");
String name = request.getParameter("name");
String phone = request.getParameter("phone");
int result = 0;

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
	
	String sql = "update member_info set mail=? where id=? ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, mail);
	pstmt.setString(2, id);
	pstmt.executeUpdate();
	
	String sql2 = "update personal_info set nme=?, phone=? where member_id=?";
	pstmt = conn.prepareStatement(sql2);
	pstmt.setString(1, name);
	pstmt.setString(2, phone);
	pstmt.setString(3, id);
	result = pstmt.executeUpdate();
// 	System.out.println(name+"/"+phone+"/"+id+"/"+result);
	
	if(result>0) {
		out.println("<script>");
		out.println("alert('정상 처리 되었습니다.');");
		out.println("location.href='joinlist.jsp';");
		out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.');");
		out.println("location.href='joinlist.jsp';");
		out.println("</script>");
	}
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
} 
%>

</body>
</html>