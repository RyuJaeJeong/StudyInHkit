
<%@page import="guestBook.src.model.dao.guestBookDAO"%>
<%@page import="guestBook.src.model.dto.guestBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form>
<h2 align="center">방명록</h2>
	<%
	guestBookDAO dao = new guestBookDAO();
	ArrayList<guestBookDTO> arr = dao.getListAll();
	for(int i=0; i<arr.size(); i++) {
		guestBookDTO dto = arr.get(i);%>
			<table border="1" align="center">
                    <tr style="width: 500px;">
                        <td style="width: 100px;">이름</td>
                        <td><%=dto.getName() %></td>
                    </tr>

                    <tr style="width: 500px;">
                        <td>이메일</td>
                        <td><%=dto.getEmail() %></td>
                    </tr>

                    <tr style="width: 500px;">
                        <td>비밀번호</td>
                        <td><%=dto.getPasswd() %></td>
                    </tr>
                    <tr>
                        <td style="width: 266px; height: 100px;" colspan="2">
                        	<%=dto.getContent() %>
                        </td>
                    </tr>
                    
    	</table>
		<br>
	<%}%>
</form>
