package etc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;



public class MemberDAO {

	//field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//cons
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	//method
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";		
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "jspR2jExam";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공 --");
		
			} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public int setInsert(MemberDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql ="insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,?,'4',?,'0',?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getSid1());
			pstmt.setString(5, dto.getSid2());
			pstmt.setString(6, dto.getNickname());
			pstmt.setString(7, dto.getPhone());
			pstmt.setString(8, dto.getGender());
			pstmt.setString(9, dto.getAge());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(10, wdate);
			pstmt.setString(11, dto.getIp());
			result = pstmt.executeUpdate();
			System.out.println("입력성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력싪패");
		}
		return result;
	}
	
	public ArrayList<MemberDTO> getListAll() {
		getConn();
		ArrayList<MemberDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setSid1(rs.getString("sid1"));
				dto.setSid2(rs.getString("sid2"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getString("age"));
				dto.setGrade(rs.getString("grade"));
				dto.setWdate(rs.getTimestamp("wdate"));
				dto.setLoginFailCounter(rs.getInt("loginFailCounter"));
				dto.setIp(rs.getString("ip"));
				arr.add(dto);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;
	}
	
	public MemberDTO getSelectOne(String id) {
		getConn();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select*from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setSid1(rs.getString("sid1"));
				dto.setSid2(rs.getString("sid2"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPhone(rs.getString("phone"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getString("age"));
				dto.setGrade(rs.getString("grade"));
				dto.setWdate(rs.getTimestamp("wdate"));
				dto.setLoginFailCounter(rs.getInt("loginFailCounter"));
				dto.setIp(rs.getString("ip"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인에 실패하였습니다.");
		}
		return dto;
	}

	public int getUpdate(MemberDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "update member set passwd=?,name=?,sid1=?,sid2=?,nickname=? ,phone=?, gender=?, age=?,wdate=?,ip=? where id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSid1());
			pstmt.setString(4, dto.getSid2());
			pstmt.setString(5, dto.getNickname());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getAge());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(9, wdate);
			pstmt.setString(10, dto.getIp());
			pstmt.setString(11, dto.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
	}
	
	public int getDel(String id) {
		
		getConn();
		int result = 0;
		try {
			String sql = "delete from member where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제에 실패하였습니다.");
		}
		return result;
		
		
	}
	
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


	
	
}
