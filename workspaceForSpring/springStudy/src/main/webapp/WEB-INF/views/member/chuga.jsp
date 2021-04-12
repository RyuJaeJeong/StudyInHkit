<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/inc_header.jsp" %>
<html>
<head>

<script>
	$(document).ready(function(){
		//var content = $("#content").val().replace(/(?:\r\n|\r|\n)/g,'<br/>');
		//$("#content").val("--> " + content);
		
		$("#writer").focus();
		
		$("#btnChuga").click(function(){
			if (confirm('가입하시겠습니까?')) {
				suntaek_proc('chugaProc', '1', '');
			}
		});
		
		$("#btnSujung").click(function(){
			if (confirm('수정하시겠습니까?')) {
				suntaek_proc('sujungProc', '1', '${dto.no}');
			}
		});
		
    	$("#btnList").click(function(){
    		suntaek_proc('list', '1', '');
		});
    	
    	$("#id_check_div").click(function(){
    		id_check_div();
		});
    	
	});
	
	
	 function id_check_div() {			//아이디 중복 체크 
	    	var id = $("#id").val();
	    	if(id == '') {
	    		$("#label_id").html (
	    			'아이디를 입력하세요');
	    		$("#label_id").css (
	        		'color', 'green');
	    		$("#label_id").css (
	    		'font-size', '8px');
	    		return
	    		
	    	}
	    	
	    	 var param = "id=" + id;
	    	    $.ajax({
	    	    	type: "post",
	    	    	data: param,
	    	    	url:
	    	    		"${path}/member/id_check.do",
	    	    	success: function(result) {
	    	    		if(result>0) {
	    	    			$("#id").val('');
	    	    			$("#label_id").html("사용할 수 없는 아이디입니다.");
	    	    			$("#label_id").css('color', 'red');
	    	    			$("#label_id").css('font-size', '8px');
	    	    		}else {
	    	    			$("#label_id").html("사용할 수 있는 아이디입니다.");
	    	    			$("#label_id").css('color', 'blue');
	    	    			$("#label_id").css('font-size', '8px');
	    	    		}
	    	    	} 	
	    	    });
	    }
	
</script>


<%-- 
* 도로명 주소

가. 도로명 주소 사이트
이메일 발송을 위해서는 메일 서버가 필요함

- 행정자치부 
  http://www.juso.go.kr

- 개발자센터에서 API 신청 가능
  https://www.juso.go.kr/addrlink/devAddrLinkRequestWrite.do?returnFn=write&ctcMenu=URL
  
               
 나. 우편번호, 주소 서비스 방법
 
 1) 직접 구축
 2018년 9월 현재 건물 DB 다운로드 141MB, 압축풀면 1.72휴
 http://www.juso.go.kr/addrlink/addressBuildDevNew.do?menu=mainJusoDb
 
 - 예를 들어 세종시 자료를 엑셀에서 읽어들임(구분자 |)
 - 텍스트 파일을 엑셀로 읽어서 (구분자 |) csv로 변환한 후 필요한 컬럼만 선택한 후 저장
 - 데이타를 import할 테이블을 미리 생성한 후
 - SQL Developer에서 import하여 테이블로 저장
 
 
 
 2) API 사용
 
 * 다음 API
 - http://postcode.map.daum.net/guide
--%>	


<!-- 다음 api 스크립트 추가 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
    
     
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1" align="center" width="80%">
	<tr>
		<td colspan="2">
			<c:if test="${menu_gubun == 'member_chuga' }">
				<h2>회원가입</h2>
			</c:if>	
			<c:if test="${menu_gubun == 'member_sujung' }">
				<h2>회원정보 수정</h2>
			</c:if>	
		</td>
	</tr>
	<tr>
	
		
		<td width="150">아이디</td>
		<td>
			<c:if test="${menu_gubun == 'member_chuga' }">
				<input type="text" name="id" id="id" value="">
				
			</c:if>	
			<c:if test="${menu_gubun == 'member_sujung' }">
				<input type="text" name="id" id="id" value="${dto.id}" readonly>
			</c:if>	
			
			<button type="button" id="id_check_div">아이디찾기</button>
			<button type="button" onclick="id_check_win()">아이디찾기(새창)</button>
			<br>
			<label id="label_id"></label>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd" id="passwd" value="${dto.passwd}"></td>
	</tr>
	<tr>
		<td>비밀번호확인</td>
		<td><input type="password" name="passwdChk" id="passwdChk" value=""></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name" value="${dto.name}"></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<c:if test="${menu_gubun == 'member_chuga' }">
				<input type="radio" name="genderRadio" value="M" onclick="checkGender('M')"> 남자 &nbsp;&nbsp;&nbsp; 
				<input type="radio" name="genderRadio" value="F" onclick="checkGender('F')"> 여자
					<br>
				<input type="hidden" name=gender" id="gender">
			</c:if>	
			<c:if test="${menu_gubun == 'member_sujung' }">
				<c:if test="${dto.gender == 'M' }">
					<input type="radio" name="genderRadio" value="M" onclick="checkGender('M')" checked> 남자 &nbsp;&nbsp;&nbsp; 
					<input type="radio" name="genderRadio" value="F" onclick="checkGender('F')"> 여자
						<br>
					<input type="hidden" name=gender" id="gender" value="${dto.gender }">
				</c:if>	
				<c:if test="${menu_gubun == 'F' }">
					<input type="radio" name="genderRadio" value="M" onclick="checkGender('M')" > 남자 &nbsp;&nbsp;&nbsp; 
					<input type="radio" name="genderRadio" value="F" onclick="checkGender('F')" checked> 여자
						<br>
					<input type="hidden" name=gender" id="gender" value="${dto.gender }">
				</c:if>
			</c:if>	
			
		</td>
	</tr>
	<tr>
		<td>태어난년도</td>
		<td><input type="text" name="bornYear" id="bornYear" value="${dto.bornYear}"></td>
	</tr>
	<tr>
		<td rowspan="3">주소</td>
		<td>
			<input type="text" id="postcode" placeholder="우편번호" value="${dto.postcode}">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" id="address" placeholder="주소" value="${dto.address}">
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" id="detailAddress" placeholder="상세주소" value="${dto.detailAddress}">
			<input type="text" id="extraAddress" placeholder="참고항목" value="${dto.extraAddress}">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" style="height:50px;">
			
			
			<c:if test="${menu_gubun == 'member_chuga' }">
				<button type="button" id="btnChuga">가입하기</button>
			</c:if>	
			<c:if test="${menu_gubun == 'member_sujung' }">
				<button type="button" id="btnSujung">수정하기</button>
			</c:if>
			
			<button type="button" id="btnList">목록으로</button>
		</td>
	</tr>
</table>

</body>
</html>