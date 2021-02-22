<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<table align="center" style="width:1000px">
	${CommentTotalRecord}개의 댓글이 있습니다.
	
	<c:forEach var="dto" items="${arr}">
		<tr>
			<td>${dto.writer}(${dto.regiDate})</td>
		</tr>
		<tr>
			<td>${dto.content}</td>
		</tr>
		
	</c:forEach>
	<tr>
		<td colspan="20" align="center">
			<a href="#" onclick="suntaek_page('1')">[첫페이지]</a> &nbsp;&nbsp;
			<c:if test="${CommentStartPage>CommentBlockSize}">
			<a href="#" onclick="suntaek_page('${CommentStartPage-CommentBlockSize}');">[이전10개]</a>
			</c:if>
			<c:if test="${CommentStartPage<=CommentBlockSize}">
				[이전10개]	
			</c:if>
			&nbsp;
			<c:forEach var="i" begin="${CommentStartPage}" end="${CommentLastPage}" step="1">
				<c:if test="${i == CommentPageNumber }">
					[${i}]
				</c:if>
				<c:if test="${i != CommentPageNumber }">
					<a href="#" onclick="suntaek_page('${i}');">[${i}]</a>
				</c:if>
				
				
			</c:forEach>
			<c:if test="${CommentLastPage<CommentTotalPage}">
					<a href="#" onclick="suntaek_page('${CommentStartPage+CommentBlockSize}');">[다음10개]</a>
			</c:if>
			<c:if test="${CommentLastPage>=CommentTotalPage}">
					[다음10개]	
			</c:if>
				&nbsp;&nbsp;
			<a href="#" onclick="suntaek_page('${CommentTotalPage}');">[마지막페이지]</a> &nbsp;&nbsp;
		</td>
	</tr>

</table>