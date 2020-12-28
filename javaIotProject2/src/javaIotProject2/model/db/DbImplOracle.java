package javaIotProject2.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DbImplOracle implements Db {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";		
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "javaIotExam";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공 --");
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}

	}
	public void getConnClose() {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}	
			if (conn != null) {conn.close();}	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
		
	}
	
	public ArrayList<HumanDTO> getListAll() {
		getConn();
		ArrayList<HumanDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from wallPad ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HumanDTO dto = new HumanDTO();
				dto.setAptId(rs.getString("aptId"));
				dto.setSecurity(rs.getString("security"));
				dto.setLight(rs.getString("light"));
				dto.setAircondition(rs.getString("aircondition"));
				dto.setTv(rs.getString("tv"));
				dto.setCucu(rs.getString("cucu"));
				arr.add(dto);
			}
				getConnClose();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;

	}

}
