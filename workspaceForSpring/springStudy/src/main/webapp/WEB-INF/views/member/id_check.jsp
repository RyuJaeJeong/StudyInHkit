<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../include/inc_header.jsp" %>
 
 <form name='founderFrm'>
	 <h3 align="center"> 아이디찾기 </h3>
	 <table align="center" border="1">
	 	<tr>
	 		<td>아이디</td>
	 		<td><input type="text" name="id" id="id" value="${id}"></td>
	 	</tr>
	 
	 	<tr>
	 		<td colspan="2" align="center" style="height:50px;">
	 			<button type="button" id="btnSearch">검색</button>
	 			<button type="button" onclick="save();">적용</button>
	 		</td>
	 		
	 	</tr>
	 	
	 </table>
	 <input type="text" name="use_id" id="use_id" value="${id}" style="display:none;">
 </form>
 
 <script>
	 $("#btnSearch").click(function(){
		 id_check_win_proc();
	});
	 
	 function id_check_win_proc(){  
			var id = $("#id").val();
			var param = "id=" + id; //입력한 값을 쿼리스트링으로 만들어서 전달
		
			$.ajax({
				type: "post",
				data: param,
				url: "${path}/member/id_check.do",
				success: function(result){
					if(result > 0) {
						alert('이미 사용중인 아이디입니다.');
						$("#id").val("");
					}else{
						alert('사용가능한 아이디 입니다.');
						$("#use_id").val($("#id").val());
					}
				}
			});
		} 
	 
	 function save() {
		 if(confirm('적용할까요?')) {
			 if(${result>0}) {
				alert('중복된 아이디입니다.')
				$("#id").val("");
				$("#id").focus();
				return;
			 }
			 var id = document.getElementById("use_id").value;
			 //alert(id);
			 opener.document.getElementById("id").value = id;
			 window.close();
		 }
	 }
 </script>