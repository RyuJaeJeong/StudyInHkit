package javaIotProject2.model.db;

import java.util.ArrayList;

public interface Db {
	public void getConn();
	public void getConnClose();
	public ArrayList<HumanDTO> getListAll();

	
}
