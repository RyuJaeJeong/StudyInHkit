package email.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util;
import email.model.EmailDTO;
import email.service.EmailService;


@WebServlet("/email_servlet/*")
public class emailController extends HttpServlet {
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
		util util = new util();
		Map<String, Integer> naljaMap = util.getDateTime();
		String serverInfo[] = util.getServerInfo(request);
		String refer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		
		String temp;
		
		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp, 1);
		
		String[] sessionArray = util.sessionCheck(request);
		int cookNo = Integer.parseInt(sessionArray[0]);
		String cookId = sessionArray[1];
		String cookName = sessionArray[2];
		
		request.setAttribute("naljaMap", naljaMap);
		request.setAttribute("ip", ip);
		request.setAttribute("pageNumber", pageNumber);
		
		String page = "/main/main.jsp";
		
		if(url.contains("index.do")) {
			request.setAttribute("menu_gubun", "email_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if (url.contains("chuga.do")) {
			request.setAttribute("menu_gubun", "email_chuga");
			page = "/email/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("chugaProc.do")) {
			String fromName = request.getParameter("formName");
			String fromEmail = request.getParameter("fromEmail");
			String toEmail = request.getParameter("toEmail");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			System.out.println();
			EmailDTO dto = new EmailDTO();
			dto.setFromName(fromName);
			dto.setFromEmail(fromEmail);
			dto.setToEmail(toEmail);
			dto.setSubject(subject);
			dto.setContent(content);
			
			
			EmailService service = new EmailService();
			
			try {
				service.mailSender(dto);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
