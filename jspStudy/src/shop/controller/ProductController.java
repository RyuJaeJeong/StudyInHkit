package shop.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import common.util;
import model.board.dto.BoardDTO;
import shop.common.UtilProduct;
import shop.model.dao.ProductDAO;
import shop.model.dto.ProductDTO;



@WebServlet("/product_servlet/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html; charset=utf-8");
		 PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		   
		 UtilProduct util = new UtilProduct();
		 ProductDTO dto = new ProductDTO();
 	     ProductDAO dao = new ProductDAO();
 	       
 	     Map<String, Integer> naljaMap = util.getDateTime();
 	      
 	     String serverInfo[] = util.getServerInfo(request); //request.gfetContextPath();
 	     String refer = serverInfo[0];
 	     String path = serverInfo[1];
 	     String url = serverInfo[2];
 	     String uri = serverInfo[3];
 	     String ip = serverInfo[4];

 	     String temp;
 	     temp = request.getParameter("pageNumber");
 	     int pageNumber = util.numberCheck(temp,1);
 	      
 	     temp = request.getParameter("no");
 	     int no = util.numberCheck(temp,0);
 	      
 	     String search_option = request.getParameter("search_option");
 	     String search_data = request.getParameter("search_data");
 	     String[] searchArray = util.searchCheck(search_option, search_data);
 	     search_option = searchArray[0];
 	     search_data = searchArray[1];
 	      
 	     String[] sessionArray = util.sessionCheck(request);
 	     int cookNo = Integer.parseInt(sessionArray[0]);
 	     String cookId = sessionArray[1];
 	     String cookName = sessionArray[2];
 	      
 	     request.setAttribute("naljaMap",naljaMap );
 	     request.setAttribute("ip",ip );
 	     request.setAttribute("pageNumber",pageNumber );
 	     request.setAttribute("no",no );
 	     request.setAttribute("search_option", search_option);
 	     request.setAttribute("search_option", search_option );
 	      
 	     String page = "/main/main.jsp";
 	     
 	     if(url.contains("index.do")) {
 	    	  request.setAttribute("menu_gubun", "product_index");
 	          RequestDispatcher rd = request.getRequestDispatcher(page);
 	          rd.forward(request, response);
 	     }else if(url.contains("chuga.do")) {
 	    	  request.setAttribute("menu_gubun", "product_chuga");
 	    	  
 	    	  page = "/shop/product/chuga.jsp";
	          RequestDispatcher rd = request.getRequestDispatcher(page);
	          rd.forward(request, response);
	          
 	     }else if(url.contains("chugaProc.do")||url.contains("sujungProc.do")) {
 	    	 String img_path01 = request.getSession().getServletContext().getRealPath("/attach/product_img/");
 	    	 String img_path02 = img_path01.replace("\\", "/");
 	    	 String img_path03 = img_path01.replace("\\", "\\\\");
 	    	 
 	    	 //System.out.println(img_path01);
 	    	 
 	    	 MultipartRequest multi = new MultipartRequest(request, img_path03, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
 	    	 //이 순간에 파일이 저장됨 
 	    	 
 	    	 String name = multi.getParameter("name");
 	    	 temp = multi.getParameter("price");
 	    	 int price = Integer.parseInt(temp);
 	    	 temp = multi.getParameter("no");
 	    	 no = util.numberCheck(temp, 0);		    //객체 생성을multi로 했기때문에, 여기서는 request객체로 받은 넘버를 사용하지 못한다. 그래서 multi로 다시 넘버를 받아야한다.
 	    	 String description = multi.getParameter("description");

 	    	 //System.out.println("name : " + name);
 	    	 //System.out.println("price : " + price);
 	    	 //System.out.println("description : " + description);
 	    	 
 	    	 String[] array = new String[3];
 	    	 for (int i = 0; i < array.length; i++) {			// array는 파일 순서를 맞추기 위한 배열, default 값인 -를 미리 넣어준다.
				array[i] = "-";
			 }
 	    	 
 	    	 Enumeration files = multi.getFileNames();
 	    	 while(files.hasMoreElements()) {
 	    		 String formName = (String)files.nextElement();
 	    		 String fileName = multi.getFilesystemName(formName);
 	    		 
 	    		 String fileOrgName = multi.getOriginalFileName(formName);
 	    		 String fileType = multi.getContentType(formName);
 	    		 System.out.println("fileOrgName : " + fileOrgName);
 	    		 System.out.println("fileType : " + fileType);
 	    		 System.out.println(formName+" : "+fileName);
// 	    		 System.out.println(fileOrgName);
// 	    		 System.out.println(fileType);
 	    		 
 	    		 int k = Integer.parseInt(formName);	
 	    		 array[k] = fileName;		//0번 파일 0번째 인덱스에, 1번파일 1번째 인덱스에, 2번 파일 2번째 인덱스에
 	    		 						    //업로드된 파일의 순서를 맞춰준다.
 	    	 }
 	    	 
 	    	java.io.File f1;
 	    	
 	    	String old_path = "";
 	    	
 	    	if(no>0) {													//게시물 수정 시 처리.
 	    		ProductDTO dto2 = new ProductDTO();
 	    		dto2 = dao.getView(no);
 	    		temp = dto2.getProduct_img();							// dbImg [] = {사진1이름 ,사진2이름, 사진3이름}   사진n이름 > 업로드 된 사진 이름 | 실제 사진 이름 
 	    		String [] dbImg = temp.split(",");
 	    		for (int i = 0; i < dbImg.length; i++) {				
 	    			System.out.println("dbImg" + i+ " : " +dbImg[i]);
					if(!dbImg[i].equals("-")&&!array[i].equals("-")) {
						String [] imsi = dbImg[i].split("[|]");			//	imsi [] = {업로드 된 사진 이름, 실제 사진 이름}
						//System.out.println("imsi0 : " +imsi[0]);
						//System.out.println("imsi1 : " +imsi[1]);
						old_path = img_path03 + imsi[1];				//  사진의 실제 경로 
						f1 = new java.io.File(old_path);				// 	파일 지정
						f1.delete();									// 	db테이블에 사진이 존재하고, 같은 인덱스에 새로 사진을 업로드 한 경우
					}
 	    		
					
					if(array[i].equals("-")&&!dbImg[i].equals("-")) {
						array[i] = dbImg[i];
					}
					
				}
 	    	 }
 	    	
 	    	
 	    	
 	    	
 	    	for (int i = 0; i < array.length; i++) {					//파일 이름과 확장자를 이용한 파일 체크
				String filename = array[i];
				if (filename == null) {											
					continue;
				}
				
				//실제 경로에 파일이 존재하지 않을 경우
				old_path = img_path03 + filename;
				f1 = new java.io.File(old_path);
				if(!f1.exists()) {
					continue;
				}
				
				String ext = "";
				int point_index = filename.lastIndexOf(".");
				
				//파일은 올라왔는데 확장자가 없는 경우.
				if(point_index == -1) {
					f1.delete();
					array[i] = "-";
					System.out.println("없다.");
				}
				
				//확장자가 이미지 파일이 아닌경우.
				ext = filename.substring(point_index + 1).toLowerCase();
				System.out.println("ext : " + ext);
				if(!(ext.equals("jpg")||ext.equals("jpeg")||ext.equals("gif")||ext.equals("png"))) {
					f1.delete();
					array[i] = "-";
					continue;
				}
				
				String uuid = util.create_uuid();
				System.out.println("uuid : " + uuid);
				System.out.println(util.getDateTimeType());
				String new_filename = util.getDateTimeType() + "_" + uuid + "." + ext;
				System.out.println("new_filename : " + new_filename);
				java.io.File newFile = new java.io.File(img_path03 + new_filename);
				f1.renameTo(newFile);		
				array[i] = array[i] + "|" + new_filename;
			
 	    	}
 	    	 
 	    	 String str = "";
 	    	 for(int i=0; i<array.length; i++) {
 	    		 str += "," + array[i];
 	    	 }
 	    	 
 	    	 System.out.println(str);
 	    	 str = str.substring(1); //,파일이름1,파일이름2,파일이름3   에서 0번째 인덱스 콤마 자르기
 	    	 System.out.println(str);
 	    	 
 	    	
 	    	 System.out.println(temp);
 	    	 dto.setName(name);
 	    	 dto.setPrice(price);
 	    	 dto.setDescription(description);
 	    	 dto.setProduct_img(str);
 	    	 
 	    	 if(no>0) {
 	    		 int result = dao.setUpdate(dto);
 	    	 }else {
 	    		 int result = dao.setInsert(dto);
 	    	 }
 	    	
 	    	 
 	     }else if(url.contains("list.do")) {
 	    	int pageSize = 10; //한 페이지에 보여질 게시물 갯수.
			int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
			int totalRecord = dao.totalRecord();
			
			int[] pager = util.pager(pageSize, blockSize, totalRecord, pageNumber);
			
			int jj = pager[0];
			int startRecord = pager[1];
			int lastRecord = pager[2];
			int totalPage = pager[3];
			int startPage = pager[4];
			int lastPage = pager[5];
			
			 request.setAttribute("pageNumber", pageNumber);
			 request.setAttribute("pageSize", pageSize);
			 request.setAttribute("blockSize", blockSize);
			 request.setAttribute("totalRecord", totalRecord);
			 request.setAttribute("startRecord", startRecord);
			 request.setAttribute("lastRecord", lastRecord);
			 request.setAttribute("totalPage", totalPage);
			 request.setAttribute("startPage", startPage);
			 request.setAttribute("lastPage", lastPage);
			 request.setAttribute("jj", jj);
			 ArrayList<ProductDTO> arr = dao.getListAll(startRecord, lastRecord);
			 request.setAttribute("arr", arr);
			 
			 page = "/shop/product/list.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
 	     }else if(url.contains("view.do")) {
 	    	 dto = dao.getView(no);
 	    	 
 	    	 temp = dto.getDescription();
 	    	 temp = temp.replace("\n", "<br>");
 	    	 dto.setDescription(temp);
 	    	 
 	    	 request.setAttribute("menu_gubun", "product_view");
 	    	 request.setAttribute("dto", dto);
 	    	 
 	    	 page = "/shop/product/view.jsp";
 	    	 RequestDispatcher rd = request.getRequestDispatcher(page);
 	    	 rd.forward(request, response);
 	     }else if(url.contains("sujung.do")) {
 	    	 request.setAttribute("menu_gubun", "product_sujung");
 	    	 
 	    	 dto = dao.getView(no);
 	    	 request.setAttribute("dto", dto);
 	    	 
 	    	 page = "/shop/product/sujung.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
 	     }else if(url.contains("sakje.do")) {
 	    	 String img_path01 = request.getSession().getServletContext().getRealPath("/attach/product_img/");
	    	 String img_path02 = img_path01.replace("\\", "/");
	    	 String img_path03 = img_path01.replace("\\", "\\\\");
 	    	 System.out.println("no" + no);
 	    	 dto = dao.getView(no);
 	    	 temp = dto.getProduct_img();
 	    	 java.io.File f1;
 	    	 String old_path = "";
 	    	 String imsi [] = temp.split(",");
 	    	 for (int i = 0; i < imsi.length; i++) {
 	    		System.out.println("hi");
 	    		if(!imsi[i].equals("-")) {
 	    			 int gubunja_index = imsi[i].lastIndexOf("|");
 	    			 //System.out.println("gubunja_index : " + gubunja_index);
 	 	    		 String sakje_file = imsi[i].substring(gubunja_index+1);
 	 	    		 //System.out.println(gubunja_index+ " / " +sakje_file);
 	 	    		 old_path = img_path03 + sakje_file;
 	 	    		 f1 = new java.io.File(old_path);
 	 	    		 f1.delete();
 	 	    	 }
 	    	 }
 	    	 
 	    	int result = dao.getDelete(no);
 	    	
 	    	if(result > 0) {
				out.println("<script>");
				out.println("alert('정상적으로 삭제 되었습니다.');");
				out.println("suntaek_proc('list','1', '');");
				out.println("</script>");
				
			}else {
				out.println("<script>");
				out.println("alert('삭제에 실패하였습니다.');");
				out.println("suntaek_proc('view','', '" + no + "');");
				out.println("</script>");
				return;
			}
 	    	 
 	     }
  

	}

}
