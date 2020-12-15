<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원정보 상세보기</h3>


<%

String id = request.getParameter("id");

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
		String ident = rs.getString("id");
		String passwd = rs.getString("passwd");
		String passcheck = rs.getString("passcheck");
		String mail = rs.getString("mail");
		String name = rs.getString("nme");
		String phone = rs.getString("phone");
		
		out.println("id : " + ident +"<br>" );
		out.println("passwd : " + passwd +"<br>"  );
		out.println("mail : " + mail +"<br>"  );
		out.println("name : " + name +"<br>"  );
		out.println("phone : " + phone +"<br>"  );
		
	}
	
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("--오라클 접속 실패--");
} 	


%>



<a href="#" onclick="move('m','<%=id%>')">[수정하기]</a>
<a href="#" onclick="move('d','<%=id%>')">[삭제하기]</a>

<script>
function move(value1, value2) {
	if(value1=='m') {
		alert('수정하기 페이지로 이동합니다.')
		location.href='joinMod.jsp?id=' + value2
	}else {
		alert('삭제하기 페이지로 이동합니다.')
		location.href='joinDel.jsp?id=' + value2
	}
}
</script>


</body>
</html>


<%-- 프라이머리키 물고와서 그 행 전부 열기--%>