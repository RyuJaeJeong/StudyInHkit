package memo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import memo.model.dto.MemoDTO;

public class MemoDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";		
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "happyNewYear";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공 --");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
	}
	
	public int setInsert(MemoDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql ="insert into memo values(seq_memo.nextval,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
		return result;
	}
	
	public ArrayList<MemoDTO> getListAll() {
		getConn();
		ArrayList<MemoDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemoDTO dto = new MemoDTO();
				dto.setNo(rs.getInt("no"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setWdate(rs.getString("regi_date"));
				arr.add(dto);
			}
				System.out.println("리스트를 가져오지 못하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;
	}
	
	
	
}
