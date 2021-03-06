package makeConnection.model.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import makeConnection.model.member.db.Db;
import makeConnection.model.member.db.DbImplOracle;
import makeConnection.model.member.dto.MemberDTO;



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
	
	public Connection getConn() {
		conn = Db.getConn();
		return conn;
	}
	
	public void getConnClose (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		Db.dbConnClose(rs, pstmt, conn);
	}
	
	public int setInsert(MemberDTO dto) {
		int result = 0;
		conn = getConn();
		try {
			String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,?,?) ";
			System.out.println(dto.getId()+"/"+dto.getPasswd()+"/"+dto.getName()+"/"+dto.getGender()+"/");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setInt(5, dto.getBornYear());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(6, wdate);
			pstmt.setString(7, dto.getPostcode());
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getDetailAddress());
			pstmt.setString(10, dto.getExtraAddress());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력실패--");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<MemberDTO> getSelectAll() {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		conn = getConn();
		try {
			String sql = "select*from member";  //업무에 가면 *보다는 출력할 필드명을 모두 명시해주는 것이 ㅈㅇㄷ좋다. 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBornYear(rs.getInt("bornYear"));
				dto.setRegidate(rs.getString("regidate"));
				arr.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		
		return arr;
		
	}
	
	public MemberDTO goView(int no) {
		conn = getConn();
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "select*from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBornYear(rs.getInt("bornYear"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setPostcode(rs.getString("postcode"));
				dto.setAddress(rs.getString("address"));
				dto.setDetailAddress(rs.getString("detailAddress"));
				dto.setExtraAddress(rs.getString("extraAddress"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("객체를 가져오지 못했습니다.");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	public int getUpdate(MemberDTO dto) {
		getConn();
		int result = 0;
		try {
			
			String sql = "update member set passwd=?,gender=?,bornYear=?,regidate=?,postcode=?,address=?,detailaddress=?,extraaddress=?  where no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getGender());
			pstmt.setInt(3, dto.getBornYear());
			Timestamp wdate = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(4, wdate);
			pstmt.setString(5, dto.getPostcode());
			pstmt.setString(6, dto.getAddress());
			pstmt.setString(7, dto.getDetailAddress());
			pstmt.setString(8, dto.getExtraAddress());
			pstmt.setInt(9, dto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다.");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	public int idCheck(String id) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "select count(*) from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제에 실패하였습니다.");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
}
