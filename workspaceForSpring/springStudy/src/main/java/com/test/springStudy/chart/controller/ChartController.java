package com.test.springStudy.chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartController {
	
	@RequestMapping("/chart/index.do")
	public String index(Model model) {
		model.addAttribute("menu_gubun", "chart_index");
		return "main/main";
	}
}
