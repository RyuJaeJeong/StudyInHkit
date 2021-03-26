$(document).ready(function(){
	suntaek_proc('list', '', '');
});

function suntaek_proc(value1, value2, value3) {
	$("#span_proc").text(value1);
	
	if(value2 != '0') {
		$("#span_pageNumber").text(value2);
	}
	
	if(value3 != '0') {
		$("#span_no").text(value3);
	}
	
	GoPage(value1);
}

function GoPage(value1) {
	
	var param = {};	
	var url = "${path}/survey2_servlet/" + value1 + ".do";
	
	if(value1 == "list") {
		param = {
				"list_gubun" : $("#span_list_gubun").text(),	
    			"pageNumber" : $("#span_pageNumber").text(),	
    			"search_option" : $("#span_search_option").text(),	
    			"search_data" : $("#span_search_data").text(),	
    			"search_data_s" : $("#span_search_data_s").text(),
    			"search_data_e" : $("#span_search_data_e").text(),
    			"search_date_check" : $("#span_search_date_check").text()	//마지막꺼는 컴마가 없다. 
		}
	}else if(value1 == "josa") {
		param = {
			"no" : $("#span_no").text(),
			"pageNumber" : $("#span_pageNumber").text(),
			"search_option" : $("#span_search_option").text(),
			"search_data" : $("#span_search_data").text()
		}
	}else if(value1 == "josaProc") {
		param = {
			"no" : $("#span_no").text(),
			"answer" : $('input[name="answer"]:checked').val()
		}
	}else if(value1 == "josaAll") {
		param = {
			
		}
	}else if(value1 == "josaAllProc") {
		param = {
			"answer_total" : $("#span_answer_total").text()
		}
	}
	
 	$.ajax({
		type : "post",
		data : param,
		url : url,
		success : function(data) {
			if(value1 == "list") {
				$("#result").html(data);
				if($("#span_search_date_check").text() == "O"){
    					$("input[id=search_date_check]:checkbox").prop("checked", true);
    			}else {
    					$("input[id=search_date_check]:checkbox").prop("checked", false);
    			} 
			}else if(value1 == "josa") {
				$("#result").html(data);
			}else if(value1 == "josaProc") {
				suntaek_proc('list', '', '');
				alert('제출되었습니다.');
			}else if(value1 == "josaAll") {
				$("#result").html(data);
			}else if(value1 == "josaAllProc") {
				suntaek_proc('list', '', '');
				alert('제출되었습니다.');
			}
		}
	});
}
 
function suntaek_list(value1) {
	$("#span_search_option").text("");
	$("#span_search_data").text("");
	$("#span_search_data_s").text("");
	$("#span_search_data_e").text("");
    $("#span_list_gubun").text(value1);
    $("#span_pageNumber").text(1);
	

    suntaek_proc('list', '0', '');
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
    		
    		alert($("#search_date_check").val());
    		 suntaek_proc('list', '1', '');
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

	
