package example01.memo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import example01.memo.model.dto.MemoDTO;

public class MemoDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void getConn() {
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "example01";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPasswd);
			System.out.println("db접속 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db 접속 실패");
		}
	}
	
	public int setInsert(MemoDTO dto) {
		int result = 0;
		getConn();
		try {
		  String sql = "insert into memo (id,name,content) values(seq_memo.nextval,?,?)";
		  pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, dto.getName());
		  pstmt.setString(2, dto.getContent());
		  result = pstmt.executeUpdate();
		  
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("메모입력 실패");
		}
		return result;
	}
	
	public ArrayList<MemoDTO> getListAll(int startRecord,  int lastRecord) {
		getConn();
		ArrayList<MemoDTO> arr = new ArrayList<>();
		
		try {
			String basicSql = "";
			basicSql += "select*from memo where id>?";
			basicSql += "order by id desc";
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
			dto.setId(rs.getInt("id"));
			dto.setName(rs.getString("name"));
			dto.setContent(rs.getString("content"));
			dto.setWdate(rs.getTimestamp("wdate"));
			arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("메모 리스트 가져오지 못했음");
		}
		return arr;
	}
	
	
	public void insertBatch() {
		getConn();
		try {
			
			long start_time = System.currentTimeMillis();
			conn.setAutoCommit(false);  //자동커밋해제
			
			for(int i=1; i<=1000; i++) {
				
				String sql = "insert into memo (id,name,content) values(seq_memo.nextval,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "c"+i);
				pstmt.setString(2, "N"+i);
				pstmt.executeUpdate();
				pstmt.close();
			}
			

			System.out.println("--입력 성공--");
			conn.commit();
			conn.setAutoCommit(true);  //자동커밋설정
			long end_time = System.currentTimeMillis();
			System.out.println("시작시간 : "+start_time+"종료시간 : "+end_time);	
			System.out.println(end_time-start_time);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력 실패--");
		}
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
