package model.member;

import java.util.ArrayList;

public class MemberExample {
	MemberDAO dao = new MemberDAOImplOracle();
	//MemberDAO dao = new MemberDAOImpMaria();

	public void getConn() {
		dao.getConn();
	}

	public int setInsert(MemberDTO dto) {
		return dao.setInsert(dto);
	}
	
	public ArrayList<MemberDTO> getListAll() {
		return dao.getListAll();
	}
	
	

}
