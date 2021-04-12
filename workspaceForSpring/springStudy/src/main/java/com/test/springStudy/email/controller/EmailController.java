package com.test.springStudy.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
	
	@RequestMapping("/email/index.do")
	public String index(Model model) {
		 model.addAttribute("menu_gubun", "email_index");
		return "main/main";
	}
}
