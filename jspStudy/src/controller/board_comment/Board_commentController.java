package controller.board_comment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util;
import model.board.dto.BoardDTO;
import model.board_comment.dao.Board_commentDAO;
import model.board_comment.dto.Board_commentDTO;


@WebServlet("/board_comment_servlet/*")
public class Board_commentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		util util = new util();
		String serverInfo[] = util.getServerInfo(request);
		String refer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		
		String temp;
		
		temp = request.getParameter("CommentPageNumber");
		int CommentPageNumber = util.numberCheck(temp, 1);
		
		
		temp = request.getParameter("no");
		int board_no = util.numberCheck(temp, 0);
		
		request.setAttribute("ip", ip);
		
		
		
		String page = "/board_comment/write.jsp";
		
		Board_commentDTO dto = new Board_commentDTO();
		Board_commentDAO dao = new Board_commentDAO();
		System.out.println("222");
		//페이지 넘버
		if(url.contains("writeProc.do")) {
			String writer = request.getParameter("writer");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("contents");
			System.out.println("content:"+content);
			dto.setBoard_no(board_no);
			dto.setWriter(writer);
			dto.setContent(content);
			dto.setPasswd(passwd);
			dto.setIp(ip);
			dto.setMemberNo(0);
			int result = dao.setInsert(dto);
			
		}else if(url.contains("list.do")) {
			int CommentPageSize = 5;
			int CommentBlockSize = 10;
			int CommentTotalRecord = dao.totalRecord(board_no);
			
			int[] pager = util.pager(CommentPageSize, CommentBlockSize, CommentTotalRecord, CommentPageNumber);
			
			int CommentJj = pager[0];
			int CommentStartRecord = pager[1];
			int CommentLastRecord = pager[2];
			int CommentTotalPage = pager[3];
			int CommentStartPage = pager[4];
			int CommentLastPage = pager[5];
			
			request.setAttribute("CommentPageNumber", CommentPageNumber);
			request.setAttribute("CommentPageSize", CommentPageSize);
			request.setAttribute("CommentBlockSize", CommentBlockSize);
			request.setAttribute("CommentTotalRecord", CommentTotalRecord);
			request.setAttribute("CommentStartRecord", CommentStartRecord);
			request.setAttribute("CommentLastRecord", CommentLastRecord);
			request.setAttribute("CommentTotalPage", CommentTotalPage);
			request.setAttribute("CommentStartPage", CommentStartPage);
			request.setAttribute("CommentLastPage", CommentLastPage);
			request.setAttribute("CommentJj", CommentJj);
			
			 ArrayList<Board_commentDTO> arr = dao.getListAll(board_no, CommentStartRecord, CommentLastRecord);
			 System.out.println("리스트 사이즈 : " + arr.size()+"/"+board_no +"/"+CommentStartRecord+"/"+CommentLastRecord);
			 request.setAttribute("arr", arr);
			 page = "/board_comment/list.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(page);
			 rd.forward(request, response); 
			
		}
		
	}
}
