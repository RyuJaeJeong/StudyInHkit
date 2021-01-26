<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../include/inc_header.jsp" %>
    
    <input type="text" name="a" style="display: ;"><br>
    <span style="display:none;" id="span_pageNumber">${pageNumber}</span>
    <span style="display:none;" id="span_list_gubun">${list_gubun}</span>
    <span style="display:none;" id="span_no">${no}</span>
    <span style="display:none;" id="span_search_option">${search_option}</span>
    <span style="display:none;" id="span_search_data">${search_data}</span>
    search_date_check : <span  id="span_search_date_check">${search_date_check}</span>   
    <span style="display:none;" id="span_search_data_s">${search_data_s}</span>
    <span style="display:none;" id="span_search_data_e">${search_data_e}</span>
    
    <c:if test="${menu_gubun == 'survey_index'}">
    
    <div id="result" style="border: 1px solid black;"></div>
    
    	<script>
    		$(document).ready(function(){
    			
    			GoList();
    			//GoChuga();
    		});
    	</script>
    

    </c:if>
    
    <script>
    	function GoChuga() {
    		var param = {}
    		$.ajax ({
    			type: "post",
    			data: param,
 				url: "${path}/survey_servlet/chuga.do",
 				success: function(data) {
 					$("#result").html(data);
 				}
    		});
    	}
    	
    	function GoChugaProc() {
    		if(confirm('등록하시겠습니까?')) {
    			$.ajax({
    				type: "post",
    				data: $('form').serialize(),
    				url: "${path}/survey_servlet/chugaProc.do",
    				success: function() {
    					suntaek_page('1');
    					GoList();
    				}
    			
    			});
    		}
    	}
    	
    	function GoList() {
    		
    		var param = {
    			"list_gubun" : $("#span_list_gubun").text(),	
    			"pageNumber" : $("#span_pageNumber").text(),	
    			"search_option" : $("#span_search_option").text(),	
    			"search_data" : $("#span_search_data").text(),	
    			"search_data_s" : $("#span_search_data_s").text(),
    			"search_data_e" : $("#span_search_data_e").text(),
    			"search_date_check" : $("#span_search_date_check").text()	//마지막꺼는 컴마가 없다. 
    		}
    		$.ajax({
    			type: "post",
    			data: param,
    			url:"${path}/survey_servlet/list.do",
    				
    			success:function(result) {
    				$("#result").html(result);
    				 if($("#span_search_date_check").text() == "O"){
    					$("input[id=search_date_check]:checkbox").prop("checked", true);
    				}else {
    					$("input[id=search_date_check]:checkbox").prop("checked", false);
    				} 
    			}
    		});
    	}
    	
    	function suntaek_page(value1) {
    		$("#span_pageNumber").text(value1);
    		GoList();
    	}
    	
    	function suntaek_list(value1) {
    		$("#span_list_gubun").text(value1);
    		$("#span_pageNumber").text(1);
    		GoList();
    	}
    	
    	function search() {
    		$("#span_search_option").text($("#search_option").val());
    		$("#span_search_data").text($("#search_data").val());
    		$("#span_search_data_s").text($("#search_data_s").val());
    		$("#span_search_data_e").text($("#search_data_e").val());
    		if($("input:checkbox[id='search_date_check']").is(":checked")==true) {
    			$("#span_search_date_check").text($("#search_date_check").val());
    		}else {
    			$("#span_search_date_check").text("");
    		}
    		
    		suntaek_page('1');
    		GoList();
    	}
    	
    	
    </script>