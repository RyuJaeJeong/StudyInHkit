<%@page import="java.io.File"%>

<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%
String upload_path ="c:/UPLOAD";
int max_size = 10*1024*1024;

String name = "";
String subject = "";
String filename = "";
String filename2 = "";
int filesize = 0;
int filesize2 = 0;

try{
	MultipartRequest multi = new MultipartRequest(request, upload_path, max_size, "UTF-8", new DefaultFileRenamePolicy()/*같은 파일있을때 이름 변경*/); 
	name = multi.getParameter("name");
	subject = multi.getParameter("subject");
	Enumeration files = multi.getFileNames();
	String file1 = (String)files.nextElement();
	String file2 = (String)files.nextElement();
	filename = multi.getFilesystemName(file1);
	File f1 = multi.getFile(file1);
	filesize = (int)f1.length();
	filename2 = multi.getFilesystemName(file2);
	File f2 = multi.getFile(file2);
	filesize2 = (int)f2.length();
}catch(Exception e) {
	e.printStackTrace();
	
}


%>