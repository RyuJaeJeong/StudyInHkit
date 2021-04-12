<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>
<form id="josaFrm">
	<table border="1">
			<h2>문제 상세보기</h2>
			<input type="hidden" name="no" value="${dto.no}">
		<tr>
			<td><strong>Q. ${dto.question}</strong></td>
		</tr>
		<tr>
			<td>${dto.ans1}</td>
		</tr>
		<tr>
			<td>${dto.ans2}</td>
		</tr>
		<tr>
			<td>${dto.ans3}</td>
		</tr>
		<tr>
			<td>${dto.ans4}</td>
		</tr>
		<tr>
				<td colspan="2" align="center">
					<button type="button" onclick="suntaek_proc('sujung','','${dto.no}')">수정하기</button>
					&nbsp;
					<button type="button" onclick="suntaek_proc('sakjeProc','','${dto.no}')">삭제하기</button>
				</td>
		</tr>
	</table>
	<br>
</form>



