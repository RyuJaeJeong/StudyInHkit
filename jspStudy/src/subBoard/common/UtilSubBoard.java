package subBoard.common;

import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.util;

public class UtilSubBoard extends util {

	@Override
	public Map getDateTime() {
		// TODO Auto-generated method stub
		return super.getDateTime();
	}

	@Override
	public int numberCheck(String str, int defaultNumber) {
		// TODO Auto-generated method stub
		return super.numberCheck(str, defaultNumber);
	}

	@Override
	public String list_gubunCheck(String list_gubun) {
		// TODO Auto-generated method stub
		return super.list_gubunCheck(list_gubun);
	}

	@Override
	public String[] getServerInfo(HttpServletRequest request) throws UnknownHostException {
		// TODO Auto-generated method stub
		return super.getServerInfo(request);
	}

	@Override
	public String[] searchCheck(String search_option, String search_data, String search_data_s, String search_data_e,
			String search_date_check) {
		// TODO Auto-generated method stub
		return super.searchCheck(search_option, search_data, search_data_s, search_data_e, search_date_check);
	}

	@Override
	public String[] sessionCheck(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.sessionCheck(request);
	}

	@Override
	public int[] pager(int pageSize, int blockSize, int totalRecord, int pageNumber) {
		// TODO Auto-generated method stub
		return super.pager(pageSize, blockSize, totalRecord, pageNumber);
	}

	@Override
	public String nullCheck(String str) {
		// TODO Auto-generated method stub
		return super.nullCheck(str);
	}
	
	//게시판 종류 체크
	public String tblCheck(String tbl, String defaultTbl) {
		if(tbl == null|| tbl.trim().equals("")) {
			tbl = defaultTbl;
		}
		tbl = tbl.trim().toLowerCase();
		return tbl;
	}
	
	//검색 유형, 검색어 공백 체크 
	public String[] searchCheck(String search_option, String search_data) {
		String[] result = new String[2];
		
		if(search_option == null || search_option.trim().equals("")) {
			search_option ="";
		}
		search_option = search_option.trim();
		
		if(search_option.equals("")) {
			
		}else if(search_option.equals("writer")) {
			
		}else if(search_option.equals("subject")) {
			
		}else if(search_option.equals("content")) {
			
		}else if(search_option.equals("writer_subject_content")) {
			
		}else {
			search_option = "";
		}
		
		if(search_data == null || search_data.trim().equals("")) {
			search_option = "";
			search_data = "";
		}
		
		result[0] = search_option;
		result[1] = search_data;
		return result;
		
	}
	
	
}
