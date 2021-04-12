<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		span{
			display: none;
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
<span id="span_arg01">${arg01}</span>  
<div id="result" style="height: inherit; "></div>



<script src='<c:url value="/resources/js/_member.js"/>'>
</script>

</body>
</html>