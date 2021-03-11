<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<table border ="2"  align="center" style="width:1000px; margin-top: 200px;">
		<tr>
			<td colspan="20">
				전체 ${totalRecord} 건입니다.
			</td>
		</tr>
		
		
		
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>생일</th>
		<th>이메일</th>
	</tr>
	
	<c:if test="${totalRecord == 0}">
			<tr>
				<td colspan="10" height="200">
					<table  align="center" style="width:1000px; heignt:200px;">
						<tr>
						 	<td align="center"><strong>등록된 내용이 없습니다.</strong></td>
						</tr>
					</table>
				</td>
			</tr>
		</c:if>
	
	<c:forEach var="dto" items="${arr}">
		<tr>
			<td>
				${jj}
			</td>
			<td>${dto.name}</td>
			<td>${dto.bornYear}</td>
			<td>${dto.email}</td>
		</tr>
		<c:set var="jj" value="${jj-1}"></c:set>
	</c:forEach>
	<tr>
		<td colspan="20" align="center">
			<a href="#" onclick="GoPage('list', '1', '');">[첫페이지]</a> &nbsp;&nbsp;
			<c:if test="${startPage>blockSize}">
			<a href="#" onclick="GoPage('list', '${startPage-blockSize}', '');">[이전10개]</a>
			</c:if>
			<c:if test="${startPage<=blockSize}">
				[이전10개]	
			</c:if>
			&nbsp;
			<c:forEach var="i" begin="${startPage}" end="${lastPage}" step="1">
				<c:if test="${i == pageNumber }">
					[${i}]
				</c:if>
				<c:if test="${i != pageNumber }">
					<a href="#" onclick="GoPage('list', '${i}', '');">[${i}]</a>
				</c:if>
				
				
			</c:forEach>
			<c:if test="${lastPage<totalPage}">
					<a href="#" onclick="GoPage('list', '${startPage+blockSize}', '');');">[다음10개]</a>
			</c:if>
			<c:if test="${lastPage>=totalPage}">
					[다음10개]	
			</c:if>
				&nbsp;&nbsp;
			<a href="#" onclick="GoPage('list', '${totalPage}', '');">[마지막페이지]</a> &nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="20" height="50" align="right">
			<button type="button" onclick="GoPage('list', '1', '');">전체목록</button>
			<button type="button" onclick="GoPage('mail', '', '');">메일전송</button>
			<button type="button" onclick="GoPage('BirthdayMail', '', '');">생일회원관리</button>
		</td>
	</tr>
</table>


</body>
</html>

<script>
function GoPage(value1, value2, value3) {
	if(value1=='list') {
		location.href = '${path}/client_servlet/list.do?pageNumber=' + value2;
	}else if(value1 =='mail') {
		location.href = '${path}/client_servlet/mail.do';
	}else if(value1 =='BirthdayMail') {
		location.href = '${path}/client_servlet/BirthdayMail.do';
	}
}	 
</script>
