$(document).ready(function(){
	//alert('111');
	GoPage('list');
});

var path = $("span_path").text();

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
	var param;	
	var url = "${path}/member_servlet/" + value1 + ".do";
	
	if(value1 == "list") {	
		
		param = {
			"pageNumber" : $("#span_pageNumber").text(),
			"search_option" : $("#span_search_option").text(),
			"search_data" : $("#span_search_data").text(),
		}
	}else if(value1 == "sujung" || value1 == "sakje") {
		param = {
			"no" : $("#span_no").text()
		}
	}else if(value1 == "chuga") {
		param = {};
	}else if(value1 == "chugaProc" || value1 == "sujungProc" || value1 == "sakjeProc") {
		param = {
			"no" : $("#span_no").text(),
			"id" : $("#id").val(),
			"passwd" : $("#passwd").val(),
			"passwdChk" : $("#passwdChk").val(),
			"name" : $("#name").val(),
			"gender" : $("#gender").val(),
			"bornYear" : $("#bornYear").val(),
			"postcode" : $("#sample6_postcode").val(),
			"address" : $("#sample6_address").val(),
			"detailAddress" : $("#sample6_detailAddress").val(),
			"extraAddress" : $("#sample6_extraAddress").val()
			
		}
	}else if(value1 == "view" ) {
		param = {
			"no" : $("#span_no").text(),
			"pageNumber" : $("#span_pageNumber").text(),
			"search_option" : $("#span_search_option").text(),
			"search_data" : $("#span_search_data").text()
		}
	}else if(value1 == "login") {
		param = {
			
		}
	}else if(value1 == "loginProc") {
		param= {
			"loginId" : $("#loginId").val(),
			"loginPasswd" : $("#loginPasswd").val()
		}
	}else if(value1 == "logout") {
		param = {
			
		}
	}
	
	$.ajax({
		type : "post",
		data : param,
		url : url,
		success : function(data) {
			if(value1 == "list") {
				$("#result").html(data);
			}else if(value1 == "view") {
				$("#result").html(data);
			}else if(value1 == "chugaProc") {
				alert('가입성공');
				GoPage('list');
			}else if(value1 == "chuga") {
				$("#result").html(data);
			}else if(value1 == "sujung") {
				$("#result").html(data);
			}else if(value1 == "sujungProc") {
				suntaek_proc('view', '0' , $("#span_no").text());
			}else if(value1 == "sakje") {
				suntaek_proc('logout', '' , '');
			}else if(value1 == "login") {
				$("#result").html(data);
			}else if(value1 == "loginProc") {
				alert('로그인 성공');
				location.href="./index.do";
			}else if(value1 == "logout") {
				alert('로그아웃되었습니다.'); 
				location.href='./index.do';	
			}
			
			$("#result").html(data);
		}
	});
	
}

 function search() {
			 if(confirm('검색하시겠습니까')) {
				 $("#span_search_option").text( $("#search_option").val());
			 	 $("#span_search_data").text( $("#search_data").val());	
			 	 GoPage('list');
			 }
}






function suntaek_all() {
	$("#span_search_optioon").text("");
	$("#span_search_data").text("");
	suntaek_proc('list', '', '');
}



function checkGender(value1) {
	$("#gender").val(value1);
}



