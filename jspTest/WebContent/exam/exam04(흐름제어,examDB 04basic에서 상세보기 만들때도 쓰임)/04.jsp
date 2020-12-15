<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
String name = request.getParameter("nme");
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int mat = Integer.parseInt(request.getParameter("mat"));
int tot = kor+eng+mat;
double avg = tot/3.;
String avg_ = String.format("%.2f", avg);
String grade;
if(avg>=90) {
	grade ="수";
}else if(avg>=80) {
	grade ="우";
}else if(avg>=70) {
	grade ="미";
}else if(avg>=60) {
	grade="양";
}else {
	grade="가";
}

//response.sendRedirect("point2.jsp?name="+name+"&kor="+kor+"&eng="+eng+"&mat="+mat+"&tot="+tot+"&avg="+avg+"&grade="+grade); //흐름제어 아래 생략하고 point2.jsp 로 넘어가버린다
						
%>
<%--<script>
location.href="point2.jsp?name=<%=name%>&tot=<%=tot%>";
</script>--%>

<%-- 
how from here to point2.jsp?
1. response.sendRedirect()
2. javaScript
3. form 을 만들어서 넘겨주는 방법 / <script>document.form.submit()</script>
 --%>
 
 <form name="toPoint2">
 <input type="hidden" name="kor" value="<%=kor%>">
 <input type="hidden" name="eng" value="<%=eng%>">
 <input type="hidden" name="mat" value="<%=mat%>">
 <input type="hidden" name="tot" value="<%=tot%>">
 <input type="hidden" name="avg" value="<%=avg%>">
 </form>
 >s
 
 
 
<table border="1" align="center" line-height="100">
<tr>
<td>이름</td>
<td>국어</td>
<td>영어</td>
<td>수학</td>
<td>합계</td>
<td>평균</td>
<td>등급</td>
</tr>
<tr>
<td><%=name%></td>
<td><%=kor%></td>
<td><%=eng%></td>
<td><%=mat%></td>
<td><%=tot%></td>
<td><%=avg_%></td>
<td><%=grade%></td>
</tr>
</table>




