<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/inc_header.jsp" %>
<table border="1" align="center" width="80%">
	<tr>
		<td colspan="10"><h2>회원목록</h2></td>
	</tr>
	<tr>
		<th>순번</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>성별</th>
		<th>출생연도</th>
		<th>가입일</th>
	</tr>
	<c:if test="${list.size() == 0 }">>
		<tr>
			<td colspan="10" height="200" align="center">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.id }</td>
			<td>${dto.passwd }</td>
			<td>
				<a href="#" onclick="GoPage('member_view','','${dto.no}')">
					${dto.name }
				</a>
			</td>
			<c:choose>
			<c:when test="${dto.gender == 'M' }">
			<td>남자</td>
			</c:when>
			<c:when test="${dto.gender == 'F' }">
			<td>여자</td>
			</c:when>
			</c:choose>
			<td>${dto.bornYear }</td>
			<td>${dto.regiDate }</td>
		</tr>
	</c:forEach>
	<c:if test="${totalRecord>0}">
		<tr>
			<td colspan="7" height="50" align="center">
				<a href="#" onclick="GoPage('member_list', '1', '');">[첫페이지]</a>
				<c:if test="${startPage > blockSize}">
					<a href="#" onclick="GoPage('member_list', '${startPage - blockSize}', '');">[이전페이지]</a>
				</c:if>
				<c:if test="${startPage <= blockSize}">
					[이전페이지]
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${lastPage }" step="1">
					<c:if test="${i == pageNumber }">
						[${i}]
					</c:if>
					<c:if test="${i != pageNumber }">
						<a href="#" onclick="GoPage('member_list','${i}','');">${i }</a>
					</c:if>
				</c:forEach>
				<c:if test="${lastPage < totalPage}">
					<a href="#" onclick="GoPage('member_list', '${startPage + blockSize}', '');">[다음페이지]</a>
				</c:if>
				<c:if test="${lastPage>=totalPage}">
					[다음페이지]
				</c:if>
				<a href="#" onclick="GoPage('member_list', '${totalPage}', '');">[끝페이지]</a>
			</td>
		</tr>
	</c:if>
	<c:if test="${sessionScope.cookNo == null ||sessionScope.cookNo == 0}">
		<tr>
			<td colspan="7" height="50" align="right">
				<button type="button" onclick="GoPage('member_join')">
					가입하기
				</button>
			</td>
		</tr>
	</c:if>
	
	
</table>


<script>
function GoPage(value1, value2, value3) {
	if(value1 == 'member_list') {
		location.href='${path}/member_servlet/list.do?pageNumber=' + value2;
	}else if(value1 == 'member_join') {
		location.href = '${path}/member_servlet/chuga.do';
	}else if (value1 = 'member_view') {
		location.href = '${path}/member_servlet/view.do?pageNumber=' + value2 + '&no=' + value3;
	}
	
}

</script>









<%--
String pageNumber_ = "12a34ㄱㄴㄷ";
char imsi;

for(int i=0; i<pageNumber_.length(); i++) {
	imsi = pageNumber_.charAt(i);
	if(imsi>='0' && imsi <= '9') {
		out.println(imsi + ":숫자입니다. <br>");
	}else if(imsi >= 'a' && imsi <= 'z') {
		out.println(imsi + ":소문자입니다. <br>");
	}else if(imsi >= 'A' && imsi <= 'Z') {
		out.println(imsi + ":대문자입니다. <br>");
	}else if(imsi >= 'ㄱ' && imsi <= 'ㅎ') {
		out.println(imsi + ":한글자음입니다. <br>");
	}
	
}


--%>



