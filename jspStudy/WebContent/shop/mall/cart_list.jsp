<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/inc_header.jsp"%>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<table border="1" align="center" style="width:1000px">
	<tr>
		<td colspan="20">
			<h2>장바구니 목록</h2>
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
						 	<td align="center"> <strong>장바구니가 비어있습니다.</strong> </td>
						</tr>
					</table>
				</td>
			</tr>
		</c:if>
	<c:if test="${totalRecord > 0}">	
	<tr>
		<td>
			<table>
				<tr>
					<th><input type="checkbox" name="checkAll" id="checkAll" value="on"></th>
					<th>상품사진</th>
					<th>상품명</th>
					<th>가격</th>
					<th>수량</th>
					<th>금액</th>
					<th>등록일</th>
				</tr>
				
				<c:set var="hab_money" value="0"></c:set>
				<c:set var="i" value="1"></c:set>
				<c:forEach var="dto" items="${arr}">
					<span id="b_${dto.no }" style="display:none;">
						${dto.memberNo },
						${dto.productNo },
						${dto.amount }
					</span>
					<tr>
						<td align="center">
							<input type="checkbox" name="chk" id="chk" value="${dto.no}">
						</td>
						<td>
							<c:choose>
								<c:when test="${fn:split(dto.product_img, ',')[0] == '-'}">
										<a href="#" onclick="suntaek_proc('cart_view', '', '${dto.productNo}')">이미지x</a>
								</c:when>
								<c:otherwise>
									<c:set var = "temp1" value="${fn:split(dto.product_img,',')[0]}"></c:set>
									<c:set var = "temp2" value="${fn:split(temp1,'|')[0]}"></c:set>
									<c:set var = "temp3" value="${fn:split(temp1,'|')[1]}"></c:set>
									<a href="#" onclick="suntaek_proc('cart_view','','${dto.no}');">
										<img src="${path }/attach/product_img/${temp3}" style="width:50px; heignt:50px;">
									</a>
								</c:otherwise>
							</c:choose>	
						</td>
						<td>${dto.product_name}</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.product_price }" /></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.amount }" /></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.buy_money }" /></td>
						<td>${dto.regi_date}</td>
					</tr>
					<c:set var="i" value="${i = i+1}"></c:set>
					<c:set var="hab_money" value="${hab_money = hab_money + dto.buy_money}"></c:set>
				</c:forEach>
				<tr>
					<td align="right" colspan="7" style="padding: 10px 20px;">
						합계금액 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${hab_money }" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<a href="#" onclick="suntaek_proc('mall_list','1','');">[첫페이지]</a> &nbsp;&nbsp;
					<c:if test="${startPage>blockSize}">
					<a href="#" onclick="suntaek_proc('cart_list','${startPage-blockSize}','');">[이전10개]</a>
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
							<a href="#" onclick="suntaek_proc('cart_list','${i}','');">[${i}]</a>
						</c:if>
						
						
					</c:forEach>
					<c:if test="${lastPage<totalPage}">
							<a href="#" onclick="suntaek_proc('cart_list','${startPage+blockSize}','');">[다음10개]</a>
					</c:if>
					<c:if test="${lastPage>=totalPage}">
							[다음10개]	
					</c:if>
						&nbsp;&nbsp;
				<a href="#" onclick="suntaek_proc('cart_list','${totalPage}','');">[마지막페이지]</a> &nbsp;&nbsp;
		</td>
	</tr>		
</c:if>
	<tr>
		<td colspan="20" height="50" align="right">
			<button type="button" onclick="suntaek_proc('buy','','${dto.no}')">바로구매</button>
			<button type="button" onclick="suntaek_proc('cart_list', '1', '')">장바구니</button>
			<button type="button" onclick="suntaek_proc('mall_list', '1', '')">쇼핑하기</button>
			<button type="button" onclick="suntaek_proc('cart_clear', '1', '')">장바구니 비우기</button>
		</td>
	</tr>
</table>

<script>
		$(document).ready(function(){
			$("#checkAll").click(function(){
				if($("#checkAll").prop("checked")) {
					$("input[name=chk]").prop("checked", true);
				}else {
					$("input[name=chk]").prop("checked", false);
				}
			});
		});
		
		
		
</script>



<%--

tbl : 게시판 구분

게시판 추가
테이블
소스수정





 --%>
