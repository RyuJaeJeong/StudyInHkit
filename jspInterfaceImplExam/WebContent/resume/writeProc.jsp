<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAOImplOracle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>



<%

String upload_path = application.getRealPath("/upload/img/");
int max_size = 10*1024*1024;

	
 String pic_name="";
 String name="";
 String email="";
 String phone="";
 String address="";
 String TOEIC="";
 String TOEFL="";
 String japan="";
 String china="";

 String gigan1="";
 String school1="";
 String jeongong1="";

 String gigan2="";
 String school2="";
 String jeongong2="";

 String gigan3="";
 String school3="";
 String jeongong3="";

 String gigan4="";
 String school4="";
 String jeongong4="";
 int filesize = 0;

try{
	MultipartRequest multi = new MultipartRequest(request, upload_path, max_size, "UTF-8", new DefaultFileRenamePolicy()/*같은 파일있을때 이름 변경*/); 
	name = multi.getParameter("name");
	email = multi.getParameter("email");
	phone = multi.getParameter("phone");
	address = multi.getParameter("address");
	TOEIC = multi.getParameter("TOEIC");
	TOEFL = multi.getParameter("TOEFL");
	japan = multi.getParameter("japan");
	china = multi.getParameter("china");
	
	gigan1 = multi.getParameter("gigan1");
	school1 = multi.getParameter("school1");
	jeongong1 = multi.getParameter("jeongong1");
	
	gigan2 = multi.getParameter("gigan2");
	school2 = multi.getParameter("school2");
	jeongong2 = multi.getParameter("jeongong2");
	
	gigan3 = multi.getParameter("gigan3");
	school3 = multi.getParameter("school3");
	jeongong3 = multi.getParameter("jeongong3");
	
	gigan4 = multi.getParameter("gigan4");
	school4 = multi.getParameter("school4");
	jeongong4 = multi.getParameter("jeongong4");
	
	Enumeration files = multi.getFileNames();
	String file1 = (String)files.nextElement();
	pic_name = multi.getFilesystemName(file1);
	String filecode = pic_name.substring(pic_name.length()-3, pic_name.length());
	if(!filecode.toUpperCase().equals("JPG")) {
		out.println("<script>");
		out.println("alert('파일형식이 올바르지 않습니다.')");
		out.println("history.back()");
		out.println("</script>");
		return;
	}
	File f1 = multi.getFile(file1);
	filesize = (int)f1.length();
	
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("업로드실패");
	
}


ResumeDAO dao = new ResumeDAOImplOracle();
ResumeDTO dto = new ResumeDTO();
dto.setUpload_path(upload_path);
dto.setPic_name(pic_name);
dto.setName(name);
dto.setEmail(email);
dto.setPhone(phone);
dto.setAddress(address);
dto.setTOEIC(TOEIC);
dto.setTOEFL(TOEFL);
dto.setJapan(japan);
dto.setChina(china);

dto.setGigan1(gigan1);
dto.setSchool1(school1);
dto.setJeongong1(jeongong1);

dto.setGigan2(gigan2);
dto.setSchool2(school2);
dto.setJeongong2(jeongong2);

dto.setGigan3(gigan3);
dto.setSchool3(school3);
dto.setJeongong3(jeongong3);

dto.setGigan4(gigan4);
dto.setSchool4(school4);
dto.setJeongong4(jeongong4);

String to = dto.toString();

System.out.println(to);

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'write.jsp';");
	out.println("</script>");
}




%>