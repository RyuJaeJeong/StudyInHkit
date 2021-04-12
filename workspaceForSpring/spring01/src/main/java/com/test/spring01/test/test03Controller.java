package com.test.spring01.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class test03Controller {
	
	@RequestMapping("/test03.do")		//url mapping
	public String test01(Model model) {
		model.addAttribute("name", "류재정");
		model.addAttribute("msg", "안녕하세요?");
		return "test03/exam01";
	}
	
	/*
	 * @RequestMapping("/test03Proc.do") //url mapping public String
	 * test01Proc(Model model,HttpServletRequest request) { String name
	 * = request.getParameter("name"); String gender =
	 * request.getParameter("gender"); String jumin = request.getParameter("jumin");
	 * String age_ = request.getParameter("age"); int age = Integer.parseInt(age_);
	 * 
	 * model.addAttribute("name", name); model.addAttribute("gender", gender);
	 * model.addAttribute("jumin", jumin); model.addAttribute("age", age);
	 * 
	 * return "test03/exam01Result";
	 * 
	 * 
	 */
	
	public Map<String, String> test(HttpServletRequest request) {
		String name = request.getParameter("name"); 
		String gender = request.getParameter("gender");
		String jumin = request.getParameter("jumin");
		String age_ = request.getParameter("age"); 
		
		Map<String, String> map = new HashMap();
		map.put("name", name);
		map.put("gender", gender);
		map.put("jumin", jumin);
		map.put("age_", age_);
		return map;
		
	}
	
	@RequestMapping("/test03Proc.do")		//url mapping
	public String test01Proc(@ModelAttribute Test03DTO dto, Model model) {
		
		String name = dto.getName();
		String gender = dto.getGender();
		String jumin = dto.getJumin();
		int age = dto.getAge(); 
		
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("jumin", jumin);
		model.addAttribute("age", age);
		
		return "test03/exam01Result";
	}
	
}


