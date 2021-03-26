$(document).ready(function(){	
		GoPage('list','');		
});

function GoPage(value1, value2) {
	var url = "${path}/board_servlet/"+value1+".do";
	
	if(value1 == "chuga") {
		$("#span_no").text("");
		var param={}
	}else if(value1 == "chugaProc" || value1 == "sujungProc" || value1 == "sakjeProc") {
		var param={
			"no" : $("#span_no").text(),
			"tbl" : $("#span_tbl").text(),
			"writer" : $("#writer").val(),
			"email" : $("#email").val(),
			"passwd" : $("#passwd").val(),
			"subject" : $("#subject").val(),
			"content" : $("#content").val(),
			"noticeGubun" : $("#noticeGubun").val(),
			"secretGubun" : $("#secretGubun").val()
			
			//폼안에 있는 것은 .val 
			//span div 안에있는것은.text
			
	    }
		
	}else if (value1 == "list") {
			var param = {
					"tbl" : $("#span_tbl").text(),
					"pageNumber" : $("#span_pageNumber").text(),
					"search_option" : $("#span_search_option").text(),
					"search_data" : $("#span_search_data").text()
			}
	}else if (value1 =="view") {
		$("#span_no").text(value2);
		var param = {
				"no" : $("#span_no").text(),
				"tbl" : $("#span_tbl").text(),
				"pageNumber" : $("#span_pageNumber").text(),
				"search_option" : $("#span_search_option").text(),
				"search_data" : $("#span_search_data").text(),
				"view_passwd" : $("#view_passwd").val()
		}
	}else if(value1 =="reply" ||value1 == "sujung"|| value1=="sakje") {
		var param = {
				"no" : $("#span_no").text()	
		}
		
	}
	
	$.ajax({
		type: "post",
		data: param,
		url: url,
		success: function(result) {
			if(value1 == "chugaProc") {
				suntaek_page('1');
			} else if(value1 == "List") {
				$("#result").html(result);
			} else if (value1 == "sujungProc") {
				GoPage('view', $("#span_no").text())
			} else if(value1 == "sakjeProc") {
				$("#result").html(result);
			}else {
				$("#result").html(result);
			}
			
		}
	});
}

function suntaek_page(value1) {
	$("#span_pageNumber").text(value1);
	$("#span_no").text("0");
	GoPage('list','');
}



function clickChk(value1) {
if(value1 == 'noticeGubun') {
	if($("input:checkbox[name=noticeGubunCheckBox]").is(":checked") == true) {
		$("#noticeGubun").val("T");
	}else {
		$("#noticeGubun").val("");
	}
}else {
	if($("input:checkbox[name=secretGubunCheckBox]").is(":checked") == true) {
		$("#secretGubun").val("T");
	}else {
		$("#secretGubun").val("");
	}
	
}	
}