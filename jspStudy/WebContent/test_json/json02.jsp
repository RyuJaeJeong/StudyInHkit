<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>

<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.io.PrintWriter" %>
<%

String name = request.getParameter("name");
String kor_ = request.getParameter("kor");
int kor = Integer.parseInt(kor_);
String eng_ = request.getParameter("eng");
int eng = Integer.parseInt(eng_);
String mat_ = request.getParameter("mat");
int mat = Integer.parseInt(mat_);
String sci_ = request.getParameter("sci");
int sci = Integer.parseInt(sci_);
String his_ = request.getParameter("his");
int his = Integer.parseInt(his_);

int tot = kor + eng + mat + sci + his;
double avg = (tot/5.) + (tot%5.);

JSONObject jsonobj = new JSONObject();
jsonobj.put("name", name);
jsonobj.put("kor", kor);
jsonobj.put("eng", eng);
jsonobj.put("mat", mat);
jsonobj.put("sci", sci);
jsonobj.put("his", his);

jsonobj.put("tot", name);
jsonobj.put("avg", avg);

String json_sj = jsonobj.toJSONString();
out.println(json_sj);

%>