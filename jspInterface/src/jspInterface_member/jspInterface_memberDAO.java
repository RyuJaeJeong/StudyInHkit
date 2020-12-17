package jspInterface_member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.Db;
import db.DbOracleInput;
import jspInterface_member02.jspInterface_member02DTO;





public class jspInterface_memberDAO {

//field
private Connection conn;
private PreparedStatement pstmt;
private ResultSet rs;

//cons 
public jspInterface_memberDAO() {
	// TODO Auto-generated constructor stub
}

//method
public void getConn() {
	
	/*try {
		String driver ="oracle.jdbc.driver.OracleDriver";		
		String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbId = "jspInterface";
		String dbPasswd = "1234";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
		System.out.println("--오라클 접속 성공 --");
	
	} catch(Exception e) {
		e.printStackTrace();
		System.out.println("--오라클 접속 실패--");
	}*/
	
	Db d1 = new DbOracleInput();
	conn = d1.dbConn();
	
}

public int getSequence() {
	getConn();
	int temp = 0;
	try {
		String sql = "select max(no) from member";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			temp = rs.getInt("max(no)");
		}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("--oracle 접속 실패--");
	}
	
	
		return temp;	
	}

	
	
	public int setInsert(jspInterface_memberDTO dto) {
		int result = 0;
		getConn();
		
		try {
			int temp_ = getSequence();
			int temp = temp_ + 1;
			
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);						
			pstmt.setInt(1, temp);
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
			
			/*
			 *  String sql = "insert into member values((select max(no)+1 as m_no from member a),?,?,?,?,?,?,?,?,now())";
				pstmt = conn.prepareStatement(sql);						
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPasswd());
				pstmt.setString(3, dto.getNme());
				pstmt.setString(4, dto.getSid());
				pstmt.setString(5, dto.getPhone());
				pstmt.setString(6, dto.getEmail());
				pstmt.setString(7, dto.getGender());
			 * 
			 * 쿼리문에 서브쿼리를 써서 해결하는 방법 있고, 위에처럼 메서드를 따로 만드는 방법있다. 
			 * 둘다 오라클, mysql에서 정상동작하는 것을 확인했다.
			 * 
			 * */

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}
		return result;

	}

	public ArrayList<jspInterface_memberDTO> getListAll() {
		getConn();
		ArrayList<jspInterface_memberDTO> arr = new ArrayList<>();
		try {
			String sql = "select*from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jspInterface_memberDTO dto = new jspInterface_memberDTO();
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
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트를 가져오지 못하였습니다.");
		}
		return arr;

	}

	public jspInterface_memberDTO getSelectOne(int no) {
		getConn();
		jspInterface_memberDTO dto = new jspInterface_memberDTO();
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

	public int getUpdate(jspInterface_memberDTO dto) {
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
