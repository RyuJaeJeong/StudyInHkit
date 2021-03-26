package member.util;

import java.net.UnknownHostException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.Util;



public class MemberUtil extends Util {

	@Override
	public Map getDateTime() {
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
	public String list_gubunCheck(String list_gubun) {
		// TODO Auto-generated method stub
		return super.list_gubunCheck(list_gubun);
	}

	@Override
	public String[] getServerInfo(HttpServletRequest request) throws UnknownHostException {
		// TODO Auto-generated method stub
		return super.getServerInfo(request);
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
	
}
