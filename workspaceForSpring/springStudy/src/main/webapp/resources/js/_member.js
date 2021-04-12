	var path = $("#span_path").text();

/*
	window.onload = function(){
		//alert('aaa1');
		sijak();
	}
*/

	$(document).ready(function(){
		if ($("#span_arg01").text() == "login") {
			suntaek_proc('login', '', '');
		} else {
			suntaek_proc('list', '1', '');
		}
		//sijak();
		//alert('start');
	});

	function sijak() {
		suntaek_proc('list', '1', '');
	}
	
	function suntaek_all() {
 		$("#span_search_option").text("");
 		$("#span_search_data").text("");
 		suntaek_proc('list', '1', '');
 	}
	
	// 0-건너뜀, ''-공백
	function suntaek_proc(value1, value2, value3) {
		//alert('bbb');
		$("#span_proc").text(value1);

		if (value2 != "0") {
			$("#span_pageNumber").text(value2);
		}

		if (value3 != "0") {
			$("#span_no").text(value3);
		}

 		GoPage(value1);	
 	}
	
	function GoPage(value1) {
		var param;
		//var url = "${path}/member_servlet/" + value1 + ".do";
		//var url = path + "/member_servlet/" + value1 + ".do";
		var url = path + "/member/" + value1 + ".do";

		if (value1 == "list") {
			param = {
				"pageNumber" : $("#span_pageNumber").text(),
				"search_option" : $("#span_search_option").text(),
				"search_data" : $("#span_search_data").text()
			}
		} else if (value1 == "chuga") {
			param = {}
			
		} else if (value1 == "sujung" || value1 == "sakje") {
			param = {
				"no" : $("#span_no").text(),
				"search_option" : $("#span_search_option").text(),
				"search_data" : $("#span_search_data").text()
			}
			
		} else if (value1 == "chugaProc" || value1 == "sujungProc" || value1 == "sakjeProc") {
			param = {
				
				"no" : $("#span_no").text(),
				"id" : $("#id").val(),
				"passwd" : $("#passwd").val(),
				"passwdChk" : $("#passwdChk").val(),
				"name" : $("#name").val(),
				"gender" : $("#gender").val(),
				"bornYear" : $("#bornYear").val(),
				"postcode" : $("#postcode").val(),
				"address" : $("#address").val(),
				"detailAddress" : $("#detailAddress").val(),
				"extraAddress" : $("#extraAddress").val()
			}

		} else if (value1 == "view") {
			param = {
				"pageNumber" : $("#span_pageNumber").text(),
				"no" : $("#span_no").text(),
				"search_option" : $("#span_search_option").text(),
				"search_data" : $("#span_search_data").text()
		    } 
		    
		} else if (value1 == "login") {
			param = {}
		} else if (value1 == "loginProc") {
			param = {
				"id" : $("#id").val(),
				"passwd" : $("#passwd").val()
		    } 
		    
		}

		$.ajax({
			type: "post",
			data: param,
			//data: $('form').serialize(),
			url: url,	
			cache : false,
			success: function(data){ //콜백함수(서버에서 처리가 완료된 후 실행되는 코드)
				if (value1 == "list") {
					$("#result").html(data);
				} else if (value1 == "view") {
					$("#result").html(data);
				} else if (value1 == "chuga") {
					$("#result").html(data);	
				} else if (value1 == "chugaProc") {
					suntaek_proc('list', '1', '');
				} else if (value1 == "reply") {
					$("#result").html(data);
				} else if (value1 == "sujung") {
					$("#result").html(data);
				} else if (value1 == "sujungProc") {
					suntaek_proc('view', '0', $("#span_no").text());
				} else if (value1 == "sakje") {
					$("#result").html(data);
				} else if (value1 == "sakjeProc") {
					
					suntaek_proc('list', '1', '');
				
				} else if (value1 == "login") {
					$("#result").html(data);	
				} else if (value1 == "loginProc") {
					if (data > 0) { //로그인 성공
						location.href = '/springStudy';
					} else {
						alert('아이디 또는 비밀번호가 다릅니다.');
						alert(data);
						$("#id").val("");
						$("#passwd").val("");
					}

				} else {
					$("#result").html(data);
				}
			}			
		});
	}
	
	function checkGender(value1) {
		$("#gender").val(value1);
	}
	
	function id_check_win(){  
	    window.open("id_check_win.do", "네이버새창", "width=640, height=480, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	} 
	
	
	function id_check_div(){  
		var id = $("#id").val();
		if (id == '') {
			 $("#label_id").html('아이디를 입력하세요.');
			 $("#label_id").css('color', 'green');
			 $("#label_id").css('font-size', '8px');
			 return;
		}

		var param = "id=" + id; //입력한 값을 쿼리스트링으로 만들어서 전달
	
		$.ajax({
			type: "post",
			data: param,
			url: "${path}/member/id_check.do",
			success: function(result){
				if (result > 0) {
					$("#id").val('');
					$("#label_id").html("사용할 수 없는 아이디입니다.");
					$("#label_id").css('color', 'red');
		    		$("#label_id").css('font-size', '8px');
				} else {
					$("#label_id").html("사용할 수 있는 아이디입니다.");
					$("#label_id").css('color', 'blue');
		    		$("#label_id").css('font-size', '8px');
				}
			}
		});
	} 
	
	
     