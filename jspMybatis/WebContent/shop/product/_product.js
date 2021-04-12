$(document).ready(function(){
	suntaek_proc('list','1', '');
});


function suntaek_page(value1){
   $("#span_pageNumber").text(value1);
   $("#span_no").text("");
   GoPage('list');
}



function suntaek_proc(value1, value2, value3) {
	if(value1 == "chuga") {
		$("#span_no").text("");
	}else if(value1 == "chugaProc") {
		$("#span_no").text("");
	}
	
	if(value1 != '') {
		$("#span_proc").text(value1);
	}
	
	if(value2 != '') {
		$("#span_pageNumber").text(value2);
	}
	
	if(value3 != '') {
		$("#span_no").text(value3);
	}
	
	GoPage(value1);
}

function GoPage(value1) {
	var param = {};
	var method_type = "post";
	var process_data;		
	var content_type;	//파일 첨부시 필요하다
	
	var url = "${path}/product_servlet/" + value1 + ".do";
	if(value1 == "chuga") {	
		param = {}
	}else if(value1 == "chugaProc"||value1 == "sujungProc") {
		
		process_data = false;
		content_type = false;	//파일 첨부시 반드시 들어가야한다.
		
		param = new FormData();
		
		if(value1 == "sujungProc") {
			param.append("no", $("#span_no").text());
		}else {
			param.append("no", 0);
		}
		
		param.append("name", $("#name").val());
		param.append("price", $("#price").val());
		param.append("description", $("#description").val());
		
		/*
		console.log($('input[name="file"]')[0].files[0]);
		console.log($('input[name="file"]')[1].files[0]);
		console.log($('input[name="file"]')[2].files[0]);
		
		return;
		*/
		
		var file_counter = parseInt($('input[name="file"]').length);
		for(i=0; i<file_counter; i++) {
			param.append(i, $('input[name="file"]')[i].files[0]);
		}
		
	}else if(value1 == "view") {
		param.no = $("#span_no").text();
	}else if(value1 == "sujung") {
		param.no = $("#span_no").text();
	}else if(value1 == "list") {
		param.pageNumber = $("#span_pageNumber").text();
	}else if(value1 == "sakje") {
		param.no = $("#span_no").text();
	}
	
	$.ajax({
		type : method_type,
		data : param,
		processData : process_data,
		contentType : content_type,
		url : url,
		success : function(data) {
			
			if(value1 == "chugaProc"||value1 == "sujungProc") {
				suntaek_page('1');
			}else if(value1 == "sakje"){				
				$("#result").html(data);
			}else {
				$("#result").html(data);
			}	
		}
	});
	
}