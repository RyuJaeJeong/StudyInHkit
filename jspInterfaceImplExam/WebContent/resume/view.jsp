<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAOImplOracle"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8");%>

<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
System.out.println(no+"뷰페이지");
ResumeDAO dao = new ResumeDAOImplOracle();
ResumeDTO dto = dao.getSelectOne(no);

 	
String upload_path  = dto.getUpload_path();
String pic_name = dto.getPic_name();
 String name = dto.getName();
 String email = dto.getEmail();
 String phone = dto.getPhone();
 String address = dto.getAddress();
 String TOEIC = dto.getTOEIC();
 String TOEFL = dto.getTOEFL();
 String japan = dto.getJapan();
 String china = dto.getChina();

 String gigan1 = dto.getGigan1();
 String school1 = dto.getSchool1();
 String jeongong1 = dto.getJeongong1();

 String gigan2 = dto.getGigan2();
 String school2 = dto.getSchool2();
 String jeongong2 = dto.getJeongong2();

 String gigan3 = dto.getGigan3();
 String school3 = dto.getSchool3();
 String jeongong3 = dto.getJeongong3();

 String gigan4 = dto.getGigan4();
 String school4 = dto.getSchool4();
 String jeongong4 = dto.getJeongong4();
 
 String path = request.getContextPath();

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <table>
        <h2 align="center">이 력 서</h2>
        
        <tr>
          
         <table border="1" align="center">
            <h5 style="padding-left: 640px;" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;◇인적사항</h5>     
            <tr>
              <td rowspan="4" style="width:100px;" align="center"><img src="<%=path%>/upload/img/<%=pic_name%>" style="width:100px; height:100px;"></td> 
              <td style="width: 100px;">성명</td>
              <td style="width: 400px;"><%=name%></td>
              
            </tr>
            <tr>
                <td>이메일</td>
                <td><%=email%></td>
            </tr>
            <tr> 
                <td>휴대폰</td>
                <td><%=phone%></td>
            </tr>
            <tr> 
                <td>주소</td>
                <td><%=address%></td>
            </tr>  
         </table>
         <br><br>  
         <table border="1" align="center">
            <h5 style="padding-left: 640px;">◇학력사항</h5>  
           <tr>
             <td style="width: 200px;" align="center" bgcolor="gray">기간</td>
             <td style="width: 200px;" align="center" bgcolor="gray">학교명</td> 
             <td style="width: 200px;" align="center" bgcolor="gray">전공(학과)</td>   
           </tr>
           <tr>
            <td style="width: 200px;" align="center"><%=gigan1%></td>
            <td style="width: 200px;" align="center"><%=school1%></td> 
            <td style="width: 200px;" align="center"><%=jeongong1%></td>   
          </tr>
          <tr>
            <td style="width: 200px;" align="center"><%=gigan2%></td>
            <td style="width: 200px;" align="center"><%=school2%></td> 
            <td style="width: 200px;" align="center"><%=jeongong2%></td>   
          </tr>
          <tr>
            <td style="width: 200px;" align="center"><%=gigan3%></td>
            <td style="width: 200px;" align="center"><%=school3%></td> 
            <td style="width: 200px;" align="center"><%=jeongong3%></td>  
          </tr>
          <tr>
            <td style="width: 200px;" align="center"><%=gigan4%></td>
            <td style="width: 200px;" align="center"><%=school4%></td> 
            <td style="width: 200px;" align="center"><%=jeongong4%></td>   
          </tr>

         </table> 
         <br><br><br>

         <table border="1" align="center">
            <h5 style="padding-left: 640px;">◇어학능력</h5>     
            <tr>
              <td rowspan="4" style="width:100px;" align="center"  bgcolor="gray">어학</td> 
              <td style="width: 125px;"  bgcolor="gray">TOEIC</td>
              <td style="width: 125px;" ><%=TOEIC%></td>
              <td style="width: 125px;" bgcolor="gray">일본어</td>
              <td style="width: 125px;"><%=japan%></td>
              
            </tr>
            <tr>
                <td style="width: 125px;"  bgcolor="gray">TOEFL</td>
                <td style="width: 125px;"><%=TOEFL%></td>
                <td style="width: 125px;"  bgcolor="gray">중국어</td>
                <td style="width: 125px;"><%=china%></td>
            </tr>
            	
         </table>
         <br><br>
		<table align="center">
		
			<tr>
            	<td align="center"><button type="button" onclick="move('M','<%=no%>')" align="center">수정하기</button></td>
		    	<td align="center"><button type="button" onclick="move('D','<%=no%>')" align="center">삭제하기</button></td>
		    </tr>
		</table>
</tr>
</table>
</body>
</html>

<script>
function move (value1, value2) {
	if(value1=='M') {
		location.href='modify.jsp?no='+value2
	}else if(value1=='D') {
		location.href='delete.jsp?no='+value2
	}
	
}
</script>

