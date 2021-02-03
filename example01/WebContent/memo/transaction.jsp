<%@page import="example01.memo.model.dao.MemoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   MemoDAO dao = new MemoDAO();
	dao.insertBatch();

%>