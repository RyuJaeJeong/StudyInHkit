<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		
		<tr>
			<td><input type="text" name="email" value="fb0982@naver.com"  style="width:300px;" readonly></td>
			
		</tr>
		<tr>
			<td><input type="text" name="pass" value="test01" placeholder="비밀번호(8자리 이상)" style="width:300px;"></td>
		</tr>
		<tr>
			<td><input type="text" name="passcheck" value="test01" placeholder="비밀번호 확인" style="width:300px;"></td>
		</tr>
		<tr>
			<td><input type="text" name="nme" value="재정" placeholder="의견작성시 사용하는 이름을 적어 주세요" style="width:300px;" ></td>
		</tr>
		<tr>
			<td>
				<select name="interesting">
					<option value="">선택하세요</option>
					<option value="게임">게임</option>
	       			<option value="SNS" selected>SNS</option>
	        		<option value="동영상">동영상</option>    
	       			<option value="검색">검색</option>
				</select>
			</td>
		</tr>
		
		
	
		
		<tr>
			<td>
				<button type="button"  style="width:90px; float:right;" >수정하기</button>
			</td>
		</tr>
	</table>
</body>
</html>