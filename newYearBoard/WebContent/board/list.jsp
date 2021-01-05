<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	BoardDAO dao = new BoardDAO();
	String referer = request.getHeader("REFERER");		//이전페이지
	String ip = Inet4Address.getLocalHost().getHostAddress();
	out.println(referer+"<br>" + ip+"<br>");
	ArrayList<BoardDTO> arr = dao.getListAll();
	for(int i=0; i<arr.size(); i++) {
		BoardDTO dto = new BoardDTO();
		dto = arr.get(i);
		
		
	}
	%>
	
	클라이언트ip <%=request.getRemoteAddr() %><br>
	요청URL <%=request.getRequestURI() %><br>
	컨텐스트경로 <%=request.getContextPath() %><br>
	서버이름 <%=request.getServerName() %><br>
	서버포트 <%=request.getServerPort() %><br>
	
	
	
	
</body>
</html>