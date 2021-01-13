<%@page import="src.sj.sjDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="src.sj.sjDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%			
sjDAO dao = new sjDAO();
String[] jungdab = {"1","2","3","4","3"};
int jumsu = 0;
String cor = "[o]";
String incor = "[x]";

dto.setMun_ox_1(incor);
dto.setMun_ox_2(incor);
dto.setMun_ox_3(incor);
dto.setMun_ox_4(incor);
dto.setMun_ox_5(incor);

String temp;
temp = Integer.toString(dto.getMun_1());

if(temp.equals(jungdab[0])) {
	dto.setMun_ox_1(cor);
	jumsu = jumsu+20;
}


temp = Integer.toString(dto.getMun_2());

if(temp.equals(jungdab[1])) {
	dto.setMun_ox_2(cor);
	jumsu = jumsu+20;
}


temp = Integer.toString(dto.getMun_3());

if(temp.equals(jungdab[2])) {
	dto.setMun_ox_3(cor);
	jumsu = jumsu+20;
}


temp = Integer.toString(dto.getMun_4());

if(temp.equals(jungdab[3])) {
	dto.setMun_ox_4(cor);
	jumsu = jumsu+20;
}


temp = Integer.toString(dto.getMun_5());

if(temp.equals(jungdab[4])) {
	dto.setMun_ox_5(cor);
	jumsu = jumsu+20;
}

dto.setJumsu(jumsu);

int result = dao.setInsert(dto);

if (result>0) {
	out.println("<script>");
	out.println("if(confirm('목록페이지로 이동 하시겠습니까')){ ");
	out.println("location.href='sj_list.jsp'");
	out.println("}else{");
	out.println("location.href='sj_write.jsp'");
	out.println("}");
	out.println("</script>");
	
}else{
	out.println("<script>");
	out.println("alert('정상적으로 제출되지 않았습니다.')");
	out.println("location.href='sj_write.jsp'");
	out.println("</script>");
}



%>