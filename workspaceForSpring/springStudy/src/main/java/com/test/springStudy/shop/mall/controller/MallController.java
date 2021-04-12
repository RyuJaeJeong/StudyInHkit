package com.test.springStudy.shop.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MallController {
	@RequestMapping("/mall/index.do")
	public String index(Model model) {
		 model.addAttribute("menu_gubun", "mall_index");
		return "main/main";
	}
}
