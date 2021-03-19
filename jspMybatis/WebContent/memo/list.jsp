<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

총 <strong>${totalRecord}</strong> 건의 메모가 저장되어있습니다.
<table border="1" align="center" style="width:1000px">
	<tr>
		<th>체크</th>
		<th>아이디</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
	
	<c:if test="${totalRecord == 0}">
			<tr>
				<td height="200" colspan="10">
					<table align="center" style="width:100%; heignt:200px;">
						<tr>
						 	<td align="center" ><strong>등록된 내용이 없습니다.</strong></td>
						</tr>
					</table>
				</td>
			</tr>
	</c:if>
	
	<c:forEach var="dto" items="${arr}">
		<tr>
			<td><input type="checkbox" name="chk" id="chk" value="${dto.id}"></td>
			<td>${jj}</td>
			<td>${dto.name}</td>
			<td>${dto.content}</td>
			<td>${dto.wdate}</td>
		</tr>
		<c:set var="jj" value="${jj-1}"></c:set>
	</c:forEach>
	<tr>
		<td colspan="5"  align="right" >
			<button type="button" onclick="suntaek_proc('sujung', '', '');">불러오기</button>
			<button type="button" onclick="suntaek_proc('delete', '', '');">삭제하기</button>
		</td>
	</tr>
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