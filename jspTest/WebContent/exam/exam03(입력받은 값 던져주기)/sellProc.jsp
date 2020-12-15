<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<%
String counter_ = request.getParameter("counter");
int counter = Integer.parseInt(counter_);
int tot = 0;
for(int i=0; i<counter; i++) {
String price_= request.getParameter("price"+i);
int price =  Integer.parseInt(price_);
tot =tot + price;	
}
if(tot>=100000) {
	out.println("카드한도초과");
}else {%>
<table border="1">
<tr>
<td>상품명</td>
<td>가격</td>
</tr>
	<%for(int i=0; i<counter; i++) {
		String nme = request.getParameter("nme"+i);
		String price = request.getParameter("price"+i);%>
		<tr>
		<td><%=nme%></td>
		<td><%=price%></td>
		</tr>
		<%}%>
<tr>
<td>합계</td>
<td><%=tot%></td>
</tr>	
</table>	
	

<%}%>

