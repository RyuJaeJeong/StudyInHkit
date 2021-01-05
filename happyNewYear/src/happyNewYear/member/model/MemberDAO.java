package happyNewYear.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "happyNewYear";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public int setInsert(MemberDTO dto) {
		getConn();
		int result = 0;
		try {
			pstmt = conn.prepareStatement("insert into member values(seq_member.nextval,?,?,?,?,?,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBornYear());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(6, wdate);
			result=pstmt.executeUpdate();
			System.out.println("--입력성공--");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		return result;
	}
	
	public int getLogin(String loginId, String loginPasswd) {
		getConn();
		int result = 0;
		try {
			String sql="select no from member where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPasswd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("no");
			}else {
				result= -1; //비밀번호 없음
			}
			
			System.out.println("--로그인성공--");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--로그인--");
		}
		return result;
		
	}
	
	public MemberDTO getSelectOne(int no) {
		getConn();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select*from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBornYear(rs.getInt("bornYear"));
				dto.setWdate(rs.getTimestamp("wdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return dto;
	}
	
	public ArrayList<MemberDTO> getListAll() {
		getConn();
		ArrayList<MemberDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBornYear(rs.getInt("bornYear"));
				dto.setWdate(rs.getTimestamp("wdate"));
				arr.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}
		return arr;
	}
}
