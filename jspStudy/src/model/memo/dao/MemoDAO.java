package model.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

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
			String sql = "insert into memo values(?,?,?) ";
			
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
}
