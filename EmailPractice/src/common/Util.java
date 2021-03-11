package common;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Util {
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
	
}
