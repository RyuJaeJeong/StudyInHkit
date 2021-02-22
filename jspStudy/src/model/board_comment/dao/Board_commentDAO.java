package model.board_comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DbExample;
import model.board.dto.BoardDTO;
import model.board_comment.dto.Board_commentDTO;

public class Board_commentDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName01 = "board";
	String tableName02 = "board_comment";
	
	public Connection getConn() {
		conn = DbExample.dbConn();
		return conn;
	}

	public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		DbExample.dbConnClose(rs, pstmt, conn);
	}
	
	public int setInsert(Board_commentDTO dto) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "";
			sql += "insert into ";
			sql += tableName02;
			sql += " values";
			sql +="(seq_board_comment.nextval,?,?,?,?,?,?,sysdate)";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setInt(5, dto.getMemberNo());
			pstmt.setString(6, dto.getIp());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("입력실패");
		} finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public int totalRecord(int board_no) {
		int result = 0; 
		conn = getConn();
		try {
			String sql = "select count(*) from " + tableName02 + " where board_no = ?";
			
			int k = 1;
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(k++, board_no);
						
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<Board_commentDTO> getListAll(int board_no, int startRecord, int lastRecord) {
		 ArrayList<Board_commentDTO> arr = new ArrayList<>();
		 conn = getConn();
		 try {
				String basicSql = "";
				basicSql += "select * from "+tableName02;
				basicSql += " where board_no = ?";
				basicSql += " order by comment_no desc";
				
				String sql = "";
				sql += "select*from(select A.*, Rownum Rnum from (" + basicSql +")A)";
				sql += "where Rnum>= ? and Rnum <= ?";
				int k = 1;
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(k++, board_no);
				pstmt.setInt(k++, startRecord);
				pstmt.setInt(k++, lastRecord);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Board_commentDTO dto = new Board_commentDTO();
					dto.setComment_no(rs.getInt("comment_no"));
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setWriter(rs.getString("writer"));
					dto.setPasswd(rs.getString("passwd"));
					dto.setContent(rs.getString("content"));
					dto.setMemberNo(rs.getInt("memberNo"));
					dto.setIp(rs.getString("ip"));
					dto.setRegiDate(rs.getDate("regiDate"));
					arr.add(dto);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("연결 실패");
			}finally {
				getConnClose(rs, pstmt, conn);
			}
		 return arr;
	}
}
