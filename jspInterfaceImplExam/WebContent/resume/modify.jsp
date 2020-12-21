<%@page import="jspInterfaceImplExam.model.resume.ResumeDAOImplOracle"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
System.out.println(no+"뷰페이지");
ResumeDAO dao = new ResumeDAOImplOracle();
ResumeDTO dto = dao.getSelectOne(no);

 	
 String pic = dto.getPic();		
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
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
        <h2 align="center">이 력 서</h2>
        
        <tr>
         <form name="modifyForm"> 
         <table border="1" align="center">
            <h5 style="padding-left: 640px;">◇인적사항</h5>     
            <tr>
              <td rowspan="4" style="width:100px;" align="center"><input type="text" name="pic" value="<%=pic%>"></td> 
              <td style="width: 100px;">성명</td>
              <td style="width: 400px;"><input type="text" name="name" value="<%=name%>"></td>
              
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" value="<%=email%>"></td>
            </tr>
            <tr> 
                <td>휴대폰</td>
                <td><input type="text" name="phone" value="<%=phone%>"></td>
            </tr>
            <tr> 
                <td>주소</td>
                <td><input type="text" name="address" value="<%=address%>"></td>
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
            <td style="width: 200px;" align="center"><input type="text" name="gigan1" value="<%=gigan1%>"></td>
            <td style="width: 200px;" align="center"><input type="text" name="school1" value="<%=school1%>"></td> 
            <td style="width: 200px;" align="center"><input type="text" name="jeongong1" value="<%=jeongong1%>"></td>   
          </tr>
          <tr>
            <td style="width: 200px;" align="center"><input type="text" name="gigan2" value="<%=gigan2%>"></td>
            <td style="width: 200px;" align="center"><input type="text" name="school2 value="<%=school2%>"></td> 
            <td style="width: 200px;" align="center"><input type="text" name="jeongong2" value="<%=jeongong2%>"></td> 
          </tr>
          <tr>
            <td style="width: 200px;" align="center"><input type="text" name="gigan3" value="<%=gigan3%>"></td>
            <td style="width: 200px;" align="center"><input type="text" name="school3" value="<%=school3%>"></td> 
            <td style="width: 200px;" align="center"><input type="text" name="jeongong3" value="<%=jeongong3%>"></td> 
          </tr>
          <tr>
            <td style="width: 200px;" align="center"><input type="text" name="gigan4" value="<%=gigan4%>"></td>
            <td style="width: 200px;" align="center"><input type="text" name="school4" value="<%=school4%>"></td> 
            <td style="width: 200px;" align="center"><input type="text" name="jeongong4" value="<%=jeongong4%>"></td> 
          </tr>
         </table> 
         
         <br><br><br>

         <table border="1" align="center">
            <h5 style="padding-left: 640px;">◇어학능력</h5>     
            <tr>
              <td rowspan="4" style="width:100px;" align="center"  bgcolor="gray">어학</td> 
              <td style="width: 125px;"  bgcolor="gray">TOEIC</td>
              <td style="width: 125px;" ><input type="text" name="TOEIC" value="<%=TOEIC%>"></td>
              <td style="width: 125px;" bgcolor="gray">일본어</td>
              <td style="width: 125px;"><input type="text" name="japan" value="<%=japan%>"></td>
              
            </tr>
            <tr>
                <td style="width: 125px;"  bgcolor="gray">TOEFL</td>
                <td style="width: 125px;"><input type="text" name="TOEFL" value="<%=TOEFL%>"></td>
                <td style="width: 125px;"  bgcolor="gray">중국어</td>
                <td style="width: 125px;"><input type="text" name="china" value="<%=china%>"></td>
            </tr>
            	
         </table>
         </form>
         <br><br>
         
		<table align="center">
			<tr>
            	<td align="center"><button type="button" onclick="mod('<%=no%>')" align="center">수정하기</button></td>
		    </tr>
		</table>

</body>
</html>

<script>
function mod (value1) {
	if(confirm('수정하시겠습니까?')) {
		modifyForm.method="post";
		modifyForm.action="modifyProc.jsp?no="+value1;
		modifyForm.submit();
	}
}
</script>

</body>
</html>