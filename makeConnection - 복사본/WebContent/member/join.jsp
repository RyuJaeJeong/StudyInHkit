<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="joinFrm">
		<table border="1" style="width:50%" align="center">
		    <h3 align="center">회원가입</h3>
		    <tr>
		        <td>아이디</td>
		        <td>
		        	<input type="text" name="id" id="id" value="">
		        	<label id="label_id"></label>
		        	<button type="button" id="btnCheck1" value="" onclick="id_check();">아이디찾기</button>
		        	<button type="button" id="btnCheck1" value="" onclick="id_check_win_open()">아이디찾기(새창)</button>
		        </td>
		    </tr>
		    <tr>
		        <td>비밀번호</td>
		        <td><input type="text" name="passwd" id="passwd" value=""></td>
		    </tr>
		    <tr>
		        <td>비밀번호확인</td>
		        <td><input type="text" name="passwdChk" id="passwdChk" value=""></td>
		    </tr>
		    <tr>
		        <td>이름</td>
		        <td><input type="text" name="name" id="name" value=""></td>
		    </tr>
		    <tr>
		        <td>성별</td>
		        <td>
		            <input type="radio" name="gender" id="gender" value="M">남자
		            &nbsp; &nbsp;
		            <input type="radio" name="gender" id="gender" value="F">여자
		        </td>
		    </tr>
		    <tr>
		        <td>태어난년도</td>
		        <td><input type="text" name="bornYear" id="bornYear" value=""></td>
		    </tr>
		    <tr>
		        <td>주소</td>
		        <td>
		        	<input type="text" name="postcode" id="sample6_postcode" placeholder="우편번호">
					<input type="button"  onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" name="address" id="sample6_address" placeholder="주소"><br>
					<input type="text" name="detailAddress" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" name="extraAddress"		id="sample6_extraAddress" placeholder="참고항목">
		        </td>
		    </tr>
			<tr>	
				<td colspan="5" align="center"><BUTTON TYPE="BUTTON" onclick="join();">JOIN</BUTTON></td>
			</tr>
		</table>
	</form>	
</body>
</html>






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

function join() {
	if(confirm('회원가입을 진행하시겠습니까?')) {
		joinFrm.method="post";
		joinFrm.action="${path}/member_servlet/joinProc.do";
		joinFrm.submit();
	}
}

function id_check() {			//아이디 중복 체크 
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
	    		"${path}/member_servlet/id_check.do",
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

function id_check_win_open(value1) {		//새창 열어서 아이디 중복 체크 
	window.open("${path}/member_servlet/id_check_win.do", "아이디체크 새창", 
	"width=640, height=480, toolbar=no, menubar=no, resizable=yes");
	
}
</script>