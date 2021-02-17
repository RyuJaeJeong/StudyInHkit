<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../include/inc_header.jsp" %>    
    
<c:choose>
	<c:when test ="${ imsiPage == 'viewPasswdPage' }">
		<table border="1" align="center" width="80%">
			<tr>
				<td>
					<h2>글상세보기(비밀글입니다.)</h2>
				</td>
			</tr>
			<tr>
				<td width="150">비밀번호 :</td>
				<td>
					<input type="password" name="view_passwd" id="view_passwd">
					<button type="button" id="btnViewPasswd">확인</button>
				</td>
			</tr>
		</table>
		<script>
			$(document).ready(function(){
				$("#btnViewPasswd").click(function(){
					GoPage('view', $("#span_no").text());
				});
			});
		</script>
	</c:when>
	<c:otherwise>
		<table border="1" align="center" width="80%">
			<tr>
				<td colspan="2">
					<h1>글 상세보기</h1>
				</td>
			</tr>
			<tr>
				<td width="150">작성자 : </td>
				<td>${dto.writer}</td>
			</tr>
			<tr>
				<td width="150">제목 : </td>
				<td>${dto.subject}</td>
			</tr>
			<tr>
	            <td  style="align:center;">비밀번호</td>
	            <td><input type="text" name="passwd" id="passwd" value=""></td>
	        </tr>
			<tr>
				<td width="150">내용 : </td>
				<td id="content">${dto.content}</td>
			</tr>
			<tr>
				<td width="150">이메일 : </td>
				<td>${dto.email}</td>
			</tr>
			<tr>
				<td width="150">조회수 : </td>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<td>현재글의 답변 글 :</td>
				<td>${dto.child_counter }</td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${dto.child_counter == 0 }">
						<button type="button" onclick="GoPage('sakjeProc', '${dto.no}');">삭제하기</button>
					</c:if>
					
					<button type="button" onclick="suntaek_page('1');">목록으로</button>
				</td>
			</tr>
			<tr>
				<td>
					<table border="1" width="100%" align="center">
						<tr>
							<td colspan="2" height="100px">이전글 : </td>
							<td>
								<c:if test="${dto.preSubject == null}">
								  	이전글이 없습니다.
								</c:if>
								<c:if test="${dto.preSubject != null}">
								  	<a href="#" onclick="GoPage('view', '${dto.preNo}');">${dto.preSubject}</a>
								</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="2" height="100px">다음글 : </td>
							<td>
								<c:if test="${dto.nxtSubject == null}">
								  	다음글이 없습니다.
								</c:if>
								<c:if test="${dto.nxtSubject != null}">
								  	<a href="#" onclick="GoPage('view', '${dto.nxtNo}');">${dto.nxtSubject}</a>
								</c:if>
							</td>
						</tr>
					</table>
			</td>
		</tr>
			
		</table>
	</c:otherwise>
</c:choose>

