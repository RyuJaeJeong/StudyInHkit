package common;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class util {
	public Map getDateTime() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		Map<String, Integer> naljaMap = new HashMap<>();
		naljaMap.put("nowY", year);
		naljaMap.put("nowM", month);
		naljaMap.put("nowD", day);
		naljaMap.put("nowH", hour);
		naljaMap.put("nowN", min);
		naljaMap.put("nowS", sec);
		
		return naljaMap;
		
	}
	
	public int numberCheck(String str, int defaultNumber) {
		String defaultPageNumber = String.valueOf(defaultNumber);
		if(str == null||str.trim().equals("")) {
			str = defaultPageNumber;
		}
		try {
			Double.parseDouble(str);
			return Integer.parseInt(str);
		}catch(Exception e) {
			return Integer.parseInt(defaultPageNumber);
		}
	}
	
	public String list_gubunCheck(String list_gubun) {
		if(list_gubun == null || list_gubun.trim().equals("")) {
			list_gubun = "all";
		}
		list_gubun = list_gubun.trim();
		
		if(list_gubun.equals("all")) {
			
		}else if(list_gubun.equals("ing")) {
			
		}else if(list_gubun.equals("end")) {
			
		}else  {
			list_gubun = "all";
		}
		return list_gubun;
	
	}
	
	public String[] searchCheck(String search_option, String search_data, String search_data_s, String search_data_e, String search_date_check) {
		String [] result = new String[5];
		if(search_option == null|| search_option.trim().equals("")) {
			search_option = "";
		}
		search_option = search_option.trim();
		if(search_option.equals("")) {
			
		}else if (search_option.equals("question")) {
			
		}else {
			search_option = "";
		}
		
		if(search_data_s == null|| search_data_s.trim().equals("")) {
			search_data_s = "";
		}
		search_data_s = search_data_s.trim();
		
		if(search_data_e == null|| search_data_e.trim().equals("")) {
			search_data_e = "";
		}
		search_data_e = search_data_e.trim();
		
		
		
		if(search_data == null|| search_data.trim().equals("")) {
			search_data = "";
		}
		search_data = search_data.trim();
		if(search_option.equals("")|| search_data.equals("")) {
			search_option="";
			search_data = "";
		}
		if(search_date_check == null|| search_date_check.trim().equals("")) {
			search_date_check = "";
		}
		search_date_check = search_date_check.trim();
		
		result[0] = search_option;
		result[1] = search_data;
		result[2] = search_data_s;
		result[3] = search_data_e;
		result[4] = search_date_check;
		
		return result;
	}
	
}
