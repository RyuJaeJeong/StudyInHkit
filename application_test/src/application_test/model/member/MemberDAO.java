package application_test.model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "sihum";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public String getLogin(MemberDTO dto) {
		getConn();
		String result = "";
		try {
			String sql="select months_between(sysdate, changedate) from member where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;
		
	}
	
	public int getUpdate(MemberDTO dto) {
		int result=0;
		getConn();
		try {
			
			String sql="update member set passwd=?,changeDate=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(2, wdate);
			pstmt.setString(3, dto.getId());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
}
