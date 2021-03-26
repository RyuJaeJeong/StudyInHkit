package survey2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Util;
import survey2.model.dao.SurveyDAO;
import survey2.model.dto.SurveyAnswerDTO;
import survey2.model.dto.SurveyDTO;




@WebServlet("/survey2_servlet/*")
public class SurveyController extends HttpServlet {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String page = "/main/main.jsp";
		Util util = new Util();
		
		SurveyDAO dao = new SurveyDAO();
		SurveyDTO dto = new SurveyDTO();
		SurveyAnswerDTO dto2 = new SurveyAnswerDTO();
		Map<String, Integer> naljaMap = util.getDateTime();
		request.setAttribute("naljaMap", naljaMap);
		String temp;
		temp = request.getParameter("pageNumber");
		int pageNumber = util.numberCheck(temp,1);
		
		temp = request.getParameter("list_gubun");
		String list_gubun = util.list_gubunCheck(temp);
		
		temp = request.getParameter("no");
		int no = util.numberCheck(temp, 0);
		
		String search_option = request.getParameter("search_option");
		String search_data = request.getParameter("search_data");
		String search_data_s =  request.getParameter("search_data_s");
		String search_data_e =  request.getParameter("search_data_e");
		
		String search_date_check = request.getParameter("search_date_check");
		//System.out.println("search_date_check1" + search_date_check);
		
		String [] searchArray = util.searchCheck(search_option, search_data, search_data_s, search_data_e, search_date_check);
		
		search_option = searchArray[0];
		search_data = searchArray[1];
		search_data_s = searchArray[2];
		search_data_e = searchArray[3];
		search_date_check = searchArray[4];
		
		//System.out.println("search_date_check" + search_date_check);
		request.setAttribute("naljaMap", naljaMap);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("list_gubun", list_gubun);
		request.setAttribute("search_option", search_option);
		request.setAttribute("search_data", search_data);
		request.setAttribute("search_data_s", search_data_s);
		request.setAttribute("search_data_e", search_data_e);
		request.setAttribute("search_date_check", search_date_check);
		
		if (url.contains("index.do")) {
			request.setAttribute("menu_gubun", "survey2_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("list.do")||url.contains("josaAll.do")) {
			int pageSize = 10; //한 페이지에 보여질 게시물 갯수.
			int blockSize = 10; //한 페이지에 보여질 페이지 블록 갯수.
			int totalRecord = dao.getTotalRecord(list_gubun, searchArray);
			
			int[] pager = util.pager(pageSize, blockSize, totalRecord, pageNumber);
			
			int jj = pager[0];
			int startRecord = pager[1];
			int lastRecord = pager[2];
			int totalPage = pager[3];
			int startPage = pager[4];
			int lastPage = pager[5];
			
			//ArrayList<SurveyDTO> list = dao.getList(startRecord, lastRecord, list_gubun, search_option,search_data,search_data_s, search_data_e);
			List<SurveyDTO> list = dao.getListAll(startRecord, lastRecord, list_gubun, searchArray);
			request.setAttribute("menu_gubun", "survey_list");
			request.setAttribute("list", list);
			
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("totalRecord", totalRecord);
			request.setAttribute("jj", jj);
			
			request.setAttribute("startRecord", startRecord);
			request.setAttribute("lastRecord", lastRecord);
			
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("lastPage", lastPage);
			
			
			if(url.contains("list.do")) {
				page = "/survey2/list.jsp";
			}else {
				page = "/survey2/josaAll.jsp";
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("josa.do")) {
			dto = dao.getView(no);
			request.setAttribute("dto", dto);
			page = "/survey2/josa.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("josaProc.do")) {
			
			temp = request.getParameter("answer");
			System.out.println("진입3" + temp);
			int answer = Integer.parseInt(temp);
			
			
			System.out.println(no+"/"+answer);
			dto2.setNo(no);
			dto2.setAnswer(answer);
			
			dao.setJosa(dto2);
			
			
		}else if(url.contains("josaAll.do")) {
			
			page = "/survey2/josaAll.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("josaAllProc.do")) {
			String answer_total = request.getParameter("answer_total");
			System.out.println("answer_total:"+answer_total);
			String [] answer_totalArr = answer_total.split("[|]");
			
			for (int i = 0; i < answer_totalArr.length; i++) {
				String[] imsiArr = answer_totalArr[i].split(":");
				int tempNo = Integer.parseInt(imsiArr[0]);
				int tempAnswer = Integer.parseInt(imsiArr[1]);
				
				System.out.println("tempNo : "+ tempNo+"tempAnswer : "+tempAnswer);
				
				dto2.setNo(tempNo);
				dto2.setAnswer(tempAnswer);
				dao.setJosa(dto2);
				
			}
		}
		
		
		
	}
	
}
