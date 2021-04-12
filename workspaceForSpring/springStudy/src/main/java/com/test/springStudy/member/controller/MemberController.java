package com.test.springStudy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.springStudy.common.Util;
import com.test.springStudy.member.model.dao.MemberDAO;
import com.test.springStudy.member.model.dto.MemberDTO;
import com.test.springStudy.member.util.MemberUtil;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Inject
	MemberDAO memberDao;
	MemberUtil util = new MemberUtil();
	
	public Map<String, Object> topInfo(HttpServletRequest request) throws UnknownHostException {
	      String search_option = request.getParameter("search_option");
	      String search_data = request.getParameter("search_data");
	      String[] searchArray = util.searchCheck(search_option, search_data);
	      search_option = searchArray[0];
	      search_data = searchArray[1];

	      Map<String, Object> map = util.basicInfo(request);
	      map.put("search_option", search_option);
	      map.put("search_data", search_data);
	      System.out.println("no in top : " + map.get("no"));
	      return map;
	  }
	
	@RequestMapping("/index.do")
	public String member_index(HttpServletResponse response, HttpServletRequest request,Model model) throws UnknownHostException {
		
		Map<String, Object> map = topInfo(request);
		String ip = (String) map.get("ip");
		
		String arg01 = request.getParameter("arg01");
		arg01 = util.nullCheck(arg01);
		System.out.println(arg01);
		model.addAttribute("menu_gubun", "member_index");
		model.addAttribute("ip", ip);
		model.addAttribute("arg01", arg01);
		return "main/main";
	}
	
	@RequestMapping("/list.do")
	public String member_list(
			HttpServletRequest request,
			Model model
			) throws UnknownHostException {
		
//		Map<String, Object> map = util.basicInfo(request);
		Map<String, Object> map = topInfo(request);
		int pageNumber = (int) map.get("pageNumber");
		int no = (int) map.get("no");
		String search_option = (String) map.get("search_option");
		String search_data = (String) map.get("search_data");
		
		int pageSize = 10;
		int blockSize = 10;
		int totalRecord = memberDao.getTotalRecord(search_option, search_data);
		int[] pagerArray = util.pager(pageSize, blockSize, totalRecord, pageNumber);
		int jj = pagerArray[0];
		int startRecord = pagerArray[1];
		int lastRecord = pagerArray[2];
		int totalPage = pagerArray[3];
		int startPage = pagerArray[4];
		int lastPage = pagerArray[5];
		
		List<MemberDTO> list = memberDao.getListAll(startRecord, lastRecord, search_option, search_data);
		
		model.addAttribute("menu_gubun", "member_list");
		model.addAttribute("list", list);
//		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("blockSize", blockSize);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("jj", jj);
		model.addAttribute("startRecord", startRecord);
		model.addAttribute("lastRecord", lastRecord);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("lastPage", lastPage);
		
		return "member/list";
		
		
	}
	
	@RequestMapping("view.do")
	   public String member_view(HttpServletRequest request, Model model) throws UnknownHostException {
	      Map<String, Object> map = topInfo(request);
	      int no = (int) map.get("no");
	      System.out.println("no in view" + no);
	      String search_option = (String) map.get("search_option");
	      String search_data = (String) map.get("search_data");
	      System.out.println(no+"/"+search_option+"/"+search_data);
	      MemberDTO dto = memberDao.getView(no, search_option, search_data);
	      model.addAttribute("menu_gubun", "member_view");
	      model.addAttribute("dto", dto);
	      
	      return "member/view";
	   }
	   
	   @RequestMapping("chuga.do")
	   public String member_chuga(HttpServletRequest request, Model model) {
	      model.addAttribute("menu_gubun", "member_chuga");
	      
	      return "member/chuga";
	   }
	   @RequestMapping("/chugaProc.do")
		public void member_chugaProc(
				HttpServletResponse response,
				Model model,
				@RequestParam(value="id", defaultValue="") String id,
				@RequestParam(value="passwd", defaultValue="") String passwd,
				@RequestParam(value="passwdChk", defaultValue="") String passwdChk,
				@RequestParam(value="name", defaultValue="") String name,
				@RequestParam(value="gender", defaultValue="") String gender,
				@RequestParam(value="bornYear", defaultValue="0") int bornYear,
				@RequestParam(value="postcode", defaultValue="") String postcode,
				@RequestParam(value="address", defaultValue="") String address,
				@RequestParam(value="detailAddress", defaultValue="") String detailAddress,
				@RequestParam(value="extraAddress", defaultValue="") String extraAddress
				) {
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPasswd(passwd);
			dto.setName(name);
			dto.setGender(gender);
			dto.setBornYear(bornYear);
			
			dto.setPostcode(postcode);
			dto.setAddress(address);
			dto.setDetailAddress(detailAddress);
			dto.setExtraAddress(extraAddress);
			
			int result = memberDao.setInsert(dto);
			System.out.println("result - :" + result);
			model.addAttribute("menu_gubun", "member_chugaProc");
	/*
			try {
	  			response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정상적으로 등록되었습니다.');");
				out.println("suntaek_proc('list', '1', '');");
				out.println("</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	*/		
		}
	   
	   
	   
	   @RequestMapping("sujung.do")
	   public String member_sujung(HttpServletRequest request, Model model) throws UnknownHostException {
	      Map<String, Object> map = topInfo(request);
	      int no = (int) map.get("no");
	      String search_option = (String) map.get("search_option");
	      String search_data = (String) map.get("search_data");
	      MemberDTO dto = memberDao.getView(no, search_option, search_data);
	      model.addAttribute("menu_gubun", "member_sujung");
	      model.addAttribute("dto", dto);
	      return "member/chuga";
	   }
	   
	   @RequestMapping("sakje.do")
	   public String member_sakje(HttpServletRequest request, Model model) throws UnknownHostException {
	      Map<String, Object> map = topInfo(request);
	      int no = (int) map.get("no");
	      String search_option = (String) map.get("search_option");
	      String search_data = (String) map.get("search_data");
	      MemberDTO dto = memberDao.getView(no, search_option, search_data);
	      model.addAttribute("menu_gubun", "member_sakje");
	      model.addAttribute("dto", dto);
	      return "member/sakje";
	   }
	   
	   @RequestMapping(" id_check_win.do")
	   public String member_id_check_win(HttpServletRequest request, Model model) throws UnknownHostException {
	      model.addAttribute("result", -1 );
	      return "member/id_check";
	   }
	   
	   @RequestMapping("id_check.do")
	   public void id_check(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam(value="id", defaultValue="") String id) throws IOException {
		   PrintWriter out = response.getWriter();
		   int result = memberDao.idCheck(id);
		   out.println(result);
		
	   }
	   
	   @RequestMapping("/sujungProc.do")
		public void member_sujungProc(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model,
				@RequestParam(value="id", defaultValue="") String id,
				@RequestParam(value="passwd", defaultValue="") String passwd,
				@RequestParam(value="passwdChk", defaultValue="") String passwdChk,
				@RequestParam(value="name", defaultValue="") String name,
				@RequestParam(value="gender", defaultValue="") String gender,
				@RequestParam(value="bornYear", defaultValue="0") int bornYear,
				@RequestParam(value="postcode", defaultValue="") String postcode,
				@RequestParam(value="address", defaultValue="") String address,
				@RequestParam(value="detailAddress", defaultValue="") String detailAddress,
				@RequestParam(value="extraAddress", defaultValue="") String extraAddress
			) throws UnknownHostException {
			
			MemberDTO dto = new MemberDTO();
			Map<String, Object> map = topInfo(request);
		    int no = (int) map.get("no");
		    System.out.println("no : " + no);
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
			
			int result = memberDao.getUpdate(dto);
			System.out.println("result - :" + result);
			model.addAttribute("menu_gubun", "member_sujungProc");
	
		}
	   
	   @RequestMapping("/loginProc.do")
		public void member_loginProc(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model,
				@RequestParam(value="id", defaultValue="") String id,
				@RequestParam(value="passwd", defaultValue="") String passwd
			) throws IOException {
		PrintWriter out = response.getWriter();	
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPasswd(passwd);     
			
		
		
		
			try {
				MemberDTO dto2 = memberDao.getLogin(dto);
				HttpSession session = request.getSession();
				session.setAttribute("cookNo", dto2.getNo());
				session.setAttribute("cookId", dto2.getId());
				session.setAttribute("cookName", dto2.getName());
				int data = 1;
				out.println(data);
			} catch (Exception e) {
				int data = -1;
				out.println(data);
			}
	
		}
	   
	   @RequestMapping("/sakjeProc.do")
		public void member_sakjeProc(
				HttpServletRequest request,
				HttpServletResponse response,
				Model model
			) throws UnknownHostException {
			
			MemberDTO dto = new MemberDTO();
			Map<String, Object> map = topInfo(request);
		    int no = (int) map.get("no");
			int result = memberDao.getDelete(no);
			System.out.println("result - :" + result);
			model.addAttribute("menu_gubun", "member_sujungProc");
	
		}
	   
	   @RequestMapping("login.do")
	   public String member_login( Model model) {
		  model.addAttribute("menu_gubun", "member_login");
	      return "member/login";
	   }
	   
	   @RequestMapping("logout.do")
	   public void member_logout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		    HttpSession session = request.getSession();
			session.invalidate();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그아웃 되었습니다.')");
			out.println("location.href = '/springStudy';");
			out.println("</script>");
	   }
	   
}
