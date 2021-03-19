$(document).ready(function(){
	//alert('111');
	suntaek_proc('chuga','','');
	suntaek_proc('list','','');
});





function suntaek_proc(value1, value2, value3) {
	$("#span_proc").text(value1);
	
	if(value2 != '0') {
		$("#span_pageNumber").text(value2);
	}
	
	if(value3 != '0') {
		$("#span_no").text(value3);
	}
	//alert(value3);
	GoPage(value1);
	
}

function suntaek_page(value1) {
		//alert(value1);
 		$("#span_pageNumber").text(value1);
 		suntaek_proc('list','0','');	//suntaek_proc('list','','') 이렇게쓰면 윗줄에서 페이지넘버 찍은게 날아간다.
}


	

function GoPage(value1) {
	var param;
	var chk_no = '';
	var url = "${path}/memo_servlet/" + value1 + ".do";
	
	if(value1 == "list") {
		param = {
			"pageNumber" : $("#span_pageNumber").text()
		}
	}else if(value1 == "chuga") {
		param = {}
	}else if(value1 == "chugaProc") {
		param = {
			name : $("#name").val(),
			content : $("#content").val()
		}
	}else if(value1 == "delete") {
		$('input[type="checkbox"]:checked').each(function(index){
			if(index != 0) {
				chk_no += ',';
			}
			
			chk_no += $(this).val();
			
		});
		
		param = {};
		param.chk_no = chk_no;
		
	}else if(value1 == "sujung") {
		$('input[type="checkbox"]:checked').each(function(index){
			chk_no = $(this).val();
		});
		
		param = {};
		param.id = chk_no;
		
	}else if(value1 == "sujungProc") {
		param = {
			name : $("#name").val(),
			content : $("#content").val(),
			id : $("#span_no").text()
		}
	}
	
	$.ajax({
		type : "post",
		data : param,
		url : url,
		success : function(data) {
			if(value1 == "list") {
				$("#list").html(data);
			}else if(value1 == "chuga") {
				$("#chuga").html(data);
			}else if(value1 == "chugaProc") {
				$("#name").val("");
				$("#content").val("");
				suntaek_proc('list','','');
			}else if(value1 == "delete") {
				suntaek_proc('list','','');
			}else if(value1 == "sujung") {
				$("#chuga").html(data);
			}else if(value1 == "sujungProc") {
				$("#name").val("");
				$("#content").val("");
				suntaek_proc('list','','');
			}
		}
	});
	
	
	
	
}