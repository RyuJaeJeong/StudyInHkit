package member_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class joinMemberDAO {

//Field
private Connection conn;
private PreparedStatement pstmt;
private ResultSet rs;

//cons
public joinMemberDAO() {
	// TODO Auto-generated constructor stub
}


//method

public void getConn() {
	try {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbId = "jspTest2";
		String dbPasswd = "1234";
		
		
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId,dbPasswd);
		System.out.println("--오라클 접속 성공 --");
		
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("--오라클 접속 실패--");
	}
}

public int setInsert(joinMemberDTO dto){
	int result = 0;
	getConn();
	try {
		String sql ="insert into member(no, id, passwd, name, phone, email, birthYear) values(seq_01.nextval, ?, ?, ? ,? ,? ,? )";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getNme());
		pstmt.setString(4, dto.getPhone());
		pstmt.setString(5, dto.getEmail());
		pstmt.setString(6, dto.getBirthYear());
		
		result = pstmt.executeUpdate();
		
	}	catch(Exception e) {
		e.printStackTrace();
		System.out.println("--오라클 접속 실패--");
	}
	
	return result;

}

public ArrayList<joinMemberDTO> getListAll() {
	ArrayList<joinMemberDTO> arr = new ArrayList<>();
	getConn();
	try {
		String sql = "select*from member";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			joinMemberDTO dto = new joinMemberDTO();
			dto.setNo(rs.getString("no"));
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("passwd"));
			dto.setNme(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setBirthYear(rs.getString("birthYear"));
			arr.add(dto);
			
		}
		if(rs != null) {rs.close();}
		if(pstmt != null) {pstmt.close();}
		
	}	catch(Exception e) {
		e.printStackTrace();
		System.out.println("--오라클 접속 실패--");
	}
	return arr;
}



	
}
