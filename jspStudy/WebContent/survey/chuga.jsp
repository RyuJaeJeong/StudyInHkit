<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/inc_header.jsp" %>

<form name ="DirForm" id="DirForm">
	<table align="center" width="80%" border="1">
		<tr>
			<td colspan="2"><h2>설문조사 등록</h2></td>
		</tr>
		<tr>
			<td style="align:center;">Question</td>
			<td><input type="text" name="question" id="question"></td>
		</tr>
		<tr>
			<td style="align:center;">답변1</td>
			<td><input type="text" name="ans1" id="ans1"></td>
		</tr>
		 <tr>
			<td style="align:center;">답변2</td>
			<td><input type="text" name="ans2" id="ans2"></td>
		</tr>
		<tr>
			<td style="align:center;">답변3</td>
			<td><input type="text" name="ans3" id="ans3"></td>
		</tr>
		<tr>
			<td style="align:center;">답변4</td>
			<td><input type="text" name="ans4" id="ans4"></td>
		</tr>
		<tr>
			<td style="align:center;">상태</td>
			<td>
				<input type="radio" name="status" id="status" value="1">활성화
				<input type="radio" name="status" id="status" value="0">비활성화
			</td>
		</tr>
		<tr>
			<td>
				시작일
			</td>
			<td>
				
				<select name="sYear">
					<option value="">연도선택</option>
					<c:forEach var="i" begin="${naljaMap['nowY']-1}" end="${naljaMap['nowY']+1}" step="1" >
						<c:if test="${naljaMap['nowY']==i }">
							<option value="${i}" selected>${i}</option>
						</c:if>
						<c:if test="${naljaMap['nowY']!=i }">
							<option value="${i}">${i}</option>
						</c:if>
					</c:forEach>
				</select>
			
				<select name="sMonth">
					<option value="">월선택</option>
						<c:forEach var="i" begin="01" end="12" step="1" >
							<c:if test="${naljaMap['nowM']==i }">
								<c:if test ="${i<10}">
									<option value="0${i}" selected>0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" selected>${i}</option>
								</c:if>
							</c:if>
							<c:if test="${naljaMap['nowM']!=i }">
								<c:if test ="${i<10}">
									<option value="0${i}" >0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" >${i}</option>
								</c:if>
							</c:if>
						</c:forEach>
				</select>
			
				<select name="sDay">
					<option value="">일선택</option>
					<c:forEach var="i" begin="1" end="31" step="1" >
						<c:if test="${naljaMap['nowD']==i }">
								<c:if test ="${i<10}">
									<option value="0${i}" selected>0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" selected>${i}</option>
								</c:if>
						</c:if>
						<c:if test="${naljaMap['nowD']!=i }">
							<c:if test ="${i<10}">
									<option value="0${i}" >0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" >${i}</option>
								</c:if>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				종료일
			</td>
			<td>
				
				<select name="lYear">
					<option value="">연도선택</option>
					<c:forEach var="i" begin="${naljaMap['nowY']-1}" end="${naljaMap['nowY']+1}" step="1" >
						<c:if test="${naljaMap['nowY']==i }">
							<option value="${i}" selected>${i}</option>
						</c:if>
						<c:if test="${naljaMap['nowY']!=i }">
							<option value="${i}">${i}</option>
						</c:if>
					</c:forEach>
				</select>
			
				<select name="lMonth">
					<option value="">월선택</option>
					<c:forEach var="i" begin="1" end="12" step="1" >
						<c:if test="${naljaMap['nowM']==i }">
							<c:if test ="${i<10}">
									<option value="0${i}" selected>0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" selected>${i}</option>
								</c:if>
						</c:if>
						<c:if test="${naljaMap['nowM']!=i }">
							<c:if test ="${i<10}">
									<option value="0${i}" >0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" >${i}</option>
								</c:if>
						</c:if>
					</c:forEach>
				</select>
			
				<select name="lDay">
					<option value="">일선택</option>
					<c:forEach var="i" begin="1" end="31" step="1" >
						<c:if test="${naljaMap['nowD']==i }">
							<c:if test ="${i<10}">
									<option value="0${i}" selected>0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" selected>${i}</option>
								</c:if>
						</c:if>
						<c:if test="${naljaMap['nowD']!=i }">
							<c:if test ="${i<10}">
									<option value="0${i}" >0${i}</option>
								</c:if>
								<c:if test ="${i>=10}">
									<option value="${i}" >${i}</option>
								</c:if>
						</c:if>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnSave">저장하기</button>
				&nbsp;
				<button type="button" id="btnList">목록으로</button>
			</td>
		</tr>
	</table>
	


</form>

<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			GoChugaProc();
		});
		$("#btnList").click(function(){
			GoList();
		});
	});
	
	
</script>