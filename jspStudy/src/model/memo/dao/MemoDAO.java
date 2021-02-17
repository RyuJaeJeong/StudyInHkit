package model.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.DbExample;
import model.member.dto.MemberDTO;
import model.memo.dto.MemoDTO;

public class MemoDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConn() {
		conn = DbExample.dbConn();
		return conn;
	}

	public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		DbExample.dbConnClose(rs, pstmt, conn);
	}
	
	public int setInsert(MemoDTO dto) {
		int result = 0;
		conn = getConn();
		try {
			String sql = "insert into memo values(?,?,?,seq_memo.nextval)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getContent());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(3, wdate);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<MemoDTO> getListAll(int startRecord,  int lastRecord) {
		getConn();
		ArrayList<MemoDTO> arr = new ArrayList<>();
		
		try {
			String basicSql = "";
			basicSql += "select*from memo where id>?";
			basicSql += "order by wdate desc";
			String sql = "";
			sql += "select*from(select A.*, Rownum Rnum from(" + basicSql +")A)";
			sql += "where Rnum>= ? and Rnum <= ?";
			
			
			pstmt = conn.prepareStatement(sql);
			int k=1;
			pstmt.setInt(k++, 0);
			pstmt.setInt(k++, startRecord);
			pstmt.setInt(k++, lastRecord);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			MemoDTO dto = new MemoDTO();
			dto.setName(rs.getString("name"));
			dto.setContent(rs.getString("content"));
			dto.setWdate(rs.getString("wdate"));
			arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("메모 리스트 가져오지 못했음");
		}
		return arr;
	}
	
	
	
	
	public int getTotalRecord() {
		getConn();
		int result = 0;
		try {
			
			String sql = "select count(*) from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
