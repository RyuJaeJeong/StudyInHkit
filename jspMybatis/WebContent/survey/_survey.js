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
	var url = "${path}/survey_servlet/" + value1 + ".do";
	
	if(value1 == "chuga") {
		
	}else if(value1 == "chugaProc"||value1 == "sujungProc") {
		param = {
			"no" : $("#span_no").text(),
			"question" : $("#question").val(),
			"ans1" : $("#ans1").val(),
			"ans2" : $("#ans2").val(),
			"ans3" : $("#ans3").val(),
			"ans4" : $("#ans4").val(),
			"status" : $("#status").val(),
			"sYear" : $("#sYear option:selected").val(),
			"sMonth" : $("#sMonth option:selected").val(),
			"sDay" : $("#sDay option:selected").val(),
			"lYear" : $("#lYear option:selected").val(),
			"lMonth" : $("#lMonth option:selected").val(),
			"lDay" : $("#lDay option:selected").val()
		}
		
		
	}else if(value1 == "list") {
		param = {
				"list_gubun" : $("#span_list_gubun").text(),	
    			"pageNumber" : $("#span_pageNumber").text(),	
    			"search_option" : $("#span_search_option").text(),	
    			"search_data" : $("#span_search_data").text(),	
    			"search_data_s" : $("#span_search_data_s").text(),
    			"search_data_e" : $("#span_search_data_e").text(),
    			"search_date_check" : $("#span_search_date_check").text()	//마지막꺼는 컴마가 없다. 
		}
	}else if(value1 == "view") {
		param = {
			"no" : $("#span_no").text(),
			"pageNumber" : $("#span_pageNumber").text(),
			"search_option" : $("#span_search_option").text(),
			"search_data" : $("#span_search_data").text()
		}
	}else if(value1 == "sujung"||value1 == "sakjeProc") {
		param = {
			"no" : $("#span_no").text()
		}
	}
	
 	$.ajax({
		type : "post",
		data : param,
		url : url,
		success : function(data) {
			if(value1 == "chuga"||value1 == "sujung") {
				$("#result").html(data);
			}else if(value1 == "chugaProc") {
				suntaek_proc('list', '', '');
				alert('가입성공');
			}else if(value1 == "list") {
				$("#result").html(data);
				if($("#span_search_date_check").text() == "O"){
    					$("input[id=search_date_check]:checkbox").prop("checked", true);
    			}else {
    					$("input[id=search_date_check]:checkbox").prop("checked", false);
    			} 
			}else if(value1 == "view") {
				$("#result").html(data);
			}else if(value1 == "sujungProc") {
				suntaek_proc('list', '', '');
				alert('수정성공');
			}else if(value1 == "sakjeProc") {
				suntaek_proc('list', '', '');
				alert('삭제성공');
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

	
