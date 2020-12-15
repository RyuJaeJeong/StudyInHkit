<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<h3>회원정보 수정하기</h3>
<%
String id = request.getParameter("id");
String ident = "";
String passwd =  "";
String passcheck =  "";
String mail =  "";
String name =  "";
String phone =  "";

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
	
	String sql = "select*from member_info m inner join personal_info p on m.personal_num = p.num where id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	rs = pstmt.executeQuery();
	
	if(rs.next()) {
		ident = rs.getString("id");
		passwd = rs.getString("passwd");
		passcheck = rs.getString("passcheck");
		mail = rs.getString("mail");
		name = rs.getString("nme");
		phone = rs.getString("phone"); %>
		
	<%}
	
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
}%>

<form name="modForm" method="post" action="modProc.jsp">
		아이디 : <input type="text" name="id" value=<%=ident%> readonly> <br></br>
		e-mail: <input type="text" name="mail" value=<%=mail%>><br></br>
		이름 : <input type="text" name="name" value=<%=name%>><br></br>
		핸드폰 : <input type="text" name="phone" value=<%=phone%>><br></br>	
</form>
<a href="#" onclick="mod()">[수정하기]</a>
<script>
function mod() {
	if(confirm('수정하시겠습니까?')) {
		modForm.method='post';
		modForm.action='modProc.jsp?id=<%=id%>';
		modForm.submit();
	}
}
</script>





</table>