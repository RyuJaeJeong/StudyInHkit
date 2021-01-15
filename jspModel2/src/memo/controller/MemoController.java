package memo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.model.dao.MemoDAO;
import memo.model.dto.MemoDTO;

//url mapping url을 맞춘다는 의미이다.!
@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		String url = request.getRequestURI().toString();	//사용자가 요청한 주소.
		
		MemoDAO dao = new MemoDAO();
		if(url.contains("write.do")) {
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			System.out.println(url+writer+content);
			MemoDTO dto = new MemoDTO();
			dto.setWriter(writer);
			dto.setContent(content);
			
			int result = dao.setInsert(dto);
			System.out.println(url.indexOf("write.do"));
			if(result>0) {
				System.out.println("등록되었습니다.");
			}else {
				System.out.println("결과코드 : " + result);
			}
			
		}else if (url.contains("list.do")) {
			ArrayList<MemoDTO> list = dao.getListAll();
			//request영역에 저장해줘라
			request.setAttribute("list", list);
			String page = "/memo/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
