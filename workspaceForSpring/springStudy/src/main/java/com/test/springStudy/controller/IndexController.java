package com.test.springStudy.controller;


import java.rmi.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.springStudy.common.Util;

@Controller
public class IndexController {
	
	Util util = new Util();
	 @RequestMapping("/")
	 public String index(HttpServletRequest request,Model model) throws UnknownHostException  {
		 model.addAttribute("menu_gubun", "index_");
		 String serverInfo[] = new String[5];
		serverInfo = util.getServerInfo(request);
		 String referer = serverInfo[0];
		 String path = serverInfo[1];
		 String url = serverInfo[2];
		 String uri = serverInfo[3];
		 String ip = serverInfo[4];
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("referer", referer);
		 map.put("path", path);
		 map.put("url", url);
		 map.put("uri", uri);
		 map.put("ip", ip);
		 //System.out.println(ip);
		 model.addAttribute("menu_gubun", "index_");
		 model.addAttribute("ip", ip);
		 return "main/main";
	 }
}
