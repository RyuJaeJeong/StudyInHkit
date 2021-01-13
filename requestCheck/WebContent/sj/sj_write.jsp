<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적등록</title>
</head>
<body>
	<form name = "testForm">
	<h2 align="center">성적등록</h2>
		<table border="1" align="center">
		<tr>
			<td>이름</td>
			<td><input type="text" name="nme" value=""></td>
		</tr>
		<tr>
			<td>시험구분</td>
			<td>
					<input type="radio" name="sNme" value="중간고사"> 중간고사
					<input type="radio" name="sNme" value="기말고사"> 기말고사	
					<input type="radio" name="sNme" value="모의고사"> 모의고사									<!-- checked 선택되어 나온다. -->				<!-- selected 선택되어나온다 -->
			</td>
		</tr>
	 	<tr>
				<td>1.동물이 아닌 것은?</td>
				<td>
					<input type="radio" name="mun_1" value="1"> 신발
					<input type="radio" name="mun_1" value="2"> 여우
					<input type="radio" name="mun_1" value="3"> 늑대
					<input type="radio" name="mun_1" value="4"> 까치
				</td>
		</tr>
		<tr>
				<td>2.먹을 수 없는 것은?</td>
				<td>
					<input type="radio" name="mun_2" value="1"> 우유
					<input type="radio" name="mun_2" value="2"> 오일
					<input type="radio" name="mun_2" value="3"> 식빵
					<input type="radio" name="mun_2" value="4"> 콜라
				</td>
		</tr>
		<tr>
				<td>3. 용도가 다른 것은?</td>
				<td>
					<input type="radio" name="mun_3" value="1"> 구두
					<input type="radio" name="mun_3" value="2"> 샌들
					<input type="radio" name="mun_3" value="3"> 우의
					<input type="radio" name="mun_3" value="4"> 짚신
				</td>
		</tr>
		<tr>
				<td>4. student의 의미는?</td>
				<td>
					<input type="radio" name="mun_4" value="1"> 의사
					<input type="radio" name="mun_4" value="2"> 군인
					<input type="radio" name="mun_4" value="3"> 선생
					<input type="radio" name="mun_4" value="4"> 학생
				</td>
		</tr>
		<tr>
				<td>5. 한글을 창제한 왕은?</td>
				<td>
					<input type="radio" name="mun_5" value="1"> 성종
					<input type="radio" name="mun_5" value="2"> 문종
					<input type="radio" name="mun_5" value="3"> 세종
					<input type="radio" name="mun_5" value="4"> 세조
				</td>
		</tr>
		<tr>
		<td colspan="2" align="center"><button type="button" onclick="subm();">제출하기</button></td>
		</tr>
	</table>
	</form>
</body>
</html>

<script>
function subm() {
	if(confirm("제출하시겠습니까?")) {
	testForm.method="post";
	testForm.action="sj_writeProc.jsp";
	testForm.submit();
	}
}

</script>
