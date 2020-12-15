<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String[] a = {"a","b","c","d","e"};
for(int i=0; i<a.length; i++) {
	out.println(i+"번째 인덱스의 값은 "+a[i]+"입니다.");
}
%>