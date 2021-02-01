package makeConnection.model.member.controller;

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

import org.json.simple.JSONObject;

import makeConnection.model.member.dao.MemberDAO;
import makeConnection.model.member.dto.MemberDTO;



@WebServlet("/member_servlet/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		if(url.contains("joinProc.do")) {
			
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String passwdChk = request.getParameter("passwdChk");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String bornYear_ = request.getParameter("bornYear");			
			int bornYear = Integer.parseInt(bornYear_);
			String postcode = request.getParameter("postcode");
			String address = request.getParameter("address");
			String detailAddress = request.getParameter("detailAddress");
			String extraAddress = request.getParameter("extraAddress");
			
			dto.setId(id);
			dto.setPasswd(passwd);
			dto.setName(name);
			dto.setGender(gender);
			dto.setBornYear(bornYear);
			dto.setPostcode(postcode);
			dto.setAddress(address);
			dto.setDetailAddress(detailAddress);
			dto.setExtraAddress(extraAddress);
			
			int result = dao.setInsert(dto);
			String temp; 
			if(result > 0) {
				temp = path + "/member_servlet/list.do";
				
			}else  {
				temp = path + "/member_servlet/join.do";
			}
			response.sendRedirect(temp);
		}else if(url.contains("list.do")) {
			ArrayList<MemberDTO> arr = dao.getSelectAll();
			request.setAttribute("arr", arr);
			String page = "/member/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("join.do")) {
			String page = "/member/join.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("view.do")) {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			dto = dao.goView(no);
			request.setAttribute("dto", dto);
			String page = "/member/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("modify.do")) {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			dto = dao.goView(no);
			request.setAttribute("menu_gubun", "member_modify");
			request.setAttribute("dto", dto);
			String page = "/member/modify.jsp";
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
			
			dto = new MemberDTO();
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
			String temp;
			if(result>0) {
				temp = path + "/member_servlet/list.do";
			}else {
				temp = path + "/member_servlet/modify.do?no="+no;
			}
			response.sendRedirect(temp);
		}else if(url.contains("id_check.do")) {
			String id = request.getParameter("id");
			int result = dao.idCheck(id);
			PrintWriter out = response.getWriter();
			System.out.println(result);
			out.println(result);
		}else if(url.contains("id_check_win.do")) {
			request.setAttribute("result", -1);
			String temp ="/member/id_check.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(temp);
			rd.forward(request, response);
		}else if(url.contains("id_check_win_proc.do")) {
			System.out.println("hi!");
			String id = request.getParameter("id");
			int result = dao.idCheck(id);
			System.out.println(result);
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			String temp ="/member/id_check.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(temp);
			rd.forward(request, response);
			
		}else if(url.contains("json_test.do")) {
			response.setContentType("text/html; charset=utf-8");
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			
			dto = dao.goView(no);
			
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("no", dto.getNo());
			jsonobj.put("id", dto.getId());
			jsonobj.put("passwd", dto.getPasswd());
			jsonobj.put("name", dto.getName());
			jsonobj.put("gender", dto.getGender());
			jsonobj.put("bornYear", dto.getBornYear());
			jsonobj.put("date", dto.getRegidate());
			String add = dto.getAddress() + dto.getDetailAddress() + dto.getExtraAddress();
			jsonobj.put("add", add);
			String json_sj = jsonobj.toJSONString();
			
			PrintWriter out = response.getWriter();
			out.println(jsonobj);
			
			
		}
	}
}
