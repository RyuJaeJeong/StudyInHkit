<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>

<form name="DirFrm">
	<table border="1" align="center" width="1000px">
	<tr>
		<td colspan="2"> <h2>고객 등록</h2></td>
	</tr>
	
	<tr>
		<td width="150"><strong>이름</strong></td>
		<td align="center"><input type="text" name="name" id="name" value="" style="width:100%;"></td>
	</tr>
	
	<tr>
		<td width="150"><strong>생일</strong></td>
		<td>
				
				<select name="lYear">
					<option value="">연도선택</option>
					<c:forEach var="i" begin="${naljaMap['nowY']-100}" end="${naljaMap['nowY']}" step="1" >
						
							<option value="${i}">${i}</option>
						
					</c:forEach>
				</select>
			
				<select name="lMonth">
					<option value="">월선택</option>
					<c:forEach var="i" begin="1" end="12" step="1" >
								<c:if test ="${i<10}">
									<option value="0${i}" >0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" >${i}</option>
								</c:if>
					</c:forEach>
				</select>
			
				<select name="lDay">
					<option value="">일선택</option>
					<c:forEach var="i" begin="1" end="31" step="1" >
						
								<c:if test ="${i<10}">
									<option value="0${i}" >0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" >${i}</option>
								</c:if>
						
					</c:forEach>
				</select>
			</td>
	</tr>
	
	<tr>
		<td width="150"><strong>이메일</strong></td>
		<td><input type="text" name="email" id="email" value="" style="width:100%;"></td>
	</tr>
	
	
	<tr>
		<td colspan="2" align="center" style="height:50px;">
		<button type="button" onclick="join()">join</button>
		<button type="button" onclick="GoList()">list</button>
		</td>
	</tr>
	</table>	

	
</form>

<script>

function join() {
	if(confirm('가입하시겠습니까?')) {
		DirFrm.method="post";
		DirFrm.action="${path}/client_servlet/writeProc.do";
		DirFrm.submit();
	}
}

function GoList() {
	location.href="${path}/client_servlet/list.do";
}


</script>