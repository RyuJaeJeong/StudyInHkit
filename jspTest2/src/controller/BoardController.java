package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Util;
import model.dao.BoardDAO;
import model.dto.BoardDTO;



@WebServlet("/board_controller/*")
public class BoardController extends HttpServlet {
	
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
		String uri = request.getRequestURI().toString();
		
		String temp;
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		
		Util util = new Util();
		
		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp, 1);
		
		temp = request.getParameter("no");
		int no = util.numberCheck(temp, 0);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("no", no);
		
		String page = "";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		 
		if(url.contains("list.do")) {
			int pageSize = 10;
			int blockSize = 10;
			int totalRecord = dao.totalRecord();
			
			int jj = totalRecord - pageSize*(pageNumber - 1);
			int startRecord = pageSize*(pageNumber-1)+1;
			int lastRecord = pageSize * pageNumber;
			
			int totalPage = 0;
			int startPage = 1;
			int lastPage = 1;
			if(totalRecord > 0) {
				//총 페이지 갯수
				totalPage = totalRecord/pageSize + (totalRecord%pageSize == 0?0:1);
				//시작 페이지
				startPage = (pageNumber/blockSize - (pageNumber%blockSize != 0?0:1))*blockSize+1; 
				//마지막 페이지
				lastPage = startPage + blockSize -1;
				if(lastPage > totalPage) {
					lastPage = totalPage;
				}
			};
			
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
			
			ArrayList<BoardDTO> arr = dao.getListAll(startRecord, lastRecord);
			
			 request.setAttribute("arr", arr);
			 page = "/board/list.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
			
		}else if(url.contains("chuga.do")) {
			 page = "/board/chuga.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
		}else if(url.contains("chugaProc.do")) {
			String writer = request.getParameter("writer");
			String passwd = request.getParameter("passwd");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			if(writer.trim().length()==0||writer.equals(null)) {
				 out.println("<script>");
				 out.println("alert('글쓴이를 입력해주세요.');");
				 out.println("history.back()");
				 out.println("</script>");
				 return;
			}
			
			dto.setNo(no);
			dto.setWriter(writer);
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setPasswd(passwd);
			
			int result = dao.setInsert(dto);
			
			if(result > 0) {
				temp = path + "/board_controller/list.do";
				
			}else  {
				temp = path + "/board_controller/chuga.do";
			}
			
				response.sendRedirect(temp);
		}else if(url.contains("view.do")) {
			dto = dao.getView(no);
			String content = dto.getContent();
			
			
			// 개행문자 변환
			 if(content.contains("\n")) {
				content = content.replace("\n", "<br>");
				dto.setContent(content);
				System.out.println("content : " +content);
			}else {
				System.out.println("f");
			}
			 
			 
			 request.setAttribute("dto", dto);
			 page = "/board/view.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response);
			
		}else if(url.contains("sujung.do")) {
			 dto = dao.getView(no);
			 String content = dto.getContent();
			 request.setAttribute("dto", dto);	
			 page = "/board/sujung.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
		}else if(url.contains("sujungProc.do")) {
			String writer = request.getParameter("writer");
			String passwd = request.getParameter("passwd");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			System.out.println(writer+" / " + no);
			dto.setNo(no);
			dto.setWriter(writer);
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setPasswd(passwd);
			
			int result = dao.setUpdate(dto);
			
			if(result > 0) {
				temp = path + "/board_controller/list.do";
				
			}else  {
				temp = path + "/board_controller/sujung.do?no="+no;
			}
			
			response.sendRedirect(temp);
		} else if(url.contains("sakje.do")){
			 dto = dao.getView(no);
			 String content = dto.getContent();
			 
			// 개행문자 변환
			 if(content.contains("\n")) {
				content = content.replace("\n", "<br>");
				dto.setContent(content);
				System.out.println("content : " +content);
			}else {
				System.out.println("f");
			}
			 
			 request.setAttribute("dto", dto);	
			 page = "/board/sakje.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response);
		} else if(url.contains("sakjeProc.do")) {
			 String passwd = request.getParameter("passwd");
			 String inputPasswd = request.getParameter("inputPasswd");
			 
			
			 if(passwd.equals(inputPasswd)) {
				 int result = dao.getDelete(no);
				 if(result>0) {
					 out.println("<script>");
					 out.println("alert('정상적으로 삭제 되었습니다.');");
					 out.println("location.href='"+path+"/board_controller/list.do'");
					 out.println("</script>");
				 }else {
					 out.println("<script>");
					 out.println("alert('삭제에 실패 하였습니다.');");
					 out.println("location.href='" + path + "/board_controller/view.do?pageNumber="+pageNumber+"&no="+no+"'");
					 out.println("</script>");
				 }
			 }else {
					 out.println("<script>");
					 out.println("alert('삭제에 실패 하였습니다.');");
					 out.println("location.href='" + path + "/board_controller/view.do?pageNumber="+pageNumber+"&no="+no+"'");
					 out.println("</script>");
					 
			 }
			 
		}
		
	}

}
