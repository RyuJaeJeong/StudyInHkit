package jspInterfaceImplExam.model.resume;

import java.util.ArrayList;

public interface ResumeDAO {

	public void getConn();
	public int setInsert(ResumeDTO dto);
	public ArrayList<ResumeDTO> getListAll();
	public ResumeDTO getSelectOne(int no);
	public int getUpdate(ResumeDTO dto);
	public int getDel(int no);
	
	
	
}
