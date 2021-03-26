<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>
    span_list_size : <span id="span_list_size">${list.size()}</span><br>
    span_answer_total : <span id="span_answer_total"></span><br>
   <c:forEach var="dto" items="${list}" varStatus="status">
   		<c:set var="answer" value="answer${status.index}"></c:set>	
   		span_answer_${status.index}: <span  id="span_answer_${status.index}"></span><br>
   		span_no_${status.index}: <span  id="span_no_${status.index}">${dto.no }</span><br>
   		<table border="1" style="width:500px;">
   			<tr>
   				<td>
   					${dto.question}
   					<input type="text" name="" id="" value="">
   				</td>
   		 	</tr>
   		 	<tr>
   		 		<td>
   		 			<input type="radio" name="${answer}" value="1" onclick="check_answer('1','${status.index}')"> ${dto.ans1}, ${answer}
   		 		</td>
   		 	</tr>
   		 	<tr>
   		 		<td>
   		 			<input type="radio" name="${answer}" value="2" onclick="check_answer('2','${status.index}')"> ${dto.ans2}
   		 		</td>
   		 	</tr>
   		 	<tr>
   		 		<td>
   		 			<input type="radio" name="${answer}" value="3" onclick="check_answer('3','${status.index}')"> ${dto.ans3}
   		 		</td>
   		 	</tr>
   		 	<tr>
   		 		<td>
   		 			<input type="radio" name="${answer}" value="4" onclick="check_answer('4','${status.index}')"> ${dto.ans4}
   		 		</td>
   		 	</tr>
   		</table>
   		<br>
   </c:forEach>
   <button type="button" onclick="goSaveProc()">제출하기</button>