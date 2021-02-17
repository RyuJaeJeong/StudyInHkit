package controller.memo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util;
import model.memo.dao.MemoDAO;
import model.memo.dto.MemoDTO;


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
		String pageNumber_ = request.getParameter("pageNumber");
		util util = new util();
		int pageNumber = util.numberCheck(pageNumber_, 1);
		
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
			int pageSize = 10;	//화면에 보여질 게시물 갯수
			int blockSize = 10; //화면에 보여질 페이지 넘버 갯수
			int totalRecord = dao.getTotalRecord();
			
			int jj = totalRecord - pageSize*(pageNumber-1);
			int startRecord = pageSize*(pageNumber-1)+1; //페이지에 표시되는 시작 개시물 
			int lastRecord = pageSize*pageNumber; //패이지에 표시되는 마지막 개시물
			
			int totalPage = 0;
			int startPage = 1;
			int lastPage = 1;
			if(totalRecord>0) {
				totalPage = totalRecord/pageSize+(totalRecord%pageSize == 0 ? 0:1);
				startPage = (pageNumber/blockSize - (pageNumber%blockSize !=0 ? 0:1))*blockSize + 1;
				lastPage = startPage + blockSize - 1;
				if(lastPage>totalPage) {
					lastPage = totalPage;
				}
			}
			
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
			
			ArrayList<MemoDTO> arr = dao.getListAll(startRecord, lastRecord);
			request.setAttribute("arr", arr);
			page = "/memo/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}
	
	}

}
