package model.member;

import java.sql.Connection;
import java.util.ArrayList;

public interface MemberDAO {
	
	public void getConn();
	public int setInsert(MemberDTO dto); 
	public ArrayList<MemberDTO> getListAll();
	public MemberDTO getSelectOne(int no);
	public int getUpdate(MemberDTO dto);
	public int getDel(int no);
}

