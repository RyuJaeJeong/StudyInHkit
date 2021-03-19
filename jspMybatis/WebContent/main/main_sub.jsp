<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="../include/inc_header.jsp" %>
    
    <c:if test="${sessionScope.cookNo == null || sessionScope.cookNo == 0}">
   	 <img src="${path}/attach/image.jpg" title="풍경1" alt="풍경2">
    </c:if>
    <c:if test="${sessionScope.cookNo != null&&sessionScope.cookNo != 0}">
   	 ${sessionScope.cookName} 님 환영합니다.
    </c:if>