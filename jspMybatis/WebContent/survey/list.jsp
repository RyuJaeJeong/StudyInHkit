<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/inc_header.jsp"%>

<table style="width:80%;">
	<tr>
		<td colspan="7">
			<h3>설문 조사 목록</h3>
		</td>
	</tr>
	
	
	<tr>
		<td colspan="7">
			<select name="search_option" id="search_option">
			<c:choose>
				<c:when test="${search_option == 'question' }">
					<option value="">- 선 택 -</option>	
					<option  value="question" selected>질문내용</option>
				</c:when>
				<c:otherwise>
					<option value=""  selected>- 선 택 -</option>	
					<option value="question">질문내용</option>
				</c:otherwise>	
			</c:choose>
			</select>
			<input type="text" name="search_data" id="search_data" value="${search_data}" style="width: 150px;">
			<input type="date" name="search_data_s" id="search_data_s" value="${search_data_s}">
			<input type="date" name="search_data_e" id="search_data_e" value="${search_data_e}">
			<br>
			<input type="checkbox" name="search_date_check" id="search_date_check" value="O" ><span style="color:blue; font-size: 9px;">(날짜 검색시 체크)</span>
			&nbsp;
			<input type="button" id="abs"  value="검색" onclick="search();">
			</td>
	</tr>
	<tr>
		<td style="padding: 10px 0px 5px;">전체${totalRecord}건 입니다.</td>
	</tr>
	<tr>
		<td style="padding: 0 0 20px 0;">
			<table border="1" style="width:100%;">
				<tr>
					<th>순번</th>
					<th>질문</th>
					<th>기간</th>
					<th>참여수</th>
					<th>상태</th>
				</tr>
				<c:if test ="${totalRecord==0}" >
						<tr>
							<td colspan="7">
								"표시 할 내용이 없습니다."
							</td>
						</tr>
				</c:if>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${jj}</td>
						<td><a href="#" onclick="suntaek_proc('view', '', '${dto.no}');">${dto.question}</a></td>
						<td>${dto.start_date}<br/>${dto.last_date}</td>
						<td align="center">${dto.survey_counter}</td>
						<td align="center">${dto.status}</td>
					</tr>
					<c:set var="jj" value="${jj=jj-1}"></c:set>
					
				</c:forEach>
			
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="center">
			<a href="#" onclick="suntaek_page('1')">[첫페이지]</a> &nbsp;&nbsp;
			<c:if test="${startPage>blockSize}">
			<a href="#" onclick="suntaek_page('${startPage-blockSize}');">[이전10개]</a>
			</c:if>
			<c:if test="${startPage<=blockSize}">
				[이전10개]	
			</c:if>
			&nbsp;
			<c:forEach var="i" begin="${startPage }" end="${lastPage }" step="1">
				<c:if test="${i == pageNumber }">
					[${i}]
				</c:if>
				<c:if test="${i != pageNumber }">
					<a href="#" onclick="suntaek_page('${i}');">[${i}]</a>
				</c:if>
				<c:if test="${lastPage<totalPage}">
					<a href="#" onclick="suntaek_page('${startPage+blockSize}');">[다음10개]</a>
				</c:if>
				<c:if test="${lastPage>=totalPage}">
					[다음10개]	
				</c:if>
				&nbsp;&nbsp;
				<a href="#" onclick="suntaek_page('${totalPage}');">[마지막페이지]</a> &nbsp;&nbsp;
				
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td colspan="7" height="50" align="right">
			<button type="button" onclick="suntaek_list('all');">전체 설문목록</button>
			<button type="button" onclick="suntaek_list('ing');">진행중인 설문목록</button>
			<button type="button" onclick="suntaek_list('end');">종료된 설문목록</button>
			<button type="button" onclick="suntaek_proc('chuga', '', '');">등록하기</button>
		</td>
	</tr>
</table>

