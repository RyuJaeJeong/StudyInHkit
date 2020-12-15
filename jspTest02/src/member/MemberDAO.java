package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MemberDAO { //Data Access Object
	//Field
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//Constructor
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	//getter&setter
	
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

	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getPasscheck());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getNme());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getBirthYear());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력실패");
		}
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll() {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		getConn();
		
		
	try {
			String sql = "select*from member";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("passwd"));
				dto.setNme(rs.getString("nme"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("mail"));
				dto.setBirthYear(rs.getString("birth"));
				arr.add(dto);
			}
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
	}catch(Exception e) {
						e.printStackTrace();
						System.out.println("입력실패");
	}
		return arr;
	}
	
	public MemberDTO view(String id) {
		MemberDTO dto = new MemberDTO();
		getConn();
		
		try{
			String sql = "select*from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("passwd"));
				dto.setNme(rs.getString("nme"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("mail"));
				dto.setBirthYear(rs.getString("birth"));
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
		return dto;
		 	
		
	};
	
	public int modify(MemberDTO dto) {
		int result = 0;
		getConn();
		try{
			System.out.println(dto.getPass()+dto.getEmail());
			String sql = "update member set passwd=?, mail=?, nme=?, phone=?, birth=? where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPass());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getNme());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getBirthYear());
			pstmt.setString(6, dto.getId());
			result = pstmt.executeUpdate();
				
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
		return result;
		
	}
	
	public int delete(String id) {
		int result = 0;
		getConn();
		try{
			String sql = "delete member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
		return result;
		
	}
	
}
