package shop.mall.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.common.UtilProduct;
import shop.mall.model.dao.MallDAO;
import shop.mall.model.dto.MallDTO;
import shop.model.dao.ProductDAO;
import shop.model.dto.ProductDTO;


@WebServlet("/mall_servlet/*")
public class mallController extends HttpServlet {
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
		 ProductDTO productDto = new ProductDTO();
	     ProductDAO productDao = new ProductDAO();
	     
	     MallDTO dto = new MallDTO();
	     MallDAO dao = new MallDAO();
	     
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
	     System.out.println("pageNumber : " + pageNumber);
	      
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
	    	  request.setAttribute("menu_gubun", "mall_index");
	          RequestDispatcher rd = request.getRequestDispatcher(page);
	          rd.forward(request, response);
	     }else if(url.contains("mall_list.do")) {
	    	    int pageSize = 12; //한 페이지에 보여질 게시물 갯수.
				int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
				int totalRecord = productDao.totalRecord();
				
				int [] pager = util.pager(pageSize, blockSize, totalRecord, pageNumber);
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
				 ArrayList<ProductDTO> arr = productDao.getListAll(startRecord, lastRecord);
				 request.setAttribute("arr", arr);
				 
				 page = "/shop/mall/mall_list.jsp";
				 RequestDispatcher rd = request.getRequestDispatcher(page);
				 rd.forward(request, response); 
				
	     }else if(url.contains("mall_view.do")){
	    	 
	    	 productDto = productDao.getView(no);
 	    	 temp = productDto.getDescription();
 	    	 temp = temp.replace("\n", "<br>");
 	    	 productDto.setDescription(temp);
 	    	 request.setAttribute("menu_gubun", "mall_view");
 	    	 request.setAttribute("dto", productDto);
 	    	 
 	    	 page = "/shop/mall/mall_view.jsp";
 	    	 RequestDispatcher rd = request.getRequestDispatcher(page);
 	    	 rd.forward(request, response); 
	     }else if(url.contains("cart_chuga.do")) {
	    	 
	    	 temp = request.getParameter("amount");
	    	 int amount = util.numberCheck(temp, 1);
	   
	    	
	    	 dto.setMemberNo(cookNo);
	    	 dto.setProductNo(no);
	    	 dto.setAmount(amount);
	    	 System.out.println(cookNo+"/"+no+"/"+amount);
	    	 int result = dao.setInsert(dto);
	    	 
	    	
	    	 
	     }else if(url.contains("cart_list.do")) {
	    	 	int pageSize = 5; //한 페이지에 보여질 게시물 갯수.
				int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
				int totalRecord = dao.totalRecord(cookNo);
				int [] pager = util.pager(pageSize, blockSize, totalRecord, pageNumber);
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
				 ArrayList<MallDTO> arr = dao.getListAll(cookNo, startRecord, lastRecord);
				 request.setAttribute("arr", arr);
	   
				 
				 //System.out.println(totalRecord);
	    	
				 request.setAttribute("arr", arr);
				 request.setAttribute("totalRecord", totalRecord);
				 page = "/shop/mall/cart_list.jsp";
				 RequestDispatcher rd = request.getRequestDispatcher(page);
				 rd.forward(request, response); 
	    	 
	     }else if(url.contains("cart_clear.do")) {
	    	 temp = request.getParameter("chk_no");
	    	 String[] array = temp.split(",");
	    	 System.out.println("chk_no : " + temp);
	    	 boolean result = dao.setDeleteBatch(array);
	     }
		
	}
	
}
