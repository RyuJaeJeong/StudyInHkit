package guestBook.src.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import guestBook.src.model.dto.guestBookDTO;


public class guestBookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "happyNewYear";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public int setInsert(guestBookDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getContent());
			result=pstmt.executeUpdate();

			System.out.println("--입력성공--");
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		return result;
	}

	public ArrayList<guestBookDTO> getListAll() {
		getConn();
		ArrayList<guestBookDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from guestBook";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				guestBookDTO dto = new guestBookDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setContent(rs.getString("content"));
				dto.setWrite_date(rs.getString("write_date"));
				arr.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못했습니다.");
		}
		return arr;
	}
}
