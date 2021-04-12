package com.test.spring01.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러로 쓰려면 어노테이션 붙여줘야한다.
public class MainController {
		
		@RequestMapping("/")		//url mapping
		public String index(Model model) {
			model.addAttribute("name", "류재정");
			model.addAttribute("msg", "안녕하세요?");
			return "index";
		}
}
