package com.test.spring01.test.member.model.dao;

import java.util.List;

import com.test.spring01.test.member.model.dto.MemberDTO;



public interface MemberDAO {
		public List<MemberDTO> getList();
		public MemberDTO getView(String id);
		public void setInsert(MemberDTO dto);
		public void setUpdate(MemberDTO dto);
		public void getDelete(String id);
		public int checkPasswd(String id, String passwd);
}
