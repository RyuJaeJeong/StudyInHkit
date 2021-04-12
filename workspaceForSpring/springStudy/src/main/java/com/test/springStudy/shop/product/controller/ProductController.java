package com.test.springStudy.shop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("/product/index.do")
	public String index(Model model) {
		 model.addAttribute("menu_gubun", "product_index");
		return "main/main";
	}
}
