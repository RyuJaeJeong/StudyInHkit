package model.board.dto;

import java.util.Date;

public class BoardChkDTO {

	//field
	private int no;
	private String boardChktbl;
	private String tblName;
	private String serviceGubun;
	private Date wdate;
	
	//cons
	
	public BoardChkDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getter&setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBoardChktbl() {
		return boardChktbl;
	}

	public void setBoardChktbl(String boardChktbl) {
		this.boardChktbl = boardChktbl;
	}

	public String getTblName() {
		return tblName;
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}

	public String getServiceGubun() {
		return serviceGubun;
	}

	public void setServiceGubun(String serviceGubun) {
		this.serviceGubun = serviceGubun;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
	
	
}
