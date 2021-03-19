<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

span {
	display:none;
}
</style>

</head>
<body>
<span id="span_proc"></span> 
<span id="span_pageNumber">${span_pageNumber}</span>
<span id="span_pageSize">${span_pageSize}</span>
<span id="span_no">${no}</span>
<span id="span_search_option">${search_option}</span>
<span id="span_search_data">${search_data}</span>
<span id="span_path">${path}</span>
<input type="text" style="display:none;">
<c:choose>
	<c:when test="${cookNo != 0 }">
		<a herf="#" onclick="suntaek_proc('logout', '', '')">[로그아웃]</a>
	</c:when>
	<c:otherwise>
		<a herf="#" onclick="suntaek_proc('login', '', '')">[로그인]</a>
	</c:otherwise>
</c:choose>

<div id="result" style="border: 1px solid red; height: inherit; "></div>

<script type="text/javascript" src="${path}/member/_member.js">
</script>

</body>
</html>