package CRM.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRM.model.dao.ClientDAO;
import CRM.model.dto.ClientDTO;
import CRM.model.dto.MailDTO;
import CRM.service.MailService;
import common.Util;

@WebServlet("/client_servlet/*")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();

		ClientDTO dto = new ClientDTO();
		ClientDAO dao = new ClientDAO();

		String page = "/CRM/client_list.jsp";

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String temp;
		Util util = new Util();

		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp, 1);

		Map<String, Integer> naljaMap = util.getDateTime();
		request.setAttribute("naljaMap", naljaMap);

		if (url.contains("writeProc.do")) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");

			String LYear = request.getParameter("lYear");
			String LMonth = request.getParameter("lMonth");
			String LDay = request.getParameter("lDay");

			String bornYear = "";
			bornYear = LYear + "-" + LMonth + "-" + LDay;
			bornYear += " 00:00:00.0";

			dto.setName(name);
			dto.setBornYear(bornYear);
			dto.setEmail(email);

			int result = dao.setInsert(dto);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('정상적으로 추가 되었습니다.');");
				out.println("location.href='" + path + "/client_servlet/list.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('추가에 실패하였습니다.');");
				out.println("location.href='" + path + "/client_servlet/write.do'");
				out.println("</script>");
			}

		} else if (url.contains("write.do")) {
			page = "/CRM/client_write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.contains("list.do")) {

			int pageSize = 10;
			int blockSize = 10;

			int totalRecord = dao.totalRecord();

			int jj = totalRecord - pageSize * (pageNumber - 1);
			int startRecord = pageSize * (pageNumber - 1) + 1;
			int lastRecord = pageSize * pageNumber;

			int totalPage = 0;
			int startPage = 1;
			int lastPage = 1;
			if (totalRecord > 0) {
				// 총 페이지 갯수
				totalPage = totalRecord / pageSize + (totalRecord % pageSize == 0 ? 0 : 1);
				// 시작 페이지
				startPage = (pageNumber / blockSize - (pageNumber % blockSize != 0 ? 0 : 1)) * blockSize + 1;
				// 마지막 페이지
				lastPage = startPage + blockSize - 1;
				if (lastPage > totalPage) {
					lastPage = totalPage;
				}
			}
			;

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

			List<ClientDTO> arr = dao.getListAll(startRecord, lastRecord);

			request.setAttribute("arr", arr);
			page = "/CRM/client_list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.contains("mail.do")) {
			request.setAttribute("mail_gubun", "email_normal");
			page = "/CRM/mail_write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.contains("mailProc.do")) {
			System.out.println("안녕");
			String fromName = request.getParameter("fromName");
			String fromEmail = request.getParameter("fromEmail");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String mail_gubun = request.getParameter("mail_gubun");
			System.out.println(fromName + fromEmail + subject + content + mail_gubun);
			List<ClientDTO> arr = new ArrayList<>();
			if (mail_gubun.equals("email_normal")) {
				arr = dao.getListAll();
				System.out.println("정상진입");
			} else {
				arr = dao.getTodayAll();
				System.out.println("1 : " + arr.get(0).getName() + arr.size());
			}

			List<MailDTO> brr = new ArrayList<>();

			for (int i = 0; i < arr.size(); i++) {
				MailDTO dto2 = new MailDTO();
				dto2.setFromEmail(fromEmail);
				dto2.setFromEmail(fromEmail);
				dto2.setToEmail(arr.get(i).getEmail());
				// System.out.println("1" + dto2.getToEmail());
				dto2.setSubject(subject);
				dto2.setContent(content);
				brr.add(dto2);
				// System.out.println(brr.get(i).getToEmail());
			}

			
			  MailService service = new MailService();
			  
			  try { 
				 
				  for (int i = 0; i < brr.size(); i++) { 
					  service.mailSender(brr.get(i));
				  }
			  
			  	}catch(Exception e)  { 
				  e.printStackTrace(); System.out.println("메일 전송 실패"); 
			  	}
			
			  
			 
			out.println("<script>");
			out.println("alert('정상적으로 전송 되었습니다.');");
			out.println("location.href='" + path + "/client_servlet/list.do'");
			out.println("</script>");

		} else if (url.contains("BirthdayMail.do")) {
			request.setAttribute("mail_gubun", "email_birthday");
			page = "/CRM/mail_write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

}
