package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.BoardDTO;


public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName01 = "board";
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "jspTest2";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public void dbConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();};
			if(conn != null) {conn.close();};
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		} finally {
			System.out.println("--오라클 접속 끊기--");
		}
		
	}

	
	public ArrayList<BoardDTO> getListAll(int startRecord, int lastRecord) {
		ArrayList<BoardDTO> arr = new ArrayList<>();
		getConn();
	 try {
			String basicSql = "";
			basicSql += "select t1.* "; 
			basicSql += "from " + tableName01 + " t1 ";
			basicSql += "order by no desc ";
			
			String sql = "";
			sql += "select*from(select A.*, Rownum Rnum from (" + basicSql +")A)";
			sql += "where Rnum>= ? and Rnum <= ?";
			
			int k = 1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(k++, startRecord);
			pstmt.setInt(k++, lastRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));		
				dto.setRegiDate(rs.getDate("regi_date"));
				dto.setPasswd(rs.getString("passwd"));
				arr.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}finally {
			dbConnClose(rs, pstmt, conn);
		}
	 return arr;
}
	
	public int totalRecord() {
		int result = 0; 
		getConn();
		try {
			String sql = "select count(*) from " + tableName01 + " ";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConnClose(rs, pstmt, conn);
		}
		return result;
	}	
	
	public int setInsert(BoardDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into "+ tableName01 + " values(seq_board.nextval,?,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConnClose(rs, pstmt, conn);
		}
		return result;
		
	}
	
	public BoardDTO getView(int no) {
		BoardDTO dto = new BoardDTO();
		getConn();
		try {
			String sql = "";
			sql += "select * from board ";
			sql += "where no = ? ";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegiDate(rs.getDate("regi_date"));
				dto.setPasswd(rs.getString("passwd"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("뷰 가져오기 실패");
		} finally {
			dbConnClose(rs, pstmt, conn);
		}
		
		return dto;
	}

	public int setUpdate(BoardDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update " + tableName01 + " set writer=?, subject = ?, content = ?, passwd = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setInt(5, dto.getNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("뷰 가져오기 실패");
		} finally {
			dbConnClose(rs, pstmt, conn);
		}
		return result;
	}

	public int getDelete(int no) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from " + tableName01 + " where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("뷰 가져오기 실패");
		} finally {
			dbConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
}
