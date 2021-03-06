package survey.controller;

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
import survey.model.dao.SurveyDAO;
import survey.model.dto.SurveyDTO;




@WebServlet("/survey_servlet/*")
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
			request.setAttribute("menu_gubun", "survey_index");
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("chuga.do")) {
			request.setAttribute("menu_gubun", "survey_chuga");
			page = "/survey/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("chugaProc.do")) {
			String question = request.getParameter("question");
			String ans1 = request.getParameter("ans1");
			String ans2 = request.getParameter("ans2");
			String ans3 = request.getParameter("ans3");
			String ans4 = request.getParameter("ans4");
			String status = request.getParameter("status");
			
			String sYear = request.getParameter("sYear");
			String sMonth = request.getParameter("sMonth");
			String sDay = request.getParameter("sDay");

			String LYear = request.getParameter("lYear");
			String LMonth = request.getParameter("lMonth");
			String LDay = request.getParameter("lDay");
			
			
			
			String start_date_ = "";
			start_date_ += sYear+"-"+sMonth+"-"+sDay;
			start_date_ += " 00:00:00.0";
			
			java.sql.Timestamp start_date = java.sql.Timestamp.valueOf(start_date_);
			
			String last_date_= "";
			last_date_ = LYear+"-"+LMonth+"-"+LDay;
			last_date_ += " 23:59:59.9";
			
			java.sql.Timestamp last_date = java.sql.Timestamp.valueOf(last_date_);
			
			
			
			dto.setQuestion(question);
			dto.setAns1(ans1);
			dto.setAns2(ans2);
			dto.setAns3(ans3);
			dto.setAns4(ans4);
			dto.setStatus(status);
			dto.setStart_date(start_date);
			dto.setLast_date(last_date);
			
			int result = dao.setInsert(dto);
		
		
		}else if(url.contains("list.do")) {
			int pageSize = 10; //화면에 보여질 게시물 갯수
			int blockSize = 10;
			//int totalRecord = dao.getTotalRecord(list_gubun, search_option, search_data, search_data_s, search_data_e );
			//System.out.println(search_option+"-"+search_data);
			//System.out.println("search_data_s : " + search_data_s);
			//System.out.println("search_data_e : " + search_data_e);
			int totalRecord = dao.getTotalRecord(list_gubun, searchArray);
			int jj = totalRecord - pageSize*(pageNumber-1);
			int startRecord = pageSize*(pageNumber-1)+1;
			int lastRecord = pageSize*pageNumber;
			
			
			int totalPage = 0;
			int startPage = 1;
			int lastPage = 1;
			if(totalRecord>0) {
				totalPage = totalRecord/pageSize+(totalRecord%pageSize == 0 ? 0:1);
				startPage = (pageNumber/blockSize - (pageNumber%blockSize !=0 ? 0:1))*blockSize + 1;
				lastPage = startPage + blockSize - 1;
				if(lastPage>totalPage) {
					lastPage = totalPage;
				}
				
				
			}
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
			
			
			page = "/survey/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("view.do")) {
			dto = dao.getView(no);
			request.setAttribute("dto", dto);
			page = "/survey/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}else if(url.contains("sujung.do")) {
			dto = dao.getView(no);
			request.setAttribute("dto", dto);
			request.setAttribute("menu_gubun", "survey_sujung");
			page = "/survey/chuga.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}else if(url.contains("sujungProc.do")) {
			String question = request.getParameter("question");
			String ans1 = request.getParameter("ans1");
			String ans2 = request.getParameter("ans2");
			String ans3 = request.getParameter("ans3");
			String ans4 = request.getParameter("ans4");
			String status = request.getParameter("status");
			
			String sYear = request.getParameter("sYear");
			String sMonth = request.getParameter("sMonth");
			String sDay = request.getParameter("sDay");

			String LYear = request.getParameter("lYear");
			String LMonth = request.getParameter("lMonth");
			String LDay = request.getParameter("lDay");
			
			String start_date_ = "";
			start_date_ += sYear+"-"+sMonth+"-"+sDay;
			start_date_ += " 00:00:00.0";
			
			java.sql.Timestamp start_date = java.sql.Timestamp.valueOf(start_date_);
			
			String last_date_= "";
			last_date_ = LYear+"-"+LMonth+"-"+LDay;
			last_date_ += " 23:59:59.9";
			
			java.sql.Timestamp last_date = java.sql.Timestamp.valueOf(last_date_);
			dto.setNo(no);
			dto.setQuestion(question);
			dto.setAns1(ans1);
			dto.setAns2(ans2);
			dto.setAns3(ans3);
			dto.setAns4(ans4);
			dto.setStatus(status);
			dto.setStart_date(start_date);
			dto.setLast_date(last_date);
			
			int result = dao.setUpdate(dto);
			
		}else if(url.contains("sakjeProc.do")) {
			System.out.println("no : " + no);
			int result = dao.getDelete(no);
		}
		
		
		
	}
	
}
