<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>  
    
    <c:if test="${arr==null||arr.size()==0}">
    	
    </c:if>
    
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
	<c:if test="${arr.size() == 0 }">>
		<tr>
			<td colspan="10" height="200" align="center">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${arr}">
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
			<td>${dto.bornYear}</td>
			<td>${dto.regidate}</td>
		</tr>
	</c:forEach>
    
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