package com.test.springStudy.member.model.dao;

import java.util.List;

import com.test.springStudy.member.model.dto.MemberDTO;

public interface MemberDAO {
	public int setInsert(MemberDTO dto);
	public MemberDTO getLogin(MemberDTO dto);
	public List<MemberDTO> getListAll(int startRecord, int lastRecord, String search_option, String search_data);
	public MemberDTO getView(int no, String search_option, String search_data);
	public int getUpdate(MemberDTO dto);
	public int getDelete(int no);
	public int idCheck(String id);
	public int getTotalRecord(String search_option, String search_data);
}
