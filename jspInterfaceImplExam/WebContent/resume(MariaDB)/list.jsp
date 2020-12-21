<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAOImplMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>


<% 
ResumeDAO dao = new ResumeDAOImplMysql(); 
ArrayList<ResumeDTO> arr = dao.getListAll();
System.out.println(arr);
%>

<table align="center" border="1">
	
		
			<%for(int i=0; i<arr.size(); i++) {
				ResumeDTO dto = arr.get(i);
				int no = dto.getNo();
				String pic = dto.getPic();
				String name = dto.getName();
				String email = dto.getEmail();
				String phone = dto.getPhone();
				String address = dto.getAddress();
				
				
				
				
				if(i%3 == 0) {
				%>
				<tr>
				<td>
					<table border="1">
				        <tr>
				            <td style="width: 100px; height: 100px;"><img src="../image/<%=dto.getPic()%>" style="width:100px; height:100px;"></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><a href="#" onclick="goView('<%=no%>')"><%=name%></a></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><%=phone%></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><%=email%></td>
				        </tr>
	    			</table>
    			</td> 
    			<%}else if(i%3 == 1) {%> 
    				
    				<td>
					<table border="1">
				        <tr>
				            <td style="width: 100px; height: 100px;"><img src="../image/<%=dto.getPic()%>" style="width:100px; height:100px;"></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><a href="#" onclick="goView('<%=no%>')"><%=name%></a></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><%=phone%></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><%=email%></td>
				        </tr>
	    			</table>
    			</td>
    				
    				
    			<%} else if(i%3 ==2) {%>
    			
    			<td>
					<table border="1">
				        <tr>
				            <td style="width: 100px; height: 100px;"><img src="../image/<%=dto.getPic()%>" style="width:100px; height:100px;"></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><a href="#" onclick="goView('<%=no%>')"><%=name%></a></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><%=phone%></td>
				        </tr>
				        <tr>
				            <td style="width: 100px;"><%=email%></td>
				        </tr>
	    			</table>
    			</td>
    			</tr>
    			<%}%>
			<%}%>
</table>

<script>
function goView(value1) {
		location.href = 'view.jsp?no='+value1;
}


</script>