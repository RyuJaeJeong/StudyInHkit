<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>

<script>
	location.href = '${path}/member_servlet/list.do';  //http://localhost8090/jspStudy/index.jsp
	//포워딩은 실제경로를 숨기고 index.do로 표기한다. 컨트롤러가 받아서 page에 담긴 주소로 보내버린다
</script>