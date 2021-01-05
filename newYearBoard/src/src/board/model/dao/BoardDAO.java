package src.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import src.board.model.dto.BoardDTO;
import src.db.Db;
import src.db.DbImplOracle;

public class BoardDAO {
	
	private Connection conn;	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void getConn() {
		try {
			Db d1 = new DbImplOracle();
			conn = d1.dbConn();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패2");
		}
		
	}
	
	
	public int setInsert(BoardDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,?,?,'1','1','0',current_timestamp)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getJakseongja());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, dto.getRef());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력 실패");
		}
		return result;
	}
	
	public int getMaxNum() {
		getConn();
		int num = 0;
		try {
			String sql = "select max(nvl(num,0)) as maxNum from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt("maxNum");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
		return num;
	}
	
	public int getMaxRef() {
		getConn();
		int num = 0;
		try {
			String sql = "select max(nvl(ref,0)) as maxRef from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt("maxRef");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
		return num;
	}
	
	public ArrayList<BoardDTO> getListAll() {
		getConn();
		ArrayList<BoardDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setNum(rs.getInt("num"));
				dto.setJakseongja(rs.getString("jakseongja"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setHit(rs.getInt("hit"));
				dto.setWdate(rs.getString("wdate"));
				arr.add(dto);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;
	}
	
}
