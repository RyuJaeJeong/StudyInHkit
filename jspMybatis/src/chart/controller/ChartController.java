package chart.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import chart.service.ChartService;
import common.Util;


@WebServlet("/chart_servlet/*")
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Util util = new Util();
		Map<String, Integer> naljaMap = util.getDateTime();
		String serverInfo[] = util.getServerInfo(request);
		String refer = serverInfo[0];
		String path = serverInfo[1];
		String url = serverInfo[2];
		String uri = serverInfo[3];
		String ip = serverInfo[4];
		
		String temp;
		
		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp, 1);
		
		String[] sessionArray = util.sessionCheck(request);
		int cookNo = Integer.parseInt(sessionArray[0]);
		String cookId = sessionArray[1];
		String cookName = sessionArray[2];
		
		request.setAttribute("naljaMap", naljaMap);
		request.setAttribute("ip", ip);
		request.setAttribute("pageNumber", pageNumber);
		
		String page = "/main/main.jsp";
		
		if(url.contains("index.do")) {
			request.setAttribute("menu_gubun", "chart_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if (url.contains("googleChartJson.do")) {
			request.setAttribute("menu_gubun", "chart_googleChartJson");
			page = "/chart/googleChartJson.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if (url.contains("createJson.do")) {
			
			request.setAttribute("menu_gubun", "chart_createJson");
			
			ChartService service = new ChartService();
			JSONObject json = service.getChartData();
			request.setAttribute("data", json);
			
			String img_path01 = request.getSession().getServletContext().getRealPath("/attach/json/");
			java.io.File isDir = new java.io.File(img_path01);
			if(!isDir.isDirectory()) {
				isDir.mkdir();
			}
			String img_path02 = img_path01.replace("\\", "/");
 	    	String img_path03 = img_path01.replace("\\", "\\\\");
			
 	    	util.fileDelete(request, img_path03);
 	    	System.out.println(img_path03);
 	    	String new_filename = util.getDateTimeType() + "_" + util.create_uuid() + ".json"; 
 	    	File file = new File(img_path03+new_filename);
 	    	file.createNewFile();
 	    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
 	    	bufferedWriter.write(json.toString());
 	    	bufferedWriter.close();
 	    	
 	    	request.setAttribute("menu_gubun", "chart_myChart");
 	    	request.setAttribute("chart_subject", "차트 제목입니다.");
 	    	request.setAttribute("chart_type", "PieChart");
 	    	request.setAttribute("chart_jsonFileName", new_filename);
 	    	
 	    	page = "/chart/myChart.jsp";
 	    	RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
	}
}
