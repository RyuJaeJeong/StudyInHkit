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
			 <select name="amount" id="amount">
			 	<c:forEach var="i" begin="1" end="10" step="1">
			 		<option value="${i}">${i}</option>
			 	</c:forEach>
			</select> 
			<button type="button" onclick="suntaek_proc('cart_chuga','','${dto.no}')">장바구니담기</button>
			<button type="button" onclick="suntaek_proc('buy','','${dto.no}')">바로구매</button>
			<button type="button" onclick="suntaek_proc('cart_list', '1', '')">장바구니</button>
			<button type="button" onclick="suntaek_proc('mall_list', '1', '')">쇼핑하기</button>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
					<table border="1" width="100%" align="center">
						<tr>
							<td width="150" height="100px">이전글  </td>
							<td>
								<c:if test="${dto.preName == null}">
								  	이전 상품이 없습니다
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
								  	다음 상품이 없습니다.
								</c:if>
								<c:if test="${dto.nxtName != null}">
								  	<a href="#" onclick="suntaek_proc('mall_view','' ,'${dto.nxtNo}');">${dto.nxtName}</a>
								</c:if>
							</td>
						</tr>
					</table>
			</td>
	</tr>
</table>