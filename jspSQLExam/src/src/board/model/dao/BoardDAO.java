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
			String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,?,?,?,?,'0',current_timestamp,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getJakseongja());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, dto.getRef());
			pstmt.setInt(8, dto.getRe_step());
			pstmt.setInt(9, dto.getRe_level());
			pstmt.setString(10, dto.getParentInfo());
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
	
	public ArrayList<BoardDTO> getListAll(int startRow, int endRow) {
		getConn();
		ArrayList<BoardDTO> arr = new ArrayList<>();
		try {
			//String sql = "select*from board order by no desc";
			String sql = "select * from (select rownum rnum, A.*from(select*from board order by ref desc,re_level asc )A)where rnum>=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setNum(rs.getInt("num"));
				dto.setJakseongja(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setHit(rs.getInt("hit"));
				dto.setWdate(rs.getString("wdate"));
				dto.setParentInfo(rs.getString("parentInfo"));
				arr.add(dto);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;
	}
	
	public BoardDTO getSelectOne(int no) {
		getConn();
		BoardDTO dto = new BoardDTO();
		try {
			String sql = "select*from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setNum(rs.getInt("num"));
				dto.setJakseongja(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setHit(rs.getInt("hit"));
				dto.setWdate(rs.getString("wdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return dto;
	}
	
	public int getreplyCount(String myInfo) {
		int count = 0;
		getConn();
		try {
			String sql = "select count(*) from board where parentInfo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, myInfo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return count;
	}
	
	public int getDel(int no) {
		int result = 0;
		getConn();
		try {
			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return result;
		
		
	}
	
	public int getUpdate(BoardDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "update board set num=?,writer=?,subject=?,content=?,email=?,passwd=?,ref=?,re_step=?,re_level=?,hit=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getJakseongja());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, dto.getRef());
			pstmt.setInt(8, dto.getRe_step());
			pstmt.setInt(9, dto.getRe_level());
			pstmt.setInt(10, dto.getHit());
			pstmt.setInt(11, dto.getNo());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return result;
		
		
	}
	
	public int getTotalRecordCount() {
		int count = 0;
		getConn();
		try {
			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return count;
		
	}
	
	public int getTotalRecordCount(String searchField, String searchData) {
		int count = 0;
		getConn();
		try {
			String sql = "";
			if(searchField==null||searchField.length()<=0||searchData==null||searchData.length()<=0) {
				sql="select count(*) from board";
				pstmt = conn.prepareStatement(sql);
			}else if(searchField.equals("content")) {
				sql="select count(*) from board where content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchData + "%");
			}else if(searchField.equals("subject")) {
				sql="select count(*) from board where subject like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchData + "%");
			}else if(searchField.equals("all")) {
				sql="select count(*) from board where content like ? or subject like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchData + "%");
				pstmt.setString(2, "%" + searchData + "%");
			}
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return count;
		
	}
	
	public void setUpdateReLevel (BoardDTO dto) {

		try {
			String sql = "update board set re_level=(re_level+1) where ref=? and re_level>? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getRef());
			pstmt.setInt(2, dto.getRe_level());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getreplyCount(BoardDTO dto) {
		int count = 0;
		getConn();
		try {
			String sql = "select count(*) from board where ref = ? and re_step > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getRef());
			pstmt.setInt(2, dto.getRe_step());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return count;
	}
	
	
	
	public ArrayList<String> getParentInfo(BoardDTO dto2) {
		getConn();
		ArrayList<String> arr = new ArrayList<>();
		try {
			//String sql = "select*from board order by no desc";
			String sql = "select parentInfo from board where ref>? and re_level=?  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto2.getRef());
			pstmt.setInt(2, dto2.getRe_level()+1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String parentInfo = rs.getString("parentInfo");
				arr.add(parentInfo);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;
	}
	
	public void updateParentInfo(ArrayList<String> brr, int ref, int re_level) {
		getConn();
		try {
			for(int i=0; i<brr.size(); i++) {
			String sql = "update board set parentInfo = ? where ref=? and re_level>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brr.get(i));
			pstmt.setInt(2, ref);
			pstmt.setInt(3, re_level);
			pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
	}	
}



