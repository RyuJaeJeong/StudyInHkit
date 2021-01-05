<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    
    <% int num = 0; %>
    <a href="#" onclick="start()">[시작하기]</a>
    
    
    
    
    
    <script>
    function start() {
    	location.href = 'pageMakerProc.jsp?num=<%=num%>'
    }
    </script>