package board.controller;

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

import board.model.dao.BoardDAO;
import board.model.dto.BoardDTO;
import board.util.UtilBoard;




@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {
	
       
   
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProc(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		UtilBoard util = new UtilBoard();
		Map<String, Integer> naljaMap = util.getDateTime();
		String serverInfo[] = util.getServerInfo(request);
		String refer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		//String ip6 = serverInfo[5];
		
		String temp;
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		
		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp, 1);
		
		temp = request.getParameter("tbl");
		String tbl = util.tblCheck(temp, "freeboard");
		
		temp = request.getParameter("no");
		int no = util.numberCheck(temp, 0);
		
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String[] searchArray = util.searchCheck(search_option, search_data);
		search_option = searchArray[0];
		search_data = searchArray[1];
		
		String[] sessionArray = util.sessionCheck(request);
		int cookNo = Integer.parseInt(sessionArray[0]);
		String cookId = sessionArray[1];
		String cookName = sessionArray[2];
		
		request.setAttribute("naljaMap", naljaMap);
		request.setAttribute("ip", ip);
		request.setAttribute("tbl", tbl);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("no", no);
		request.setAttribute("search_option", search_option);
		request.setAttribute("search_data",search_data );
		
		
		
		String page = "/main/main.jsp";
		
		if(url.contains("index.do")) {
			request.setAttribute("menu_gubun", "board_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("list.do")) {
			int pageSize = 10;
			int blockSize = 10;
			int totalRecord = dao.getTotalRecord(tbl, search_option, search_data);
			
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
			
			 List<BoardDTO> arr = dao.getListAll(startRecord, lastRecord, tbl, search_option, search_data);
			 
			 request.setAttribute("arr", arr);
			 page = "/board/list.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
		}else if(url.contains("chuga.do")||url.contains("reply.do")) {
			
			if(no > 0) {
				dto = dao.goView(no);
				
				String re_content = "";
				re_content += "["+dto.getWriter() + "]님이 작성한 글입니다.\n";
				re_content = re_content.replace("\n", "\n>");
				re_content += ">"+dto.getContent()+"\n";
				re_content += "----------------------------------------\n";
				
				dto.setContent(re_content);
				request.setAttribute("dto", dto);
			}
			
			page = "/board/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("chugaProc.do")) {
			String writer = request.getParameter("writer");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			String noticeGubun = request.getParameter("noticeGubun");
			int noticeNo;
			if(noticeGubun == null || noticeGubun.trim().equals("")|| !noticeGubun.equals("T")) {
				noticeNo = 0;
			}else {
				noticeNo = dao.getMaxNoticeNo(tbl) + 1;
			}
			String secretGubun = request.getParameter("secretGubun");
			if(secretGubun == null || secretGubun.trim().equals("")|| !secretGubun.equals("T")) {
				secretGubun = "F";
			}else {
				secretGubun = "T";
			}
			
			int num = dao.getMaxNum() + 1;
			int refNo = dao.getMaxRefNo() + 1;
			int stepNo = 1;
			int levelNo = 1;
			int parentNo = 0;
			
			if(no>0) {
				BoardDTO dto2 = dao.goView(no);
				dao.setUpdateReLevel(dto2);
				refNo = dto2.getRefNo();
				stepNo = dto2.getStepNo() +1;
				levelNo = dto2.getLevelNo() + 1;
				parentNo = dto2.getNo();
			}
			//System.out.println(content);
			
			
			int hit = 0;
			
			dto.setNo(no);
			dto.setNum(num);
			dto.setTbl(tbl);
			dto.setWriter(writer);
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setEmail(email);
			dto.setPasswd(passwd);
			
			dto.setRefNo(refNo);
			dto.setStepNo(stepNo);
			dto.setLevelNo(levelNo);
			dto.setParentNo(parentNo);
			dto.setHit(hit);
			dto.setIp(ip);
			
			dto.setMemberNo(cookNo);
			dto.setNoticeNo(noticeNo);
			System.out.println(secretGubun);
			dto.setSecretGubun(secretGubun);
			
			int result = dao.setInsert(dto);
		}else if(url.contains("view.do")) {
			dao.setUpdateHit(no);
			dto = dao.goView(no);
			
			String imsiPage = "viewPage";
			if(dto.getSecretGubun().equals("T")) {
				
				String view_passwd = util.nullCheck(request.getParameter("view_passwd"));
				if(dto.getPasswd().equals(view_passwd)&& !dto.getPasswd().equals("")) {
					
				}else {
					imsiPage = "viewPasswdPage";
				}
			}
			
			String content = dto.getContent();
			
			
			// 개행문자 변환
			 if(content.contains("\n")) {
				content = content.replace("\n", "<br>");
				dto.setContent(content);
				System.out.println("content : " +content);
			}else {
				System.out.println("f");
			}
		
			
			request.setAttribute("menu_gubun", "board_view");
			request.setAttribute("dto", dto);
			request.setAttribute("imsiPage", imsiPage);
			
			page = "/board/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("sujung.do")) {
//			request.setAttribute("menu_gubun", "board_sujung");
			dto = dao.goView(no);
			request.setAttribute("dto", dto);
			
			page = "/board/sujung.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("sujungProc.do")) {

			String writer = request.getParameter("writer");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			System.out.println("content" + content);
			String noticeGubun = request.getParameter("noticeGubun");
			int noticeNo;
			if(noticeGubun == null || noticeGubun.trim().equals("")|| !noticeGubun.equals("T")) {
				noticeNo = 0;
			}else {
				noticeNo = dao.getMaxNoticeNo(tbl) + 1;
			}
			String secretGubun = request.getParameter("secretGubun");
			if(secretGubun == null || secretGubun.trim().equals("")|| !secretGubun.equals("T")) {
				secretGubun = "F";
			}else {
				secretGubun = "T";
			}
			
			dto.setNo(no);
			dto.setTbl(tbl);
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setEmail(email);
			dto.setPasswd(passwd);
			dto.setMemberNo(cookNo);
			dto.setNoticeNo(noticeNo);
			dto.setSecretGubun(secretGubun);
			
			int result = dao.getUpdate(dto);
			
		}else if(url.contains("sakje.do")) {
			dto = dao.goView(no);
			request.setAttribute("dto", dto);
			page = "/board/sakje.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("sakjeProc.do")) {
			String passwd = request.getParameter("passwd");
			dto = dao.goView(no);
			String dbPass = dto.getPasswd();
			BoardDTO dto2 = new BoardDTO();
			dto2.setNo(no);
			dto2.setPasswd(passwd);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			try {
					int result = dao.getDelete(dto2);
					out.println("<script>");
					out.println("alert('정상적으로 삭제 되었습니다.');");
					out.println("GoPage('list','');");
					out.println("</script>");
			} catch (Exception e) {
					e.printStackTrace();
					out.println("<script>");
					out.println("alert('삭제에 실패하였습니다.');");
					out.println("GoPage('view','" + no + "');");
					out.println("</script>");
					return;
			}
			
			out.flush(); // out 객체 초기화.
			out.close();
			
			
			
			
			
		}
		
		
	}
}
