package jspInterfaceImplExam.model.resume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;



public class ResumeDAOImplOracle implements ResumeDAO   {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void getConn() {
		
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";		
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "happyNewYear";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공 --");
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
		
	}

	@Override
	public int setInsert(ResumeDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into resume values(seq_resume.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);						
			
			pstmt.setString(1, dto.getUpload_path());
			pstmt.setString(2, dto.getPic_name());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getAddress());
			pstmt.setString(7, dto.getTOEIC());
			pstmt.setString(8, dto.getTOEFL());
			pstmt.setString(9, dto.getJapan());
			pstmt.setString(10, dto.getChina());
			
			pstmt.setString(11, dto.getGigan1());
			pstmt.setString(12, dto.getSchool1());
			pstmt.setString(13, dto.getJeongong1());
			
			pstmt.setString(14, dto.getGigan2());
			pstmt.setString(15, dto.getSchool2());
			pstmt.setString(16, dto.getJeongong2());
			
			pstmt.setString(17, dto.getGigan3());
			pstmt.setString(18, dto.getSchool3());
			pstmt.setString(19, dto.getJeongong3());
			
			pstmt.setString(20, dto.getGigan4());
			pstmt.setString(21, dto.getSchool4());
			pstmt.setString(22, dto.getJeongong4());
			result = pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		
		
		return result;
	}

	@Override
	public ArrayList<ResumeDTO> getListAll() {
		getConn();
		ArrayList<ResumeDTO>arr = new ArrayList<>();
		try {
			String sql ="select*from resume order by no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())	{
				ResumeDTO dto = new ResumeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setUpload_path(rs.getString("upload_path"));
				dto.setPic_name(rs.getString("pic_name"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setTOEIC(rs.getString("TOEIC"));
				dto.setTOEFL(rs.getString("TOEFL"));
				dto.setJapan(rs.getString("japan"));
				dto.setChina(rs.getString("china"));
				
				dto.setGigan1(rs.getString("gigan1"));
				dto.setSchool1(rs.getString("school1"));
				dto.setJeongong1(rs.getString("jeongong1"));
				
				dto.setGigan2(rs.getString("gigan2"));
				dto.setSchool2(rs.getString("school2"));
				dto.setJeongong2(rs.getString("jeongong2"));
				
				dto.setGigan3(rs.getString("gigan3"));
				dto.setSchool3(rs.getString("school3"));
				dto.setJeongong3(rs.getString("jeongong3"));
				
				dto.setGigan4(rs.getString("gigan4"));
				dto.setSchool4(rs.getString("school4"));
				dto.setJeongong4(rs.getString("jeongong4"));
				arr.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("--리스트를 가져오지 못했습니다.--");
		}
		return arr;
		
		
	}

	@Override
	public ResumeDTO getSelectOne(int no) {
		getConn();
		ResumeDTO dto = new ResumeDTO();
		try {
			String sql = "select*from resume where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setUpload_path(rs.getString("upload_path"));
				dto.setPic_name(rs.getString("pic_name"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setTOEIC(rs.getString("TOEIC"));
				dto.setTOEFL(rs.getString("TOEFL"));
				dto.setJapan(rs.getString("japan"));
				dto.setChina(rs.getString("china"));
				
				dto.setGigan1(rs.getString("gigan1"));
				dto.setSchool1(rs.getString("School1"));
				dto.setJeongong1(rs.getString("jeongong1"));
				
				dto.setGigan2(rs.getString("gigan2"));
				dto.setSchool2(rs.getString("School2"));
				dto.setJeongong2(rs.getString("jeongong2"));
				
				dto.setGigan3(rs.getString("gigan3"));
				dto.setSchool3(rs.getString("School3"));
				dto.setJeongong3(rs.getString("jeongong3"));
				
				dto.setGigan4(rs.getString("gigan4"));
				dto.setSchool4(rs.getString("School4"));
				dto.setJeongong4(rs.getString("jeongong4"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상세보기에 실패하였습니다.");
		}
		return dto;
		
	}

	@Override
	public int getUpdate(ResumeDTO dto) {
		getConn();
		int result = 0;
		try {
			String sql = "update resume set upload_path=?,pic_name=? ,name=?, email=?, phone=?, address=?, gigan1=?, school1=?,jeongong1=?,gigan2=?, school2=?,jeongong2=?,"
					+ "gigan3=?,school3=?,jeongong3=?,gigan4=?, school4=?,jeongong4=?,TOEIC=?,TOEFL=?,japan=?,china=? where no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUpload_path());
			pstmt.setString(2, dto.getPic_name());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getAddress());
			
			pstmt.setString(7, dto.getGigan1());
			pstmt.setString(8, dto.getSchool1());
			pstmt.setString(9, dto.getJeongong1());
			
			pstmt.setString(10, dto.getGigan2());
			pstmt.setString(11, dto.getSchool2());
			pstmt.setString(12, dto.getJeongong2());
			
			pstmt.setString(12, dto.getGigan3());
			pstmt.setString(13, dto.getSchool3());
			pstmt.setString(15, dto.getJeongong3());
			
			pstmt.setString(16, dto.getGigan4());
			pstmt.setString(17, dto.getSchool4());
			pstmt.setString(18, dto.getJeongong4());
			
			pstmt.setString(19, dto.getTOEIC());
			pstmt.setString(20, dto.getTOEFL());
			pstmt.setString(21, dto.getJapan());
			pstmt.setString(22, dto.getChina());
			
			pstmt.setInt(23, dto.getNo());
			
			
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
			String sql = "delete from resume where no=? ";
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
