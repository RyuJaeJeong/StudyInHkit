<%@page import="jspInterface_member02.jspInterface_member02DTO"%>
<%@page import="jspInterface_member02.jspInterface_member02DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
String delPass = request.getParameter("delPass");
jspInterface_member02DAO dao = new jspInterface_member02DAO();
jspInterface_member02DTO dto =  dao.getSelectOne(no); 
String passwd = dto.getPasswd();
System.out.println(no+passwd+delPass);
int result = 0;
if(passwd.equals(delPass)) {
	result = dao.getDel(no);
	if(result>0){
	out.println("<script>");
	out.println("alert('삭제가 완료되었습니다.')");
	out.println("location.href ='list.jsp'");
	out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('삭제에 실패하었습니다.')");
		out.println("location.href ='view.jsp?no="+no+"';");
		out.println("</script>");	
	}
}else {
	out.println("<script>");
	out.println("alert('비밀번호가 틀립니다.')");
	out.println("location.href ='delete.jsp?no="+no+"';");
	out.println("</script>");
}



%>