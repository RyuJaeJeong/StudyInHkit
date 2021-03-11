<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/inc_header.jsp" %>    

<table align="center" width="80%" border="1">
	<tr>
		<td colspan="2">
			<h1>상품수정 - ${dto.no }</h1>
		</td>
	</tr>
	
	</tr>
	<tr>
		<td>상품명 </td>
		<td><input type="text" name="name" id="name" value="${dto.name}"></td>
	</tr>
	<tr>
		<td>가격 </td>
		<td><input type="text" name="price" id="price" value="${dto.price}"></td>
	</tr>
	<tr>
		<td>상품설명 </td>
		<td>
			<textarea name="description" id="description"  style="width:300px; height:100px" wrap="hard">${dto.description}</textarea>
		</td>
	</tr>
	<tr>
		<td>현재이미지</td>
		<td>
		
			<c:if test="${dto.product_img == '-,-,-'}">
				이미지x
			</c:if>
			<c:if test="${dto.product_img != '-,-,-' }">
					<c:set var = "temp1" value="${fn:split(dto.product_img,',')[0]}"></c:set>
					<c:set var = "temp2" value="${fn:split(temp1,'|')[0]}"></c:set>
					<c:set var = "temp3" value="${fn:split(temp1,'|')[1]}"></c:set>
					<img src="${path}/attach/product_img/${temp3}" style="width:50px; heignt:50px;">	
			</c:if>
		</td>
	</tr>
	<tr>
		<td style="align: center;"> 상품<br>이미지</td>
		<td>
			<input type="file" name="file">
			<input type="file" name="file">
			<input type="file" name="file">
		</td>
	</tr>
	<tr>
		<td colspan="2" style="align:center;">
			<button type="button" id="btnSujung">수정하기</button>
			<button type="button" id="btnList">목록으로</button>
		</td>
	</tr>
</table>



<script>
	$(document).ready(function(){
		$("#name").select();
		$("#name").focus();
		
		$("#btnSujung").click(function (){
			if(confirm('수정하시겠습니까?')) {
				suntaek_proc('sujungProc','0','${dto.no}');
			}
		});
		
		$("#btnList").click(function(){
			
			suntaek_proc('list','1', '');
		});
		
	})
	



</script>