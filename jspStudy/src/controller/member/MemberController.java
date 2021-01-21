package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.dao.MemberDAO;
import model.member.dto.MemberDTO;


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
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String page = "/main/main.jsp";
		
		if (url.contains("chuga.do")) {
			request.setAttribute("menu_gubun", "member_chuga");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if (url.contains("chugaProc.do")) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String passwdChk = request.getParameter("passwdChk");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			int bornYear = Integer.parseInt(bornYear_);
			int yearcheck = bornYear_.length();
			System.out.println(yearcheck+"길이");
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			
			
			MemberDTO dto = new MemberDTO();
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
			
			MemberDAO dao = new MemberDAO();
			int result = dao.setInsert(dto);
			String temp; 
			if(result > 0) {
				temp = path + "/member_servlet/login.do";
				
			}else  {
				temp = path + "/member_servlet/chuga.do";
			}
				response.sendRedirect(temp);
		}else if (url.contains("login.do")) {
				request.setAttribute("menu_gubun", "member_login");
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
		}else if (url.contains("loginProc.do")) {
				String loginId = request.getParameter("loginId");
				String loginPasswd = request.getParameter("loginPasswd");
				
				
				MemberDTO dto = new MemberDTO();
				dto.setId(loginId);
				dto.setPasswd(loginPasswd);
				
				MemberDAO dao = new MemberDAO();
				MemberDTO resultdto = dao.getLogin(dto);
				
				String temp;
				if(resultdto.getNo()==0) {
					temp = path + "/member_servlet/login.do";
				}else  {
					HttpSession session = request.getSession();
					System.out.println(resultdto.getName());
					session.setAttribute("cookNo", resultdto.getNo());
					session.setAttribute("cookId", resultdto.getId());
					session.setAttribute("cookName", resultdto.getName());
					temp = path;
				}
				
				response.sendRedirect(temp);
			
		}else if (url.contains("logout.do")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그아웃 되었습니다.')");
				out.println("location.href='"+path+"';");
				out.println("</script>");
				
		}else if (url.contains("list.do")) {
			request.setAttribute("menu_gubun", "member_list");
			
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> arr = dao.getListAll();
			
			request.setAttribute("list", arr);
			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if (url.contains("view.do")) {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.goView(no);
			
			request.setAttribute("menu_gubun", "member_view");
			request.setAttribute("dto", dto);
			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("modify.do")) {
			
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			
			HttpSession session = request.getSession();
			int cookNo = (int) session.getAttribute("cookNo");
			if(cookNo!=no) {
				String imsi = path+"/member_servlet/error.do";
				response.sendRedirect(imsi);
				return;
			}
			
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.goView(no);
			
			request.setAttribute("menu_gubun", "member_modify");
			request.setAttribute("dto", dto);
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("modifyProc.do")) {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			int bornYear = Integer.parseInt(bornYear_);
			
			MemberDTO dto = new MemberDTO();
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
			
			MemberDAO dao = new MemberDAO();
			int result = dao.getUpdate(dto);
			String temp;
			if(result>0) {
				temp = path + "/member_servlet/view.do?no="+no;
			}else {
				temp = path + "/member_servlet/modify.do?no="+no;
			}
			response.sendRedirect(temp);
		}else if(url.contains("delete.do")) {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			
			HttpSession session = request.getSession();
			int cookNo = (int) session.getAttribute("cookNo");
			if(cookNo!=no) {
				String imsi = path+"/member_servlet/error.do";
				response.sendRedirect(imsi);
				return;
			}
			
			MemberDAO dao = new MemberDAO();
			int result = dao.getDelete(no);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보가 삭제되었습니다.')");
			out.println("location.href='"+path+"/member_servlet/logout.do';");
			out.println("</script>");
			
		}else if(url.contains("error.do")) {
			request.setAttribute("menu_gubun", "member_error");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("id_check.do")) {
			
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			int result = dao.idCheck(id);
			PrintWriter out = response.getWriter();
			System.out.println(result);
			out.println(result);
		}else if(url.contains("id_check_win.do")) {
			System.out.println("hi!!");
			request.setAttribute("result", -1);
			String temp ="/member/id_check.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(temp);
			rd.forward(request, response);
		}else if(url.contains("id_check_win_proc.do")) {
			System.out.println("hi!");
			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			int result = dao.idCheck(id);
			System.out.println(result);
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			String temp ="/member/id_check.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(temp);
			rd.forward(request, response);
			
		}
	}

}
