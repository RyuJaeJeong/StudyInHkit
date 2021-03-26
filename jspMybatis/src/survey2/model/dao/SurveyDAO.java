package survey2.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import member.model.dto.MemberDTO;
import sqlmap.MybatisManager;
import survey2.model.dto.SurveyAnswerDTO;
import survey2.model.dto.SurveyDTO;

public class SurveyDAO {
	
	String tableName1 = "survey_table";
	String tableName2 = "survey_answer";
	
	
	public int setInsert(SurveyDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		map.put("tableName1", tableName1);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("survey2.setInsert", map);
		session.commit();	
		session.close();
		return result;
	}
	
	public int getTotalRecord(String list_gubun, String [] searchArray) {
			Map<String, String> map = new HashMap<>();
			map.put("list_gubun", list_gubun);
			map.put("search_option", searchArray[0]);
			map.put("search_data", searchArray[1]);
			map.put("search_data_s", searchArray[2]);
			map.put("search_data_e", searchArray[3]);
			map.put("search_date_check", searchArray[4]);
			map.put("tableName1", tableName1);
			SqlSession session = MybatisManager.getInstance().openSession();
			
			int result = session.selectOne("survey2.getTotalRecord", map);
			session.close();
			return result;
			
	}
	
	public List<SurveyDTO> getListAll(int startRecord, int lastRecord, String list_gubun, String [] searchArray) {
		Map<String, String> map = new HashMap<>();
		System.out.println("check : " + searchArray[4]);
		map.put("startRecord", startRecord + "");
		map.put("lastRecord", lastRecord + "");
		map.put("list_gubun", list_gubun);
		map.put("search_option", searchArray[0]);
		map.put("search_data", searchArray[1]);
		if(searchArray[2].length()> 0 && searchArray[3].length()>0) {
			searchArray[2] = searchArray[2] + " 00:00:00.0";
			searchArray[3] = searchArray[3] + " 23:59:59.9";
		}
		map.put("search_data_s", searchArray[2]);
		map.put("search_data_e", searchArray[3]);
		map.put("search_date_check", searchArray[4]);
		map.put("tableName1", tableName1);
		System.out.println(map.get("search_data_s")+map.get("search_data_e")+map.get("search_date_check"));
		SqlSession session = MybatisManager.getInstance().openSession();
		
		List<SurveyDTO> arr = session.selectList("survey2.getListAll", map);
		session.close();
		return arr;
	}
	
	public SurveyDTO getView(int no) {
		SqlSession session = MybatisManager.getInstance().openSession();
		SurveyDTO dto = session.selectOne("survey2.getView", no);
		session.close();
		return dto;
	}
	
	
	
	public int setJosa(SurveyAnswerDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		map.put("tableName2", tableName2);
		SqlSession session = MybatisManager.getInstance().openSession();
		int result = session.insert("survey2.setJosa", map);
		session.commit();	
		session.close();
		return result;
	}
	
	
}
