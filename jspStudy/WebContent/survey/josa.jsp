<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>
<form id="josaFrm">
	<table>
		<tr>
			<td><input type="hidden" name="no" value="${dto.no}"></td>
		</tr>
		<tr>
			<td>Q. ${dto.question}</td>
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
					<button type="button" id="btnSave">저장하기</button>
					&nbsp;
					<button type="button" id="btnList">목록으로</button>
				</td>
		</tr>
	</table>
</form>
<script>
	$(document).ready(function(){ㅎ
		$("#btnSave").click(function(){
			GoJosaProc();
		});
		$("#btnList").click(function(){
			GoList();
		});
	});
</script>