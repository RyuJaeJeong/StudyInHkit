<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../../include/inc_header.jsp" %>    
    
<table align="center" width="1000px" border="1">
	<tr>
		<td colspan="2">
			<h1>상품상세보기</h1>
		</td>
	</tr>
	<tr>
		<td width="150">상품코드</td>
		<td>${dto.no  }</td>
	</tr>
	<tr>
		<td>상품사진</td>
		<td>
			<c:if test="${dto.product_img == '-,-,-' }">
				이미지x
			</c:if>
			<c:if test="${dto.product_img != '-,-,-' }">
					<c:set var = "temp1" value="${fn:split(dto.product_img,',')[0]}"></c:set>
					<c:set var = "temp2" value="${fn:split(temp1,'|')[0]}"></c:set>
					<c:set var = "temp3" value="${fn:split(temp1,'|')[1]}"></c:set>
					<a href="#" onclick="suntaek_proc('view','','${dto.no}');">
					<img src="${path }/attach/product_img/${temp3}" style="width:50px; heignt:50px;">
					</a>
					
			</c:if>
		</td>
	</tr>
	<tr>
		<td>상품명</td>
		<td>${dto.name}</td>
	</tr>
	<tr>
		<td>가격 </td>
		<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.price }" /></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<td>${dto.description}</td>
	</tr>
	<tr>
		<td>파일명</td>
		<td>${fn:split(dto.product_img, '|')[0]}</td>
	</tr>
	<tr>
		<td>장바구니수량</td>
		<td><fmt:formatNumber type="number" maxFractionDigits="3" value="0" /></td>
	</tr>
	<tr>
		<td>등록날짜</td>
		<td>${dto.regi_date}</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<button type="button" onclick="suntaek_proc('chuga', '1', '')">상품등록</button>
			<button type="button" onclick="suntaek_proc('sujung', '', '${dto.no}')">상품수정</button>
			<button type="button" onclick="suntaek_proc('sakje', '', '${dto.no}')">상품삭제</button>
			<button type="button" onclick="suntaek_proc('list', '1', '')">목록으로</button>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
					<table border="1" width="100%" align="center">
						<tr>
							<td width="150" height="100px">이전글  </td>
							<td>
								<c:if test="${dto.preName == null}">
								  	이전글이 없습니다.
								</c:if>
								<c:if test="${dto.preName != null}">
								  	<a href="#" onclick="suntaek_proc('view','' ,'${dto.preNo}');">${dto.preName}</a>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="150" height="100px">다음글  </td>
							<td>
								<c:if test="${dto.nxtName == null}">
								  	다음글이 없습니다.
								</c:if>
								<c:if test="${dto.nxtName != null}">
								  	<a href="#" onclick="suntaek_proc('view','' ,'${dto.nxtNo}');">${dto.nxtName}</a>
								</c:if>
							</td>
						</tr>
					</table>
			</td>
	</tr>
</table>


