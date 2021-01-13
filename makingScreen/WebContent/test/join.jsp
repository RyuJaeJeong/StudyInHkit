<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
function test01() {
	$("#d1").show();
	$("#d2").hide();
	$("#d3").hide();
}
function test02() {
	$("#d1").hide();
	$("#d2").show();
	$("#d3").hide();
}
function test03() {
	$("#d1").hide();
	$("#d2").hide();
	$("#d3").show();
}
</script>
</head>
<body>

	<table align="center">
	
		<tr>
			<td><input type="text" name="email" value="" placeholder="이메일 주소 입력" style="width:300px;"></td>
			
		</tr>
		<TR>
			<td> 반드시 올바른 이메일 사용 </td>
		</TR>
		<tr>
			<td><input type="text" name="pass" value="" placeholder="비밀번호(8자리 이상)" style="width:300px;"></td>
		</tr>
		<tr>
			<td><input type="text" name="passcheck" value="" placeholder="비밀번호 확인" style="width:300px;"></td>
		</tr>
		<tr>
			<td><input type="text" name="nme" value="" placeholder="의견작성시 사용하는 이름을 적어 주세요" style="width:300px;" ></td>
		</tr>
		<tr>
			<td>
				<select name="interesting">
					<option value="">선택하세요</option>
					<option value="게임">게임</option>
	       			<option value="SNS">SNS</option>
	        		<option value="동영상">동영상</option>    
	       			<option value="검색">검색</option>
				</select>
			</td>
		</tr>
		<tr>
				<td><input type="text" name="email" value="" style="width:200px;" placeholder="휴대폰 번호 입력('-' 제외)">
				<button type="button" >인증번호 발송</button></td>
		</tr>
		<tr>
				<td><input type="text" name="nme" value="" placeholder="인증번호 입력" style="width:300px;" ></td>
		</tr>
		<TR>
				<td> 인증번호가 정확한지 확인해주세요. </td>
		</TR>
		<tr>
			<td>
				<button type="button" id="btn01" onclick="test01();" style="width:90px;">서비스 이용약관</button>
				&nbsp;
				<button type="button" id="btn02" onclick="test02();" style="width:90px;">개인정보 취급방침</button>
				&nbsp;
				<button type="button" id="btn03" onclick="test03();" style="width:90px;">개인정보 제공동의</button>
			</td>
		</tr>
		<tr>
			<td>
				<div id="d1" style="display: none;" >
				<textarea id="t1" style="width:300px; height:50px;">서비스 이용약관</textarea>
				</div>
				<div id="d2" style="display: none;" >
				<textarea id="t2" style="width:300px; height:50px;">개인정보 취급방침</textarea>
				</div>
				<div id="d3" style="display: none;" >
				<textarea id="t3" style="width:300px; height:50px;">개인정보 제공동의</textarea>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<input type="radio" id="check" value="">서비스 이용약관, 개인정보 취급방침,<br> 개인정보제공 동의 
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" style="width:90px;">취소</button>
				&nbsp;
				<button type="button" onclick="join();" style="width:90px; float:right;" >회원가입</button>
			</td>
		</tr>
	</table>
	
</body>
</html>

<script>
function join() {
	alert('회원가입이 완료되었습니다.');
	location.href='login.jsp';
}
</script>