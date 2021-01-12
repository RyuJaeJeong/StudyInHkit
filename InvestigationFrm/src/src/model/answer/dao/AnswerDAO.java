package src.model.answer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import src.model.answer.dto.AnswerDTO;
import src.model.survey.dto.SurveyDTO;



public class AnswerDAO {
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
	
	public int setInsert(AnswerDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "insert into answer values(seq_answer.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSurvey_no());
			pstmt.setInt(2, dto.getSurvey_answer());
			result=pstmt.executeUpdate();

			System.out.println("--입력성공--");
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		return result;
	}

	public ArrayList<AnswerDTO> getListAll(int no) {
		getConn();
		ArrayList<AnswerDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from answer where survey_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnswerDTO dto = new AnswerDTO();
				dto.setA_no(rs.getInt("a_no"));
				dto.setSurvey_no(rs.getInt("survey_no"));
				dto.setSurvey_answer(rs.getInt("survey_answer"));
				arr.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못했습니다.");
		}
		return arr;
	}


}


