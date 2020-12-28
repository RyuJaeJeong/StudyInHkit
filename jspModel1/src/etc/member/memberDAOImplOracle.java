package etc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class memberDAOImplOracle implements memberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";		
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "jspmodel01";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공 --");
		
			} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
		// TODO Auto-generated method stub// TODO Auto-generated method stub
		
	}

	@Override
	public int setInsert(memberDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql ="insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,?,'4',sysdate,?,'0')";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getGender());
			pstmt.setString(9, dto.getJob());
			pstmt.setString(10, dto.getIp());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력싪패");
		}
		return result;
	}

	@Override
	public ArrayList<memberDTO> getListAll() {
		getConn();
		ArrayList<memberDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberDTO dto = new memberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setJob(rs.getString("job"));
				dto.setGrade(rs.getString("grade"));
				dto.setRegi_date(rs.getString("regi_date"));
				arr.add(dto);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;
	}

	@Override
	public memberDTO getSelectOne(String cookId) {
		getConn();
		memberDTO dto = new memberDTO();
		try {
			String sql = "select*from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cookId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setJob(rs.getString("job"));
				dto.setGrade(rs.getString("grade"));
				dto.setRegi_date(rs.getString("regi_date"));
				dto.setLoginFailCounter(rs.getInt("loginfailcounter"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인에 실패하였습니다.");
		}
		return dto;
	}

	@Override
	public int getUpdate(memberDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDel(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLogin(String logInId) {
		String passwd = "";
		getConn();
		try {
			String sql ="select passwd from member where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logInId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				passwd = rs.getString("passwd");
			}else {
				passwd = "";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인에 실패하였습니다.");
		}
		return passwd;
	
	}

	@Override
	public void counterPlus(String logInid) {
		getConn();
		try {
			String sql = "update member set loginFailCounter = loginFailCounter+1 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logInid);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("카운터누적에 실패하였습니다.");
		}
		
		
	}

	@Override
	public void counterReset(String logInid) {
		getConn();
		try {
			String sql = "update member set loginFailCounter = 0 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logInid);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("카운터초기화에.");

		}
	}

	
	
	
	
}
