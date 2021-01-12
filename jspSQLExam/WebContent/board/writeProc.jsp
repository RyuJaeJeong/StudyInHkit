
<%@page import="java.util.ArrayList"%>
<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="src.board.model.dto.BoardDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<% 

String no_ = request.getParameter("no");
System.out.println("답변"+no_);
int no = Integer.parseInt(no_);
int num;
int ref;
int re_step;
int re_level;
String parentInfo;

BoardDAO dao = new BoardDAO();
if(no>0) {		//답변글
	BoardDTO dto2 = dao.getSelectOne(no);
	num = dao.getMaxNum() + 1;
	ref = dto2.getRef();
	re_step = dto2.getRe_step()+1;
	re_level = dto2.getRe_level()+1;
	dao.setUpdateReLevel(dto2);
	ArrayList<String> brr = dao.getParentInfo(dto2);
	for(int a=0; a<brr.size(); a++ ) {
		String imsi = brr.get(a);
		String[] info = imsi.split("/");
		int level = Integer.parseInt(info[2])+1;
		imsi = info[0]+"/"+info[1]+"/"+level;
		brr.set(a, imsi);
	}
	dao.updateParentInfo(brr, ref, re_level-1);
	parentInfo = dto2.getRef()+"/"+dto2.getRe_step()+"/"+dto2.getRe_level();	
	
}else { 		//새글
	num = dao.getMaxNum() + 1;
	ref = dao.getMaxRef() + 1;
	re_step = 1;
	re_level = 1;
	parentInfo = null;
}


 
dto.setNum(num);
dto.setRef(ref);
dto.setRe_step(re_step);
dto.setRe_level(re_level);
dto.setParentInfo(parentInfo);

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('입력성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('입력실패');");
	out.println("location.href = 'write.jsp';");
	out.println("</script>");
}




%>