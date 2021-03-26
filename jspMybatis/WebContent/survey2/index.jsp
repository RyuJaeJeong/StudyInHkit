<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
    
    <input type="text" name="a" style="display: ;"><br>
    span_proc : <span style="display:;" id="span_proc">${span_proc}</span>	<br>
    span_pageNumber :  	<span style="display:;" id="span_pageNumber">${pageNumber}</span>	<br>
    span_list_gubun :  	<span style="display:;" id="span_list_gubun">${list_gubun}</span>	<br>
    span_no : 		 	<span style="display:;" id="span_no">${no}</span>					<br>
    span_search_option :  <span style="display:;" id="span_search_option">${search_option}</span>	<br>
    span_search_data :  	<span style="display:;" id="span_search_data">${search_data}</span> 	<br>
    span_search_data_s :  <span style="display:;" id="span_search_data_s">${search_data_s}</span>	<br>
    span_search_data_e :  <span style="display:;" id="span_search_data_e">${search_data_e}</span>	<br>
    span_search_date_check :  <span style="display:;" id="span_search_date_check">${search_date_check}</span>	<br> 
    
    
    <div id="result" style="border: 1px solid black;"></div>
    
    	
    <script type="text/javascript" src="${path}/survey2/_survey2.js">
	</script>

   