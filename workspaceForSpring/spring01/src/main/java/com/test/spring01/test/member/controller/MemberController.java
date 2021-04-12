package com.test.spring01.test.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.spring01.test.member.model.dao.MemberDAO;
import com.test.spring01.test.member.model.dto.MemberDTO;






@Controller
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
	public String memberView(Model model,String id) {
		MemberDTO dto = memberDao.getView(id);
		model.addAttribute("dto", dto);
		return "member/view";
	}
	
	@RequestMapping("member/chuga.do")
	public String memberChuga(Model model) {
		model.addAttribute("menu_gubun", "member_chuga");
		return "member/chuga";
	}
	
	@RequestMapping("member/memberChugaProc.do")
	public String memberChugaProc(@ModelAttribute MemberDTO dto) {			
				memberDao.setInsert(dto);
				return "redirect:list.do";
		
	}
	
	@RequestMapping("member/update.do")
	public String memberUpdate(Model model, String id) {
		MemberDTO dto = memberDao.getView(id);
		System.out.println("1");
		model.addAttribute("dto", dto);
		model.addAttribute("menu_gubun", "member_update");
		System.out.println("2");
		return "member/chuga";
	}
	
	@RequestMapping("member/memberUpdateProc.do")
	public String memberUpdateProc(@ModelAttribute MemberDTO dto) {			
				memberDao.setUpdate(dto);
				return "redirect:list.do";
	}
	
	
	
	@RequestMapping("member/delete.do")
	public String memberDelete(Model model, String id) {
		MemberDTO dto = memberDao.getView(id);
		model.addAttribute("dto", dto);
		return "member/delete";
		
	}
	
	@RequestMapping("member/deleteProc.do")
	public String memberDeleteProc(Model model, String id, @RequestParam(value="checkPass", defaultValue="") String checkPass) {
		MemberDTO dto = memberDao.getView(id);
		String passwd = dto.getPasswd();
		System.out.println(checkPass+"/"+passwd);
		if(checkPass.equals(passwd)) {
			System.out.println("삭제에 성공했습니다.");
			memberDao.getDelete(id);
			return "redirect:list.do";
		}else {
			System.out.println("삭제에 실패했습니다.");
			return "redirect:view.do?id="+id;
		}
	}
}
