<%@page import="src.model.answer.dto.AnswerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.model.answer.dao.AnswerDAO"%>
<%@page import="src.model.survey.dto.SurveyDTO"%>
<%@page import="src.model.survey.dao.SurveyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);

SurveyDAO dao = new SurveyDAO();
SurveyDTO dto = dao.getSelectOne(no); 

String question = dto.getQuestion();
String select1  = dto.getSelect1();
String select2 = dto.getSelect2();
String select3 = dto.getSelect3();
String select4 = dto.getSelect4();
String serviceStatus = dto.getServiceStatus();

int count1 =0;
int count2 =0;
int count3 =0;
int count4 =0;
double t1;
double t2;
double t3;
double t4;


%>

<form>
	<h3 align="center"><%=question%></h3>
	<table border="1" align="center">
		<tr>
			<td>응답자번호</td>
			<td><%=select1%></td>
			<td><%=select2%></td>
			<td><%=select3%></td>
			<td><%=select4%></td>
		</tr>
	<%
	AnswerDAO dao2 = new AnswerDAO();
	ArrayList<AnswerDTO> arr = dao2.getListAll(no);
	for(int i=0; i<arr.size(); i++) {
		AnswerDTO dto2 = new AnswerDTO();
		dto2 = arr.get(i);
		int a_no = dto2.getA_no();
		int survey_no = dto2.getSurvey_no();
		int survey_answer = dto2.getSurvey_answer();
		
		if(survey_answer==1) {
			count1++;
			%>
		<tr>	
			<td><%=a_no%></td>
			<td>o</td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
		</tr>	
		<%}else if(survey_answer==2) {
			count2++;
		%>
		<tr>	
			<td><%=a_no%></td>
			<td>-</td>
			<td>o</td>
			<td>-</td>
			<td>-</td>
		</tr>
		<%}else if(survey_answer==3) {
			count3++;
		%>
		<tr>	
			<td><%=a_no%></td>
			<td>-</td>
			<td>-</td>
			<td>o</td>
			<td>-</td>
		</tr>	
		<%}else if(survey_answer==4) {
			count4++;
		%>
		<tr>	
			<td><%=a_no%></td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<td>o</td>
		</tr>	
		<%}%>
	<%}%>	
		<tr>	
			<td><%=arr.size() %>명</td>
			<td><%=count1 %></td>
			<td><%=count2 %></td>
			<td><%=count3 %></td>
			<td><%=count4 %></td>
		</tr>
		<%
		 t1 = (double)count1/(double)arr.size()*100;
		 t2 = (double)count2/(double)arr.size()*100;
		 t3 = (double)count3/(double)arr.size()*100;
		 t4 = (double)count4/(double)arr.size()*100;
		%>
		<tr>	
			<td>점유율</td>
			<td><%=String.format("%.2f",t1)%>%</td>
			<td><%=String.format("%.2f",t2)%>%</td>
			<td><%=String.format("%.2f",t3)%>%</td>
			<td><%=String.format("%.2f",t4)%>%</td>
		</tr>
	</table>

		  <table align="center" border="1" style="margin-top:50px">
		  			<tr>
		  			<td><%=select1%>(<%=t1 %>%)</td>
		  			<td><%=select2%>(<%=t2 %>%)</td>
		  			<td><%=select3%>(<%=t3 %>%)</td>
		  			<td><%=select4%>(<%=t4 %>%)</td>
		  			</tr>
                   <tr>
                    <td style="width: 100px; height: 200px; vertical-align: bottom;">
                        <hr style="width: 100px; height:<%=t1 %>%; background-color: red;">
                    </td>
                    <td style="width: 100px; height: 300px; vertical-align: bottom; ">
                        <hr style="width: 100px; height: <%=t2 %>%; background-color: red;">
                    </td>
                    <td style="width: 100px; height: 300px; vertical-align: bottom; " >
                        <hr style="width: 100px; height: <%=t3 %>%; background-color: red;">
                    </td>
                    <td style="width: 100px; height: 200px; vertical-align: bottom;">
                        <hr style="width: 100px; height: <%=t4 %>%; background-color: red;">
                    </td>
                   </tr>
         </table>       
	
	
	
		
</form>