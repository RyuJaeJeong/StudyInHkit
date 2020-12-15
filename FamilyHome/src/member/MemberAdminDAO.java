package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberAdminDAO {

//field
private Connection conn;
private PreparedStatement pstmt;
private ResultSet rs;

//cons
public MemberAdminDAO() {
	// TODO Auto-generated constructor stub
}


//method
public void getConn() {
	try {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String dburl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbId = "jspTest";
		String dbPasswd = "1234";
		
		Class.forName(driver); //jdbc 드라이버 로딩
		conn = DriverManager.getConnection(dburl,dbId,dbPasswd);
		System.out.println("--오라클 접속 성공 --");
		
		
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("--오라클 접속 실패--");
	}
	
	
	
}


public int setInsert(MemberAdminDTO dto) {
	int result = 0;
	getConn();
	try {
		String sql = "insert into family values(fnum.nextval,?,?,?,?)";
		pstmt= conn.prepareStatement(sql);
		pstmt.setString(1, dto.getNme());
		pstmt.setString(2, dto.getId());
		pstmt.setString(3, dto.getPass());
		pstmt.setString(4, dto.getPassck());
		result = pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("입력실패");
	}
	return result;
}

public void logIn(String id) {
	
}
















}
