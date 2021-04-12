package com.test.springStudy.member.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.springStudy.member.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession session;
	String tableName01 = "member";
	
	@Override
	public int setInsert(MemberDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		int result = session.insert("member.setInsert", map);
		return result;
	}

	@Override
	public MemberDTO getLogin(MemberDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		MemberDTO dto2 = session.selectOne("member.getLogin", map);
		System.out.println(dto2.getId()+"/"+dto2.getName()+"/"+dto2.getNo());
		return dto2;
	}

	@Override
	public List<MemberDTO> getListAll(int startRecord, int lastRecord, String search_option, String search_data) {
		Map<String, String> map = new HashMap<>();
		  map.put("startRecord", startRecord + "");
		  map.put("lastRecord", lastRecord + "");
		  map.put("search_option", search_option);
		  map.put("search_data", search_data);
		  map.put("tableName01", tableName01);
		List<MemberDTO> arr = session.selectList("member.getListAll", map); //리스트로 반환한다.
		return arr;
	}

	@Override
	public MemberDTO getView(int no, String search_option, String search_data) {
		Map<String, String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("search_data", search_data);
		map.put("no", no+"");
		MemberDTO dto = session.selectOne("member.getView", map);
		return dto;
	}

	@Override
	public int getUpdate(MemberDTO dto) {
		System.out.println(dto.getName() + dto.getId() + dto.getPasswd() + dto.getGender() + dto.getBornYear() + dto.getPostcode() + dto.getAddress() + dto.getDetailAddress() + dto.getExtraAddress() +"no : "+ dto.getNo());
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		int result = session.update("member.getUpdate", map);
		return result;
	}

	@Override
	public int getDelete(int no) {
		int result = session.delete("member.getDelete", no);
		return result;
	}

	@Override
	public int idCheck(String id) {
		int result = session.selectOne("member.idCheck", id);
		return result;
	}
	@Override
	public int getTotalRecord(String search_option, String search_data) {
		Map<String, String> map = new HashMap<>();
		  map.put("search_option", search_option);
		  map.put("search_data", search_data);
		  map.put("tableName01", tableName01);
		int result = session.selectOne("member.getTotalRecord", map);
		return result;
	}
	
	

}
