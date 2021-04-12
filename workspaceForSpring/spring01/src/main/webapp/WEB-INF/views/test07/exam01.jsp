<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../include/inc_menu.jsp" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test07Proc.do" method="post">
		이름 : <input type="text" name="p_name" id="p_name" value=""> <br>
		가격 : <input type="text" name="p_price" id="p_price" value=""> <br>
		상품분류 : <input type="text" name="p_class" id="p_class" value=""> <br>
		할인율 : <input type="text" name="p_sale" id="p_sale" value=""> <br>
		가격 : <input type="text" name="p_sale_price" id="p_sale_price" value=""> <br>
		<input type="submit" value="확인">
	</form>
</body>
</html>