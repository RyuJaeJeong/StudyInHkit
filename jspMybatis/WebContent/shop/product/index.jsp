<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/inc_header.jsp" %>


<span id="span_proc" style="display:none;"></span>
<span id="span_pageNumber" style="display:none;">${span_pageNumber}</span><br>
<span id="span_pageSize" style="display:none;">${span_pageSize}</span><br>
<span id="span_no" style="display:none;">${no}</span><br>
<span id="span_search_option" style="display:none;">${search_option}</span><br>
<span id="span_search_data" style="display:none;">${search_data}</span><br>

<div id="result" style="border: 1px solid red; height: inherit; "></div>

<script type="text/javascript" src="${path}/shop/product/_product.js">
</script>