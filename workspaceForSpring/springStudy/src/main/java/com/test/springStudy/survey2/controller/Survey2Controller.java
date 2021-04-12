package com.test.springStudy.survey2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Survey2Controller {
	
	@RequestMapping("/survey2/index.do")
	public String index(Model model) {
		model.addAttribute("menu_gubun", "survey2_index");
		return "main/main";
	}
}
