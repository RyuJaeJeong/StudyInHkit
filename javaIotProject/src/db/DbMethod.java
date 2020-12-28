package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbMethod {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Db db = new DbImplOracle();
	public void setInsert(HumanDTO dto) {
	  conn = db.getConn();
	  try {
		  	System.out.println("여기는왔니");
			String sql = "insert into wallPad values(?,?,?,?,?,?, Current_TIMESTAMP)";
			pstmt = conn.prepareStatement(sql);						
			
			pstmt.setString(1, dto.getAptId());
			pstmt.setString(2, dto.getSecurity());
			pstmt.setString(3, dto.getLight());
			pstmt.setString(4, dto.getAircondition());
			pstmt.setString(5, dto.getTv());
			pstmt.setString(6, dto.getCucu());
			pstmt.executeUpdate();
			db.getConnClose();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
	  
	}
}
