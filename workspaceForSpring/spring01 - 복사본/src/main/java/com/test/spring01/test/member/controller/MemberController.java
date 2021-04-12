package com.test.spring01.test.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.test.spring01.test.member.model.dao.MemberDAO;
import com.test.spring01.test.member.model.dto.MemberDTO;





//@Controller
public class MemberController {
	
	@Inject
	MemberDAO memberDao;
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberDao.getList();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@RequestMapping("member/view.do")
	public String memberView(Model model) {
		return null;
		
	}
	
	@RequestMapping("member/chuga.do")
	public String memberChuga() {
		return "member/chuga";
	}
	
	@RequestMapping("member/memberChugaProc.do")
	public String memberChugaProc(
	/*
	 * @RequestParam(value="id", defaultValue="") String id,
	 * 
	 * @RequestParam(value="password", defaultValue="") String password,
	 * 
	 * @RequestParam(value="name", defaultValue="") String name,
	 * 
	 * @RequestParam(value="email", defaultValue="") String email
	 */
		@ModelAttribute MemberDTO dto
	) {			
			
				memberDao.setInsert(dto);
				return "redirect:member/list.do";
		
	}
	
	@RequestMapping("member/update.do")
	public String memberUpdate(Model model) {
		return null;
		
	}
	
	@RequestMapping("member/delete.do")
	public String memberDelete(Model model) {
		return null;
		
	}
}
