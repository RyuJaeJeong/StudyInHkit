<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<table border="1" align="center" style="width:1000px">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
	
	<c:forEach var="dto" items="${arr}">
		<tr>
			<td>${jj}</td>
			<td>${dto.name}</td>
			<td>${dto.content}</td>
			<td>${dto.wdate}</td>
		</tr>
		<c:set var="jj" value="${jj-1}"></c:set>
	</c:forEach>
	<tr>
		<td colspan="20" align="center">
			<a href="#" onclick="suntaek_page('1')">[첫페이지]</a> &nbsp;&nbsp;
			<c:if test="${startPage>blockSize}">
			<a href="#" onclick="suntaek_page('${startPage-blockSize}');">[이전10개]</a>
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
					<a href="#" onclick="suntaek_page('${i}');">[${i}]</a>
				</c:if>
				
				
			</c:forEach>
			<c:if test="${lastPage<totalPage}">
					<a href="#" onclick="suntaek_page('${startPage+blockSize}');">[다음10개]</a>
			</c:if>
			<c:if test="${lastPage>=totalPage}">
					[다음10개]	
			</c:if>
				&nbsp;&nbsp;
			<a href="#" onclick="suntaek_page('${totalPage}');">[마지막페이지]</a> &nbsp;&nbsp;
		</td>
	</tr>

</table>