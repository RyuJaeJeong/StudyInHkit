<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../include/inc_header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="result" style="border: 1px solid black; height: inherit;"></div>

<!-- 구글 차트 라이브러리 로딩  -->
<script src="https://www.google.com/jsapi"></script>

<button type="button" id="btnCreateJson">매출보기</button>

<script type="text/javascript" src="${path}/chart/_chart.js">
</script>    

</body>
</html>