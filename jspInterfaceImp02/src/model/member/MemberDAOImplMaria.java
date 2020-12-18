package model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MemberDAOImplMaria implements MemberDAO  {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void getConn() {
		// TODO Auto-generated method stub
		try {
			String driver = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/jspInterfaceImpl02";
			String dbId = "jspInterfaceImpl02";
			String dbPasswd = "1234";

			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPasswd);
			System.out.println("--mysql 접속 성공 --");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--mysql 접속 실패--");
		}
	}
	
	public void getConnClose() {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}	
			if (conn != null) {conn.close();}	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}

	@Override
	public int setInsert(MemberDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);						
			pstmt.setNull(1, java.sql.Types.NULL);
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getNme());
			pstmt.setString(5, dto.getSid());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getGender());
			int age_ = 0;
			if (dto.getSid().subSequence(6, 7).equals("1") || dto.getSid().subSequence(6, 7).equals("2")) {
				age_ = 2020 - (1900 + Integer.parseInt(dto.getSid().substring(0, 2)));
			} else if (dto.getSid().subSequence(6, 7).equals("3") || dto.getSid().subSequence(6, 7).equals("4")) {
				age_ = 20 - Integer.parseInt(dto.getSid().substring(0, 2));
			}

			String age = Integer.toString(age_);

			pstmt.setString(9, age);
			Timestamp wdate = new Timestamp(System.currentTimeMillis());		//timestamp 라는 클래스를 임포트 해서 쓴다. 
			pstmt.setTimestamp(10, wdate);
			
			result = pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		// TODO Auto-generated method stub
		return result;
	}
	
	

	@Override
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
				dto.setNme(rs.getString("name"));
				dto.setSid(rs.getString("sid"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getString("age"));
				dto.setWdate(rs.getTimestamp("wdate"));
				arr.add(dto);
			}
				getConnClose();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;

		
	}

	@Override
	public MemberDTO getSelectOne(int no) {
		getConn();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select*from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setNme(rs.getString("name"));
				dto.setSid(rs.getString("sid"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getString("age"));
				dto.setWdate(rs.getTimestamp("wdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상세보기에 실패하였습니다.");
		}
		return dto;
	}

	@Override
	public int getUpdate(MemberDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "update member set id=?, passwd=?,name=?,sid=?, phone=?, email=?, gender=?, age=? where no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getNme());
			pstmt.setString(4, dto.getSid());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getAge());
			pstmt.setInt(9, dto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
	}

	@Override
	public int getDel(int no) {
		getConn();
		int result = 0;
		try {
			String sql = "delete from member where no=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
		
		
	}

	}


