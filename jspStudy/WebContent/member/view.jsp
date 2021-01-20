<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/inc_header.jsp" %>


<table border="1" align="center" width="80%">



	<tr>
		<td colspan="10"><h2>회원정보 상세보기</h2></td>
	</tr>

		<tr>
			<td>회원번호</td>
			<td>${dto.no}</td>
		</tr>
		<tr>
			<td>아이디</td>	
			<td>${dto.id }</td>
		</tr>	
		<tr>
			<td>비밀번호</td>	
			<td>${dto.passwd }</td>
		</tr>
		<tr>
			<td>이름</td>	
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
			<c:choose>
			<c:when test="${dto.gender == 'M' }">
			남자
			</c:when>
			<c:when test="${dto.gender == 'F' }">
			여자
			</c:when>
			</c:choose>
			</td>
		</tr>	
		<tr>
			<td>출생연도</td>
			<td>${dto.bornYear }</td>
		</tr>	
			
		<tr>
			<td>가입일</td>
			<td>${dto.regiDate }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${dto.address} ${dto.detailAddress} ${dto.extraAddress }</td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${sessionScope.cookNo == dto.no }">
				<td colspan="2" align="center">
					<button type="button" onclick="MOrD('M','${dto.no}')">
					수정하기
					</button>
					<button type="button" onclick="MOrD('D','${dto.no}')">
					삭제하기
					</button>
				</td>
				</c:when>
			
			<c:otherwise>
				<td colspan="2" align="center">
					&nbsp;&nbsp;
				</td>
			</c:otherwise>
			</c:choose>
		</tr>

</table>

<script>
function MOrD(value1, value2) {
	if(value1 == 'M') {
	location.href='${path}/member_servlet/modify.do?no='+value2;
	}else {
	location.href='${path}/member_servlet/delete.do?no='+value2;	
	}
}


</script>