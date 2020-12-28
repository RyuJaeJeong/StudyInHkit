package jspInterfaceExam.model.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class MemberDAOImplOracle implements MemberDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void getConn() {
		
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";		
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "jspInterfaceExam";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공 --");
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
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
		getConn();
		int result = 0;
		
		try {
			String sql = "insert into member values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);						
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNme());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getJob());
					
			result = pstmt.executeUpdate();
			getConnClose();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		
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
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setNme(rs.getString("nme"));
				dto.setPhone(rs.getString("phone"));
				dto.setJob(rs.getString("job"));
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
	public MemberDTO getSelectOne(String id) {
		
		getConn();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select*from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setNme(rs.getString("nme"));
				dto.setPhone(rs.getString("phone"));
				dto.setJob(rs.getString("job"));
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
			String sql = "update member set pwd=?,nme=?, phone=?, job=? where id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getNme());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getJob());
			pstmt.setString(5, dto.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
		
	}

	@Override
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
			System.out.println("수정에 실패하였습니다.");
		}
		return result;
		
	}

}
