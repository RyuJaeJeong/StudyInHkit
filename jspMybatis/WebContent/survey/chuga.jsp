<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/inc_header.jsp" %>

<form name ="DirForm" id="DirForm" width="80%">
	<table align="center" width="80%" border="1">
		<tr>
			<c:if test="${menu_gubun == 'survey_sujung'}">
				<td colspan="2"><h2>설문조사 수정</h2></td>
			</c:if>
			<c:if test="${menu_gubun == 'survey_chuga'}">
				<td colspan="2"><h2>설문조사 등록</h2></td>
			</c:if>
		</tr>
		<tr>
			<td style="align:center;">Question</td>
			<td><input type="text" name="question" id="question" value="${dto.question}"></td>
		</tr>
		<tr>
			<td style="align:center;">답변1</td>
			<td><input type="text" name="ans1" id="ans1"  value="${dto.ans1}"></td>
		</tr>
		 <tr>
			<td style="align:center;">답변2</td>
			<td><input type="text" name="ans2" id="ans2"  value="${dto.ans2}"></td>
		</tr>
		<tr>
			<td style="align:center;">답변3</td>
			<td><input type="text" name="ans3" id="ans3"  value="${dto.ans3}"></td>
		</tr>
		<tr>
			<td style="align:center;">답변4</td>
			<td><input type="text" name="ans4" id="ans4"  value="${dto.ans4}"></td>
		</tr>
		<tr>
			<td style="align:center;">상태</td>
			<td>
				<c:choose>
					<c:when test="${dto.status == '0' }">
						<input type="radio" name="status" id="status" value="1" >활성화
						<input type="radio" name="status" id="status" value="0" checked>비활성화
					</c:when>	
					<c:when test="${dto.status == '1' }">
						<input type="radio" name="status" id="status" value="1" checked>활성화
						<input type="radio" name="status" id="status" value="0">비활성화
					</c:when>
					<c:otherwise>
						<input type="radio" name="status" id="status" value="1">활성화
						<input type="radio" name="status" id="status" value="0">비활성화
					</c:otherwise>	
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				시작일
			</td>
			<td>
				
				<select name="sYear" id="sYear">
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
			
				<select name="sMonth" id="sMonth">
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
			
				<select name="sDay" id="sDay" >
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
				
				<select name="lYear" id="lYear">
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
			
				<select name="lMonth" id="lMonth">
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
			
				<select name="lDay" id="lDay">
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
			<c:if test="${menu_gubun == 'survey_sujung'}">
					<td colspan="2" align="center">
					<button type="button" id="btnSujung">수정하기</button>
					&nbsp;
					<button type="button" id="btnList">목록으로</button>
					</td>
			</c:if>
			<c:if test="${menu_gubun == 'survey_chuga'}">
				<td colspan="2" align="center">
					<button type="button" id="btnSave">저장하기</button>
					&nbsp;
					<button type="button" id="btnList">목록으로</button>
				</td>
			</c:if>
		</tr>
	</table>
	


</form>

<script>

	$(document).ready(function(){
		$("#btnSave").click(function(){
			if(confirm('문제 등록하시겠습니까?')) {
				suntaek_proc('chugaProc', '1', '');
			}
		});
		$("#btnList").click(function(){
				suntaek_proc('list', '1', '');
		});
		$("#btnSujung").click(function(){
			if(confirm('정말 수정하시겠습니까?')) {
				suntaek_proc('sujungProc', '', '${dto.no}');
			}
		});
		
		
		
	});
	

</script>