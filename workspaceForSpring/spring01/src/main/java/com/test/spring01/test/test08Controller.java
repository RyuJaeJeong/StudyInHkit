package com.test.spring01.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class test08Controller {
	
	@RequestMapping("/test08.do")		//url mapping
	public String test01(Model model) {
		return "test08/loginFrm";
	}
	
	
	
	
	
	@RequestMapping("/test08Proc.do")		//url mapping
	public String test01Proc(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println(id+"/"+passwd);
		String msg;
		
		if(id.equals("fb0981")&& passwd.equals("1234")) {
			msg = "로그인 성공!";
		}else {
			msg = "로그인 실패!";
		}
		
		model.addAttribute("msg", msg);
		return "test08/loginProc";
		
		
	}
	
}


