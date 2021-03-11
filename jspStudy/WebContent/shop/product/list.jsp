<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/inc_header.jsp"%>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<table border="1" align="center" style="width:1000px">
	<tr>
		<td colspan="20">
			<h2>상품 목록</h2>
	
		<select name="search_option" id="search_option">
		<c:choose>
			<c:when test="${search_option == 'writer'}">
				<option value="">--선택--</option>
				<option value="writer" selected>작성자</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="writer_subject_content">작성자+제목+내용</option>
			</c:when>
			<c:when test="${search_option == 'subject'}">
				<option value="">--선택--</option>
				<option value="writer">작성자</option>
				<option value="subject" selected>제목</option>
				<option value="content">내용</option>
				<option value="writer_subject_content">작성자+제목+내용</option>
			</c:when>
			<c:when test="${search_option == 'content'}">
				<option value="">--선택--</option>
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content" selected>내용</option>
				<option value="writer_subject_content">작성자+제목+내용</option>
			</c:when>
			<c:when test="${search_option == 'subject_content_writer'}">
				<option value="">--선택--</option>
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="writer_subject_content" selected>작성자+제목+내용</option>
			</c:when>
			<c:otherwise>
				<option value="">--선택--</option>
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="writer_subject_content">작성자+제목+내용</option>
			</c:otherwise>	
		</c:choose>	
		</select>
		
		<input type="text" name="search_data" id="search_data" value="${search_data}" style="width: 150px;">
		&nbsp;
		<input type="button" value="검색" onclick="search();">
		
		<script>
		 function search() {
			 if(confirm('검색하시겠습니까')) {
				 $("#span_search_option").text( $("#search_option").val());
			 	 $("#span_search_data").text( $("#search_data").val());	
			 	 suntaek_page('1');
			 }
		 }
		</script>
		
			</td>
	</tr>
		<tr>
			<td colspan="20">
				전체 ${totalRecord} 건입니다.
			</td>
		</tr>
		
		<c:if test="${totalRecord == 0}">
			<tr>
				<td height="200" colspan="20">
					<table align="center" style="width:100%; heignt:200px;" >
						<tr>
						 	<td align="center"> <strong>등록된 내용이 없습니다.</strong> </td>
						</tr>
					</table>
				</td>
			</tr>
		</c:if>
		
	<tr>
		<th>순번</th>
		<th>상품사진</th>
		<th>상품명</th>
		<th>가격</th>
		<th>파일</th>
		<th>장바구니수</th>
		<th>등록일</th>
	</tr>
	
	<c:forEach var="dto" items="${arr}">
		<tr>
			<td>
				${jj}
			</td>
			<td>
				
				<c:if test="${dto.product_img == '-,-,-' }">
					<a href="#" onclick="suntaek_proc('view','0','${dto.no}')">이미지x</a>
				</c:if>
				<c:if test="${dto.product_img != '-,-,-' }">
					<c:set var = "temp1" value="${fn:split(dto.product_img,',')[0]}"></c:set>
					<c:set var = "temp2" value="${fn:split(temp1,'|')[0]}"></c:set>
					<c:set var = "temp3" value="${fn:split(temp1,'|')[1]}"></c:set>
					
					<a href="#" onclick="suntaek_proc('view','','${dto.no}');">
					<img src="${path }/attach/product_img/${temp3}" style="width:50px; heignt:50px;">
					</a>
				</c:if>
				<%-- 
				<br>
				temp1 : ${temp1} <br>
				temp2 : ${temp2} <br>
				temp3 : ${temp3}
				--%>
				
			</td>
			<td>${dto.name}</td>
			<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.price }" /></td>
			<td>${dto.product_img}</td>
			<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.buy_count }" /></td>
			<td>${dto.regi_date}</td>
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
	<tr>
		<td colspan="20" height="50" align="right">
			<button type="button" onclick="suntaek_all();">전체목록</button>
			<button type="button" onclick="GoPage('chuga', '');">글쓰기</button>
		</td>
	</tr>
</table>


<%--

tbl : 게시판 구분

게시판 추가
테이블
소스수정





 --%>
