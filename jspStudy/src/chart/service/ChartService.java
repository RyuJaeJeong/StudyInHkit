package chart.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import shop.mall.model.dao.MallDAO;
import shop.mall.model.dto.MallDTO;

public class ChartService {
	
	public JSONObject getChartData() {
		MallDAO mallDao = new MallDAO();
		ArrayList<MallDTO> items = mallDao.getListCartProductGroup();
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		
		col1.put("label", "상품명");
		col1.put("type", "string");
		col2.put("label", "금액");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title); //컬럼에 객체 추가
		
		JSONArray body = new JSONArray();
		for(MallDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getProduct_name());
			JSONObject money = new JSONObject();
			money.put("v", dto.getBuy_money());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row); //셀추가
			body.add(cell);	
		}
		data.put("rows", body);
		return data;
		
	}
	
}
