
<%@page import="jspInterfaceExam.model.member.MemberDTO"%>
<%@page import="jspInterfaceExam.model.member.MemberDAO"%>
<%@page import="jspInterfaceExam.model.member.MemberDAOImplMariaDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
String id = request.getParameter("id");
MemberDAO dao = new MemberDAOImplMariaDB();
int result = dao.getDel(id);

	if(result>0){
	out.println("<script>");
	out.println("alert('삭제가 완료되었습니다.')");
	out.println("location.href ='list.jsp'");
	out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('삭제에 실패하었습니다.')");
		out.println("location.href ='view.jsp?id="+id+"';");
		out.println("</script>");	
	}




%>