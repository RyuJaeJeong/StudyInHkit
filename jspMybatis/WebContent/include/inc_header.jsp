<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	response.setHeader("Cache-Control", "no-store");
 	response.setHeader("Pragma", "no-cache");
 	response.setHeader("Expires", "0");
 %>   
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="url" value="${pageContext.request.requestURL}"/>
<c:set var="uri" value="${pageContext.request.requestURI}"/>

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<%--
EL : ${변수명 또는 수식}
JSTL(JSP Standard Library)



html 캐쉬 삭제 

<head>
 <meta http-equiv="Cache-Control" content="no-cache"/>
 <meta http-equiv="Expires" content="0"/>
 <meta http-equiv="Pragma" content="no-cache"/>

</head>

 --%>
 
