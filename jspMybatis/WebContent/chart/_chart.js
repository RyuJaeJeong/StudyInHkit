$(document).ready(function(){
	$("#btnCreateJson").click(function(){
		GoPage('createJson');
	});
});

function GoPage(value1) {
    var method_type = "post";
    var param = {}
    var url = "${path}/chart_servlet/" + value1 + ".do";
    $.ajax({
       type: method_type,
       data: param,
       url: url,
       success: function(data){
          $("#result").html(data);
       }
    });
 }