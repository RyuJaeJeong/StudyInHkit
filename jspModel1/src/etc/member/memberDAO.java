package etc.member;

import java.util.ArrayList;



public interface memberDAO {

	public void getConn();
	public int setInsert(memberDTO dto); 
	public ArrayList<memberDTO> getListAll();
	public memberDTO getSelectOne(String cookId);
	public int getUpdate(memberDTO dto);
	public int getDel(int no);	
	public String getLogin(String logInid);
	public void counterPlus(String logInid);
	public void counterReset(String logInid);
	
	
}
