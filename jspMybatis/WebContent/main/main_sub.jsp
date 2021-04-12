<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="../include/inc_header.jsp" %>
    
    <c:if test="${sessionScope.cookNo == null || sessionScope.cookNo == 0}">
    <div style="font-size: 20px;">
   	
   	 	저는 
   	 	<br>
   	 	<br>
   	 	회원관리 -  <Strong> 회원가입(아이디 중복체크, 카카오api 활용한 주소검색), 회원정보 조회, 회원정보 수정, 회원정보 삭제, 로그인, 로그아웃 <br> </Strong>
   	 	메모장 -  <Strong>메모입력, 메모 조회, 메모 수정, 메모삭제 <br> </Strong>
   	 	설문관리 -  <Strong>설문 등록, 설문 조회(설문 검색, 날짜 검색), 설문 수정, 설문 삭제 <br> </Strong>
   	 	설문조사 -  <Strong>설문 조사, 문제 은행 <br> </Strong>
   	 	계충형 게시판 -  <Strong>게시물 등록, 게시물 조회, 게시물 수정, 게시물 삭제, 답글 등록 <br> </Strong>
   	 	상품관리 -  <Strong>상품 등록(파일 첨부), 상품 조회, 상품 수정, 상품 삭제 <br> </Strong>
   	 	쇼핑몰	-  <Strong>장바구니 기능 <br> </Strong>
   	 	매출분석  -  <Strong>구글 차트 활용 <br> </Strong>
   	 	<br>
   	 	<br>
   	 	를 다루어 보았습니다.!!!!!
   	 
   	 </div>
    </c:if>
    <c:if test="${sessionScope.cookNo != null&&sessionScope.cookNo != 0}">
   	 ${sessionScope.cookName} 님 환영합니다.
    </c:if>