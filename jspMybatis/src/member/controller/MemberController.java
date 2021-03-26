package member.controller;

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
import javax.servlet.http.HttpSession;



import member.model.dao.MemberDAO;
import member.model.dto.MemberDTO;
import member.util.MemberUtil;





@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
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
		 response.setContentType("text/html; charset=utf-8");
		 PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		   
		 MemberUtil util = new MemberUtil();
		 MemberDTO dto = new MemberDTO();
		 MemberDAO dao = new MemberDAO();
	       
	     Map<String, Integer> naljaMap = util.getDateTime();
	      
	     String serverInfo[] = util.getServerInfo(request); //request.gfetContextPath();
	     String refer = serverInfo[0];
	     String path = serverInfo[1];
	     String url = serverInfo[2];
	     String uri = serverInfo[3];
	     String ip = serverInfo[4];

	     String temp;
	     temp = request.getParameter("pageNumber");
	     
	     int pageNumber = util.numberCheck(temp,1);
	    
	     temp = request.getParameter("no");
	     
	     int no = util.numberCheck(temp,0);
	     
	     String search_option = request.getParameter("search_option");
	     String search_data = request.getParameter("search_data");
	     String[] searchArray = util.searchCheck(search_option, search_data);
	     search_option = searchArray[0];
	     search_data = searchArray[1];
	      
	     String[] sessionArray = util.sessionCheck(request);
	     int cookNo = Integer.parseInt(sessionArray[0]);
	     String cookId = sessionArray[1];
	     String cookName = sessionArray[2];
	      
	     request.setAttribute("naljaMap",naljaMap );
	     request.setAttribute("ip",ip );
	     request.setAttribute("pageNumber",pageNumber );
	     request.setAttribute("no",no );
	     request.setAttribute("search_option", search_option);
	     request.setAttribute("search_option", search_option );
	     request.setAttribute("cookNo", cookNo );
	     request.setAttribute("cookId", cookId );
	     request.setAttribute("cookName", cookName );
	     
	     String page = "/main/main.jsp";
		
		if(url.contains("index.do")) {
		
			request.setAttribute("menu_gubun", "member_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		
		}else if (url.contains("chuga.do")) {
			
			page = "/member/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if (url.contains("chugaProc.do")) {
			
			String id = request.getParameter("id");
			id = dao.spCharacter(id);
			String passwd = request.getParameter("passwd");
			passwd = dao.spCharacter(passwd);
			String passwdChk = request.getParameter("passwdChk");
			passwdChk = dao.spCharacter(passwdChk);
			String name = request.getParameter("name");
			name = dao.spCharacter(name);
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			bornYear_ = dao.spCharacter(bornYear_);
			
			int bornYear = Integer.parseInt(bornYear_);
			int yearcheck = bornYear_.length();
			if(yearcheck>4) {
				
			}
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			
			
			
			dto.setId(id);
			dto.setPasswd(passwd);
			dto.setPasswdChk(passwdChk);
			dto.setName(name);
			dto.setGender(gender);
			dto.setBornYear(bornYear);
			dto.setPostcode(postcode);
			dto.setAddress(address);
			dto.setDetailAddress(detailAddress);
			dto.setExtraAddress(extraAddress);
			
			
			dao.setInsert(dto);
		
			System.out.println("가입성공");
				
		}else if (url.contains("login.do")) {
				page = "/member/login.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
		}else if (url.contains("loginProc.do")) {
				String loginId = request.getParameter("loginId");
				String loginPasswd = request.getParameter("loginPasswd");
				
				
				
				dto.setId(loginId);
				dto.setPasswd(loginPasswd);
				//System.out.println(loginId+"/"+loginPasswd);
				
				MemberDTO resultdto = new MemberDTO();
				
				try {
					resultdto = dao.getLogin(dto);
					session.setAttribute("cookNo", resultdto.getNo());
					session.setAttribute("cookId", resultdto.getId());
					session.setAttribute("cookName", resultdto.getName());
					temp = path;
				} catch (Exception e) {
					temp = path + "/member_servlet/login.do";
				}
				response.sendRedirect(temp);
			
		}else if (url.contains("logout.do")) {
				
				session.invalidate();
				response.setContentType("text/html; charset=utf-8");
				if(no==5) {
					out.println("<script>");
					out.println("location.href='"+path+"';");
					out.println("</script>");
				}
		}else if (url.contains("list.do")) {
			request.setAttribute("menu_gubun", "member_list");
			int pageSize = 10; //한 페이지에 보여질 게시물 갯수.
			int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
			int totalRecord = dao.getTotalRecord(search_option, search_data);
			
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
			
			List<MemberDTO> arr = dao.getListAll(startRecord, lastRecord, search_option, search_data);
			
			request.setAttribute("list", arr);
			page = "/member/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if (url.contains("view.do")) {
			
			 dto = dao.goView(no);
			
			request.setAttribute("menu_gubun", "member_view");
			request.setAttribute("dto", dto);
			
			page= "/member/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("sujung.do")) {
			
			if(cookNo!=no) {
				String imsi = path+"/member_servlet/error.do";
				response.sendRedirect(imsi);
				return;
			}
			
			
			System.out.println("수정페이지아래");
			dto = dao.goView(no);
			
			request.setAttribute("menu_gubun", "member_modify");
			request.setAttribute("dto", dto);
			
			page = "/member/modify.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("sujungProc.do")) {
			
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			
			temp = request.getParameter("bornYear");
			System.out.println(temp);
			int bornYear = Integer.parseInt(temp);
			
			
			dto.setNo(no);
			
			dto.setId(id);
			dto.setPasswd(passwd);
			dto.setName(name);
			dto.setGender(gender);
			dto.setBornYear(bornYear);
			dto.setPostcode(postcode);
			dto.setAddress(address);
			dto.setDetailAddress(detailAddress);
			dto.setExtraAddress(extraAddress);
			
			
			int result = dao.getUpdate(dto);
			
			if(result>0) {
				temp = path + "/member_servlet/view.do?no="+no;
			}else {
				temp = path + "/member_servlet/modify.do?no="+no;
			}
			response.sendRedirect(temp);
		}else if(url.contains("sakje.do")) {
			
			if(cookNo!=no) {
				String imsi = path+"/member_servlet/error.do";
				response.sendRedirect(imsi);
				return;
			}
			
		
			int result = dao.getDelete(no);
			response.setContentType("text/html; charset=utf-8");
			
			
			
		}else if(url.contains("error.do")) {
			request.setAttribute("menu_gubun", "member_error");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("id_check.do")) {
			
			String id = request.getParameter("id");
			
			int result = dao.idCheck(id);
			
			System.out.println(result);
			out.println(result);
		}else if(url.contains("id_check_win.do")) {
			
			request.setAttribute("result", -1);
			temp ="/member/id_check.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(temp);
			rd.forward(request, response);
		}else if(url.contains("id_check_win_proc.do")) {
			
			String id = request.getParameter("id");
			
			int result = dao.idCheck(id);
			System.out.println(result);
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			temp ="/member/id_check.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(temp);
			rd.forward(request, response);
			
		}
	}

}
