package src.model.survey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import src.model.survey.dto.SurveyDTO;

public class SurveyDAO {
	
	//field 
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//cons
	public SurveyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	//method
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
	
	public int setInsert(SurveyDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "insert into survey values(seq_survey.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getSelect1());
			pstmt.setString(3, dto.getSelect2());
			pstmt.setString(4, dto.getSelect3());
			pstmt.setString(5, dto.getSelect4());
			pstmt.setString(6, dto.getServiceStatus());
			result=pstmt.executeUpdate();
			
			System.out.println("--입력성공--");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		return result;
	}
	
	public ArrayList<SurveyDTO> getListAll() {
		getConn();
		ArrayList<SurveyDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from survey";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO();
				dto.setNo(rs.getInt("no"));
				dto.setQuestion(rs.getString("question"));
				dto.setSelect1(rs.getString("select1"));
				dto.setSelect2(rs.getString("select2"));
				dto.setSelect3(rs.getString("select3"));
				dto.setSelect4(rs.getString("select4"));
				dto.setServiceStatus(rs.getString("service_status"));
				arr.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못했습니다.");
		}
		return arr;
	}
	
	public int getUpdate(SurveyDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "update survey set question=?,select1=?,select2=?,select3=?,select4=?,service_status=? where no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQuestion());
			pstmt.setString(2, dto.getSelect1());
			pstmt.setString(3, dto.getSelect2());
			pstmt.setString(4, dto.getSelect3());
			pstmt.setString(5, dto.getSelect4());
			pstmt.setString(6, dto.getServiceStatus());
			pstmt.setInt(7, dto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
	}
	
	public int getDelete(int no) {
		getConn();
		int result = 0;
		try {
			
			String sql = "delete from survey where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
	}
	
	public SurveyDTO getSelectOne(int no) {
		getConn();
		SurveyDTO dto = new SurveyDTO();
		try {
			String sql = "select*from Survey where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setQuestion(rs.getString("question"));
				dto.setSelect1(rs.getString("select1"));
				dto.setSelect2(rs.getString("select2"));
				dto.setSelect3(rs.getString("select3"));
				dto.setSelect4(rs.getString("select4"));
				dto.setServiceStatus(rs.getString("service_status"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return dto;
	}
	
}
