package com.test.springStudy.member.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.springStudy.common.Util;

public class MemberUtil extends Util {
	
	@Override
	public String nullCheck(String str) {
		// TODO Auto-generated method stub
		return super.nullCheck(str);
	}

	@Override
	public String[] getServerInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.getServerInfo(request);
	}

	@Override
	public int[] getDateTime() {
		// TODO Auto-generated method stub
		return super.getDateTime();
	}

	@Override
	public String getDateTimeType() {
		// TODO Auto-generated method stub
		return super.getDateTimeType();
	}

	@Override
	public int numberCheck(String str, int defaultNumber) {
		// TODO Auto-generated method stub
		return super.numberCheck(str, defaultNumber);
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
	public Map<String, Integer> pagerMap(int pageSize, int blockSize, int totalRecord, int pageNumber) {
		// TODO Auto-generated method stub
		return super.pagerMap(pageSize, blockSize, totalRecord, pageNumber);
	}

	@Override
	public String removeTag(String html) throws Exception {
		// TODO Auto-generated method stub
		return super.removeTag(html);
	}

	@Override
	public String create_uuid() {
		// TODO Auto-generated method stub
		return super.create_uuid();
	}

	@Override
	public void fileDelete(HttpServletRequest request, String dir) {
		// TODO Auto-generated method stub
		super.fileDelete(request, dir);
	}

	@Override
	public Map<String, Object> basicInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.basicInfo(request);
	}

	public String[] searchCheck(String search_option, String search_data) {
		String [] result = new String[2];
		if(search_option == null|| search_option.trim().equals("")) {
			search_option = "";
		}
		search_option = search_option.trim();
		if(search_option.equals("")) {
			
		}else if (search_option.equals("id")) {
			
		}else if (search_option.equals("name")) {
			
		}else if (search_option.equals("gender")) {
			
		}else if (search_option.equals("id_name_gender")) {
			
		}else {
			search_option = "";
		}
		
		
		
		
		
		if(search_data == null|| search_data.trim().equals("")) {
			search_data = "";
		}
		search_data = search_data.trim();
		
		if(search_option.equals("")|| search_data.equals("")) {
			search_option="";
			search_data = "";
		}
		
		
		
		result[0] = search_option;
		result[1] = search_data;
		
		
		return result;
	}
}
