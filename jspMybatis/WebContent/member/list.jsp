<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/inc_header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" align="center" width="80%">
	
	<tr>
		<td colspan="20">
			<h2>회원목록</h2>
			
		<strong>${totalRecord }</strong> 건 입니다. <br>
		<br>
		<select name="search_option" id="search_option">
		<c:choose>
			<c:when test="${search_option == 'id'}">
				<option value="">--선택--</option>
				<option value="id" selected>아이디</option>
				<option value="name">이름</option>
				<option value="gender">성별</option>
				<option value="id_name_gender">아이디+이름+성별</option>
			</c:when>
			<c:when test="${search_option == 'name'}">
				<option value="">--선택--</option>
				<option value="id" >아이디</option>
				<option value="name" selected>이름</option>
				<option value="gender">성별</option>
				<option value="id_name_gender">아이디+이름+성별</option>
			</c:when>
			<c:when test="${search_option == 'gender'}">
				<option value="">--선택--</option>
				<option value="id" >아이디</option>
				<option value="name">이름</option>
				<option value="gender" selected>성별</option>
				<option value="id_name_gender">아이디+이름+성별</option>
			</c:when>
			<c:when test="${search_option == 'id_name_gender'}">
				<option value="">--선택--</option>
				<option value="id" >아이디</option>
				<option value="name">이름</option>
				<option value="gender">성별</option>
				<option value="id_name_gender" selected>아이디+이름+성별</option>
			</c:when>
			<c:otherwise>
				<option value="">--선택--</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
				<option value="gender">성별</option>
				<option value="id_name_gender">아이디+이름+성별</option>
			</c:otherwise>	
		</c:choose>	
		</select>
		
		<input type="text" name="search_data" id="search_data" value="${search_data}" style="width: 150px;">
		&nbsp;
		<input type="button" value="검색" onclick="search();">
		
		
		
			</td>
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
				<a href="#" onclick="suntaek_proc('view','','${dto.no}')">
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
				<a href="#" onclick="suntaek_proc('list', '1', '');">[첫페이지]</a>
				<c:if test="${startPage > blockSize}">
					<a href="#" onclick="suntaek_proc('list', '${startPage - blockSize}', '');">[이전페이지]</a>
				</c:if>
				<c:if test="${startPage <= blockSize}">
					[이전페이지]
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${lastPage }" step="1">
					<c:if test="${i == pageNumber }">
						[${i}]
					</c:if>
					<c:if test="${i != pageNumber }">
						<a href="#" onclick="suntaek_proc('list','${i}','0');">${i }</a>
					</c:if>
				</c:forEach>
				<c:if test="${lastPage < totalPage}">
					<a href="#" onclick="suntaek_proc('list', '${startPage + blockSize}', '');">[다음페이지]</a>
				</c:if>
				<c:if test="${lastPage>=totalPage}">
					[다음페이지]
				</c:if>
				<a href="#" onclick="suntaek_proc('list', '${totalPage}', '');">[끝페이지]</a>
			</td>
		</tr>
	</c:if>
	<c:if test="${sessionScope.cookNo == null ||sessionScope.cookNo == 0}">
		<tr>
			<td colspan="7" height="50" align="right">
				<button type="button" onclick="suntaek_proc('chuga', '' , '')">
					가입하기
				</button>
				<button type="button" onclick="suntaek_all()">
					전체목록
				</button>
			</td>
		</tr>
	</c:if>
	
	
</table>

</body>
</html>


