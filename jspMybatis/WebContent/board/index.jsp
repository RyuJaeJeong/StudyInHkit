<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %> 
naljaMap : ${naljaMap}<br>
ip : ${ip} <br>
tbl : <span id = "span_tbl">
	${tbl}
</span><br>
pageNumber : <span id = "span_pageNumber">${pageNumber}</span><br>
no : <span id ="span_no">${no}</span><br>
search_option : <span id="span_search_option">${search_option}</span><br>
search_data : <span id="span_search_data">${search_data}</span><br>

<input type="text" name="a" > <br>


<div id="result" style="border: 1px solid black; height: inherit;"></div>

<script type="text/javascript" src="${path}/board/_board.js">
</script>    
    