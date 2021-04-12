package com.test.springStudy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@RequestMapping("/board/index.do")
	public String index(Model model) {
		 model.addAttribute("menu_gubun", "board_index");
		return "main/main";
	}
}
