<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
    
    <input type="text" name="a" style="display: ;"><br>
    <span style="display:none;" id="span_pageNumber">${pageNumber}</span>
    <span style="display:none;" id="span_list_gubun">${list_gubun}</span>
    <span style="display:none;" id="span_no">${no}</span>
    <span style="display:none;" id="span_search_option">${search_option}</span>
    <span style="display:none;" id="span_search_data">${search_data}</span>
      
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
    	
    	function suntaek_josa(value1) {
    		var param = {
    				no : value1
    		}
    		
    		$.ajax({
    			type: "post",
    			data: param,
    			url:"${path}/survey_servlet/josa.do",
    			success: function(result) {
    				$("#result").html(result);
    			}
    		});
    		
    	}
    	
    	function GoJosaProc() {
    		if(confirm('등록하시겠습니까?')) {
    			alert('조사가 완료되었습니다. 감사합니다');
    			$.ajax({
    				type: "post",
    				data: $('form').serialize(),
    				url: "${path}/survey_servlet/JosaProc.do",
    				success: function() {
    					
    					suntaek_page('1');
    					GoList();
    				}
    			
    			});
    		}
    	}
    	
    	function suntaek_view(value1) {
    		var param = {
    				no : value1
    		}
    		
    		$.ajax({
    			type: "post",
    			data: param,
    			url:"${path}/survey_servlet/view.do",
    			success: function(result) {
    				$("#result").html(result);
    			}
    		});
    	}
    	
    	function GoList_2() {
    		var param = {}
    		$.ajax ({
    			type:"post",
    			data:param,
    			url:"${path}/survey_servlet/list_2.do",
 				success: function(data) {
 					$("#result").html(data);
 				}   		
    		});
    	}
    	
    	function goSaveProc() {
    		if(confirm('제출하시겠습니까?')) {
    			var param = {
    					"answer_total" : $("#span_answer_total").text()
    			}
    			$.ajax ({
        			type:"post",
        			data:param,
        			url:"${path}/survey_servlet/saveProc.do",
     				success: function(data) {
     					suntaek_page('1');
     				}   		
        		});
    			
    		}
    	}
    	
    	function check_answer(value1, value2) {
    		$("#span_answer_"+value2).text(value1);
    		$("#span_no_"+value2).text();
    		var counter = parseInt($("#span_list_size").text());
        	var msg = "";
        	for(i=0; i<counter; i++) {
        		q_no = $("#span_no_"+i).text();
        		answer = $("#span_answer_" + i).text();
        		
        		if(answer.length>0) {
        			if(msg == '') {
        				msg = q_no + ":" + answer;
        				
        			}else {
        				msg = msg + "|" + q_no + ":" + answer;
        			}
        		}
        	}
        	$("#span_answer_total").text(msg);
    	}
    	
    	
    	
    </script>