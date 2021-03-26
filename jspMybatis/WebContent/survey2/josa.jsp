<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>
<form id="josaFrm">
	<table>
		<tr> <h2>문제 상세보기</h2></tr>
		<tr>
			<td><input type="hidden" name="no" value="${dto.no}"></td>
		</tr>
		<tr>
			<td><strong>Q. ${dto.question}</strong></td>
		</tr>
		<tr>
			<td><input type="radio" name="answer" value="1">${dto.ans1}</td>
		</tr>
		<tr>
			<td><input type="radio" name="answer" value="2">${dto.ans2}</td>
		</tr>
		<tr>
			<td><input type="radio" name="answer" value="3">${dto.ans3}</td>
		</tr>
		<tr>
			<td><input type="radio" name="answer" value="4">${dto.ans4}</td>
		</tr>
		<tr>
				<td colspan="2" align="center">
					<button type="button" onclick="suntaek_proc('josaProc','','${dto.no}')">제출하기</button>
				</td>
		</tr>
	</table>
</form>
