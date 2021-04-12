<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../../include/inc_header.jsp" %>

<table border="1" align="center" width="1000px">

	<tr>
		<td colspan="2">
			<h2>상품등록</h2>
		</td>
	</tr>
	<tr>
		<td style="align: center;">상품명</td>
		<td>
			<input type="text" name="name" id="name" style="width: 98%;"> 
		</td>
	</tr>
	<tr>
		<td style="align: center;">상품가격</td>
		<td>
			<input type="text" name="price" id="price" style="width: 98%;"> 
		</td>
	</tr>
	<tr>
		<td style="align: center;">상품설명</td>
		<td>
			<textarea name="description" id="description" style="width:98%; height:300px;" wrap="hard"></textarea>
		</td>
	</tr>
	<tr>
		<td style="align: center;"> 상품<br>이미지</td>
		<td>
			<input type="file" name="file">	<br>
			<input type="file" name="file">	<br>
			<input type="file" name="file">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="button" id="btnChuga">등록하기</button>
			<button type="button" id="btnList">목록으로</button>
		</td>
	</tr>

</table>


<script>
$(document).ready(function(){
	
		$("#btnChuga").click(function(){
			
			if(confirm('등록하시겠습니까?')) {
				suntaek_proc('chugaProc','1', '');
			}
		});
		
		$("#btnList").click(function(){
				
				suntaek_proc('list','1', '');
		});
	});


</script>