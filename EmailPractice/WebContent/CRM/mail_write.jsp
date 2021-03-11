<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<form name="DirFrm">
	<table>
		<tr>	
			<c:if test = "${mail_gubun == 'email_normal' }">
				<td colspan="2">
					<h2>이메일 보내기${mail_gubun}</h2>
					<input type="hidden" name="mail_gubun" value="email_normal">
				</td>
			</c:if>
			<c:if test = "${mail_gubun == 'email_birthday' }">
				<td colspan="2">
					<h2>생일축하 메일 보내기</h2>
					<input type="hidden" name="mail_gubun" value="email_birthday">
				</td>
			</c:if>
		</tr>
		<tr>
			<td style="align:center;">발신자 이름</td>
			<td>
				<input type="text" name="fromName" id="fromName">
			</td>
		</tr>
		<tr>
			<td style="align:center;">발신자 이메일</td>
			<td>
				<input type="text" name="fromEmail" id="fromEmail">
			</td>
		</tr>
		<tr>
			<td style="align:center;">제목</td>
			<td>
				<input type="text" name="subject" id="subject">
			</td>
		</tr>
		<tr>
			<td style="align:center;">내용</td>
			<td>
				<textarea name="content" id="content" style="width:300px; height:100px;" wrap="hard"></textarea>
			</td>
		</tr>
		<tr>	
			<c:if test = "${mail_gubun == 'email_normal' }">
				<td align="center" colspan="2" height="50px;">
					<button type="button" onclick="GoPage()">메일보내기</button>
				</td>
			</c:if>
			<c:if test = "${mail_gubun == 'email_birthday' }">
				<td align="center" colspan="2" height="50px;">
					<button type="button" onclick="GoPage()">메일보내기</button>
				</td>
			</c:if>
		</tr>
	</table>
</form>


<script>
	
function GoPage() {
		DirFrm.method="post";
		DirFrm.action="${path}/client_servlet/mailProc.do";
		DirFrm.submit();
}



</script>