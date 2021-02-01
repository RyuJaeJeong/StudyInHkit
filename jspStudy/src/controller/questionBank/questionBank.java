package controller.questionBank;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util;


@WebServlet("/questionBank_servlet/*")
public class questionBank extends HttpServlet {
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
		String path = request.getContentType();
		String url = request.getRequestURL().toString();
		String page = "/main/main.jsp";
		util util = new util();
		//현재의 연,월,일,시,분,초가 저장된 맵
		Map<String, Integer> naljamap = util.getDateTime();
		request.setAttribute("naljamap", naljamap);
		
		if(url.contains("makeQuestion.do")) {
			request.setAttribute("menu_gubun", "questionBank_makeQuestion");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("makeQuestionProc.do")) {
			String question = request.getParameter("question");
			String answer1 = request.getParameter("answer1");
			String answer2 = request.getParameter("answer2");
			String answer3 = request.getParameter("answer3");
			String answer4 = request.getParameter("answer4");
			String status = request.getParameter("status");
			String start_date = request.getParameter("start_date");
			
			
			                   String last_date = request.getParameter("last_date");
			
			
			
		}
		
		
	}

}
