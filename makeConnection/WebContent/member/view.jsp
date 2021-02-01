<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<td>${dto.regidate }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${dto.address} ${dto.detailAddress} ${dto.extraAddress }</td>
		</tr>
		<tr>
			
				
				<td colspan="2" align="center">
					<button type="button" onclick="MOrD('M','${dto.no}')">
					수정하기
					</button>
					<button type="button" onclick="json_test('${dto.no}')">
					json_test
					</button>
				</td>
				
			
			
		</tr>

</table>
<br><br/>
<table border="1" align="center" width="80%">
	<tr>
		<td colspan="10"><h2>회원정보 JSON</h2></td>
	</tr>

		<tr>
			<td>회원번호</td>
			<td id="no"></td>
		</tr>
		<tr>
			<td>아이디</td>	
			<td id="id"></td>
		</tr>	
		<tr>
			<td>비밀번호</td>	
			<td id="passwd"></td>
		</tr>
		<tr>
			<td>이름</td>	
			<td id="name"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td id="gender">
			
			</td>
		</tr>	
		<tr>
			<td>출생연도</td>
			<td id="year"></td>
		</tr>	
			
		<tr>
			<td>가입일</td>
			<td id="date"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td id="add"></td>
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

function json_test(value1) {
	alert('json');
	var param = "no=" + value1;
    $.ajax({
    	type: "post",
    	data: param,
    	url:
    		"${path}/member_servlet/json_test.do",
    	success: function(result) {
    		var json_sj = JSON.parse(result);
    		$("#no").text(json_sj.no);
    		$("#id").text(json_sj.id);
    		$("#passwd").text(json_sj.passwd);
    		$("#name").text(json_sj.name);
    		$("#gender").text(json_sj.gender);
    		$("#year").text(json_sj.bornYear);
    		$("#date").text(json_sj.date);
    		 $("#add").text(json_sj.add);
    	}	
    });
}

</script>