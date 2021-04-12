package com.test.spring01.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class test01Controller {
	
	@RequestMapping("/test01.do")		//url mapping
	public String test01(Model model) {
		model.addAttribute("name", "류재정");
		model.addAttribute("msg", "안녕하세요?");
		return "test01/exam01";
	}
	
	@RequestMapping("/test01Proc.do")		//url mapping
	public String test01Proc(Model model, @RequestParam(value="name", defaultValue="") String name, 
		@RequestParam(value="jumin", defaultValue="") String jumin, @RequestParam(value="gender", defaultValue="F") String gender) {
		model.addAttribute("name", name);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
		return "test01/exam01Result";
		
		//defaultValue 변수 자체가 없으면 기본값이 먹히는데, 변수가있으면 공백넣으면 공백이뜬다. 
	}
	
}
