<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%

String cookid = null;
if(session.getAttribute("cookid")!=null) {
	cookid = (String) session.getAttribute("cookid");
}else {
	out.println("<script>");
	out.println("alert('로그인부터하세요.!');");
	out.println("location.href=login.jsp'");
	out.println("</script>");
}

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String temp ="";
ArrayList<String> arr = new ArrayList<>();

try{
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPasswd = "1234";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
	System.out.println("--오라클 접속 성공 --");
	
	String sql = "select*from member_info m inner join personal_info p on m.personal_num = p.num";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	while(rs.next()) {
		String id = rs.getString("id");
		String passwd = rs.getString("passwd");
		String passcheck = rs.getString("passcheck");
		String mail = rs.getString("mail");
		String name = rs.getString("nme");
		String phone = rs.getString("phone");
		
		temp=id;
		temp+="/";		
		temp+=passwd;
		temp+="/";
		temp+=passcheck;
		temp+="/";
		temp+=mail;
		temp+="/";
		temp+=name;
		temp+="/";
		temp+=phone;
		
		arr.add(temp);
	}
	
	for(int i=0; i<arr.size(); i++) {
		String str = arr.get(i);
		String[] temps = str.split("/");%>
		<h3><%=cookid%></h3>
		<table border="1" align="center">
		<tr>
		<td>
		 아이디
		</td>
		<td>
		 비밀번호
		</td>
		<td>
		e-mail
		</td>
		<td>
		 이름 
		</td>
		<td>
		 전화번호
		</td>
		</tr>
		<tr>
		<td>
		<a href="joinView.jsp?id=<%=temps[0]%>"><%=temps[0]%></a> <%--쿼리 스트링--%>
		</td>
		<td>
		 <%=temps[1]%>
		</td>
		<td>
		<%=temps[3]%>
		</td>
		<td>
		 <%=temps[4]%>
		</td>
		<td>
		 <%=temps[5]%>
		</td>
		</tr>
		</table>
		<br>
		
	<%}
	
	
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
} 

 %>