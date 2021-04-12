package com.test.spring01.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class test07Controller {
	
	@RequestMapping("/test07.do")		//url mapping
	public String test01(Model model) {
		return "test07/exam01";
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
	
	
	
	@RequestMapping("/test07Proc.do")		//url mapping
	public ModelAndView test01Proc(HttpServletRequest request, Model model) {
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_class = request.getParameter("p_class");
		String p_sale = request.getParameter("p_sale");
		String p_sale_price = request.getParameter("p_sale_price");
		
		String [] array =  new String[5];
		array[0] = p_name;
		array[1] = p_price;
		array[2] = p_class;
		array[3] = p_sale;
		array[4] = p_sale_price;
		
		//Model and view
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test07/exam01Result");		
		mv.addObject("array", array);
		
		return mv;
	}
	
}


