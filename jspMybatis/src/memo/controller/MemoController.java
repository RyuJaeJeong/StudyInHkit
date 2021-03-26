package memo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Util;
import memo.model.dao.MemoDAO;
import memo.model.dto.MemoDTO;



@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
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
		String path = request.getContextPath();
		
		String url = request.getRequestURL().toString();
		String page = "/main/main.jsp";
		MemoDTO dto = new MemoDTO();
		MemoDAO dao = new MemoDAO();
		
		Util util = new Util();
		String temp;
		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp, 1);
		temp = request.getParameter("id");
		int id = util.numberCheck(temp, 0);
		
		if(url.contains("index.do")) {
			request.setAttribute("menu_gubun", "memo_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("chuga.do")) {
			page = "/memo/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("chugaProc.do")) {
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			System.out.println(name+"/"+content);
			dto.setName(name);
			dto.setContent(content);
			int result = dao.setInsert(dto);
			PrintWriter out = response.getWriter();
			if(result<=0) {
				out.println("<script>");
				out.println("alert('입력에 실패하였습니다.')");
				out.println("location.href='"+path+"';");
				out.println("</script>");
			}
		}else if(url.contains("list.do")) {
			int pageSize = 10; //한 페이지에 보여질 게시물 갯수.
			int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
			int totalRecord = dao.getTotalRecord();
			
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
			request.setAttribute("jj", jj);
			
			request.setAttribute("startRecord", startRecord);
			request.setAttribute("lastRecord", lastRecord);
			
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("lastPage", lastPage);
			
			List<MemoDTO> arr = dao.getListAll(startRecord, lastRecord);
			request.setAttribute("arr", arr);
			page = "/memo/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("delete.do")) {
			 temp = request.getParameter("chk_no");
	    	 String[] array = temp.split(",");
	    	 System.out.println("chk_no : " + temp);
	    	 int result = dao.getDelete(array);
		}else if(url.contains("sujung.do")) {
			dto = dao.goView(id);
			request.setAttribute("dto", dto);
			page = "/memo/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			//System.out.println("완료");
		}else if(url.contains("sujungProc.do")) {
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			System.out.println(name+"/"+content+"/"+id);
			dto.setName(name);
			dto.setContent(content);
			dto.setId(id);
			int result = dao.getUpdate(dto);
			
			request.setAttribute("dto", dto);
			page = "/memo/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}
	
	}

}
