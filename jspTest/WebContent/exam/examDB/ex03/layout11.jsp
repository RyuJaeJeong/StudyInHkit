<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>1:1 E-MAIL 상담</h3>
    <h4> ▶상담정보</h4>
    <form name="frm" method="post" action="proc.jsp">
    <table border="1" width="380px">
        <tr>
            <td>상담분류</td>
            <td>
                <select name="about" style="width: 300px;">
                    <option value="구매관련">구매관련</option>
                    <option value="구매관련">판매관련</option>
                </select>
            </td>
        </tr>
    </table>
    <br>
    <h4> ▶회원정보</h4>
    <table border="1" width="430x">
        <tr>
            <td>
               이름 
            </td>  
            <td>
                <input type="text" name="nme" value="" style="width: 300px;" align="center">
            </td> 
        </tr>
        <tr>
            <td>
                연락처 
             </td>  
             <td>
                 <input type="text" name="mob1" value="" style="width: 90px;">-
                 <input type="text" name="mob2" value="" style="width: 90px;">-
                 <input type="text" name="mob3" value="" style="width: 90px;">
             </td> 
             
        </tr>
        <tr>
            <td>
                이메일 
             </td>  
             <td>
                 <input type="text" name="mail1" value="" style="width: 130px;">@
                 <input type="text" name="mail2" value="" style="width: 130px;">
             </td> 
             
        </tr>
    </table>
    <br>
    <h4> ▶질문내용</h4>
    <table border="1" width="450px">
        <tr>
            <td>
               제목
            </td>  
            <td>
                <input type="text" name="sub" value="" style="width: 350px;">
            </td> 
        </tr>
        <tr>
            <td>
                내용 
             </td>  
             <td>
                <textarea name="content" cols="50" rows="10"></textarea>
             </td> 
             
        </tr>
    </table>
    <table>
    <tr>
    <td colspan="2" align="center"><input type="submit" value="제출"></td>
    </tr>
    </table>
    </form>
</body>
</html>