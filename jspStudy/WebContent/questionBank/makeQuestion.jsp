<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>

<form name="qFrm" id="qFrm">
	<table align="center" style="width: 80%;">
    <tr>
        <td align="center" colspan="2"> <h3>문제 등록</h3></td>
    </tr>
    <tr>
        <td align="right">문제</td>
        <td align="center"><input type="text" name="question" id="question"></td>
    </tr>
    <tr>
        <td align="right">답변1</td>
        <td align="center"><input type="text" name="answer1" id="answer1"></td>
    </tr>
    <tr>
        <td align="right">답변2</td>
        <td align="center"><input type="text" name="answer2" id="answer2"></td>
    </tr>
    <tr>
        <td align="right">답변3</td>
        <td align="center"><input type="text" name="answer3" id="answer3"></td>
    </tr>
    <tr>
        <td align="right">답변4</td>
        <td align="center"><input type="text" name="answer4" id="answer4"></td>
    </tr>
    <tr>
        <td align="right">상태</td>
        <td align="center">
            <input type="radio" name="status" id="status" value="1"> 활성화
            <input type="radio" name="status" id="status" value="0"> 비활성화
        </td>
    </tr>
    <tr>
        <td align="right">시작일</td>
        <td align="center">
           <input type="date" name="start_date" value="">
        </td>
    </tr>
    <tr>
        <td align="right">종료일</td>
        <td align="center">
           <input type="date" name="last_date" value="">
        </td>
    </tr>
    
    <tr>
        <td align="center" colspan="2">
            <br>
            <button type="button" id="btnSave" onclick="makeQ()">저장하기</button>
            <button type="button" id="btnList">목록으로</button>
        </td>
    </tr>
	</table>

</form>

<script>
function makeQ {
	if(confirm('문제를 등록 하시겠습니까?')) {
		qFrm.method="post";
		qFrm.action="${path}/questionBank_servlet/makeQuestionProc.do";
		qFrm.submit();
	}
}
</script>