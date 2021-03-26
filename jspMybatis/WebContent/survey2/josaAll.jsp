<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>
<span id="span_list_size"  style="display:none;">${list.size()}</span><br>
<span id="span_answer_total" style="display:none;"></span><br>

<table>
	<tr>
		<td align="center"> <h2>전체 작성하기</h2></td>
	</tr>
	<tr>
		<td align="left">
							<c:forEach var="dto" items="${list}" varStatus="status" >
								<c:set var="answer" value="answer${status.index}"></c:set>	<%--답변1, 답변2, 답변3... input type name 나눠주기 위해 --%>	
								<span  id="span_answer_${status.index}" style="display:none;"></span><br>			<%--문항별 답안이 저장될 곳 --%>	
								<span  id="span_no_${status.index}" style="display:none;">${dto.no}</span><br>	<%--문항별 문제 넘버가 저장될 곳 --%>
							
								<table border="1" style="width:300px;">
										
										<input type="hidden" name="no" value="${dto.no}">
										
										<tr>
											<td><strong>Q. ${dto.question}</strong></td>
										</tr>
										<tr>
											<td><input type="radio" name="${answer}" value="1" onclick="check_answer('1','${status.index}')">${dto.ans1}</td>
										</tr>
										<tr>
											<td><input type="radio" name="${answer}" value="2" onclick="check_answer('2','${status.index}')">${dto.ans2}</td>
										</tr>
										<tr>
											<td><input type="radio" name="${answer}" value="3" onclick="check_answer('3','${status.index}')">${dto.ans3}</td>
										</tr>
										<tr>
											<td><input type="radio" name="${answer}" value="4" onclick="check_answer('4','${status.index}')">${dto.ans4}</td>
										</tr>
								</table>
									<br>
							</c:forEach>
		</td>
	</tr>
	<tr>
		<td>
			<button type="button" onclick="suntaek_proc('josaAllProc', '', '')">제출하기</button>	
		</td>
	</tr>
</table>




