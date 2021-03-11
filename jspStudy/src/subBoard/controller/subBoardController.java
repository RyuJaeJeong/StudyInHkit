package subBoard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.dto.BoardDTO;
import subBoard.common.UtilSubBoard;
import subBoard.model.dao.SubBoardDAO;
import subBoard.model.dto.SubBoardDTO;


@WebServlet("/subBoard_servlet/*")
public class subBoardController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProc(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //언어 인코딩 
		UtilSubBoard util = new UtilSubBoard();
		Map<String, Integer> naljaMap = util.getDateTime(); //오늘 날짜, 현재시각
		
		String serverInfo[] = util.getServerInfo(request);
		
		String refer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		
		
		
		String temp;
		SubBoardDTO dto = new SubBoardDTO(); 
		SubBoardDAO dao = new SubBoardDAO();
		
		
		
		temp = request.getParameter("pageNumber");
		
		int pageNumber = util.numberCheck(temp, 1); //페이지 번호, 기본값 '1'
		
		
		temp = request.getParameter("tbl");
		String tbl = util.tblCheck(temp, "freeboard"); //게시판 종류, 기본값 자유게시판
		
		
		temp = request.getParameter("no");
		int no = util.numberCheck(temp, 0);
		
		System.out.println(pageNumber + tbl + no);
		
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String[] searchArray = util.searchCheck(search_option, search_data);
		search_option = searchArray[0];	//검색 유형
		search_data = searchArray[1];	//검색어
		
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
		
		if(url.contains("list.do")) {
		
			request.setAttribute("menu_gubun", "subBoard_list");
			int pageSize = 10; //한 페이지에 보여질 게시물 갯수.
			int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
			int totalRecord = dao.totalRecord(tbl, search_option, search_data);
			
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
			
			 ArrayList<BoardDTO> arr = dao.getListAll(startRecord, lastRecord, tbl, search_option, search_data);
			 
			 request.setAttribute("arr", arr);
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
			
		}else if(url.contains("chuga.do")) {
			request.setAttribute("menu_gubun", "subBoard_chuga");
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
				SubBoardDTO dto2 = dao.getView(no);
				dao.setUpdateReLevel(dto2);
				refNo = dto2.getRefNo();
				stepNo = dto2.getStepNo() +1;
				levelNo = dto2.getLevelNo() + 1;
				parentNo = dto2.getNo();
			}
			System.out.println(content);
			
			
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
			dto.setSecretGubun(secretGubun);
			
			int result = dao.setInsert(dto);
			if(result > 0) {
				temp = path + "/subBoard_servlet/list.do";
				
			}else  {
				temp = path + "/subBoard_servlet/chuga.do";
			}
				response.sendRedirect(temp);
		}else if(url.contains("view.do")) {
			dao.setUpdateHit(no);
			dto = dao.getView(no);
			
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
		
			
			request.setAttribute("menu_gubun", "subBoard_view");
			request.setAttribute("dto", dto);
			request.setAttribute("imsiPage", imsiPage);
			
			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}
		
	}
}
