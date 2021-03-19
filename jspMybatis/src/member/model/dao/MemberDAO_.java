package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.DbExample;
import member.model.dto.MemberDTO;


public class MemberDAO_ {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConn() {
		conn = DbExample.dbConn();
		return conn;
	}
	
	public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		DbExample.dbConnClose(rs, pstmt, conn);
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
	
	public MemberDTO getLogin(MemberDTO dto) {
		conn = getConn();
		MemberDTO resultdto = new MemberDTO();
		try {
			String sql="select no, id, name from member where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultdto.setNo(rs.getInt("no"));
				resultdto.setId(rs.getString("id"));
				resultdto.setName(rs.getString("name"));
			}else {
				resultdto.setNo(0);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--로그인처리 실패--");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return resultdto;
		
	}
	
	public ArrayList<MemberDTO> getListAll(int startRecord, int lastRecord, String search_option, String search_data) {
		ArrayList<MemberDTO> arr = new ArrayList<>();
		conn = getConn();
		try {
			String basicSql = "";  //업무에 가면 *보다는 출력할 필드명을 모두 명시해주는 것이 ㅈㅇㄷ좋다. 
			basicSql += "select*from member where no>? ";
			
			
			if(search_option.length()>0 && search_data.length()>0) {
				basicSql += " and " + search_option + " like ? ";
			}
			
			basicSql += "order by id desc ";
			
			String sql = "";
			sql += "select*from(select A.*, Rownum Rnum from ("+ basicSql + ")A)";
			sql += "where Rnum>= ? and Rnum <= ?";
			
			int k = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++k, 0);
			if(search_option.length()>0 && search_data.length()>0) {
				pstmt.setString(++k, "%"+search_data+"%");
			}
			
			pstmt.setInt(++k, startRecord);
			pstmt.setInt(++k, lastRecord);
			
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBornYear(rs.getInt("bornYear"));
				dto.setRegiDate(rs.getTimestamp("regidate"));
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
				dto.setRegiDate(rs.getTimestamp("regidate"));
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
				dto.setRegiDate(rs.getTimestamp("regidate"));
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
	
	public int getDelete(int no) {
		getConn();
		int result = 0;
		try {
			
			String sql = "delete from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제에 실패하였습니다.");
		} finally {
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
	
	public int getTotalRecord() {
		conn = getConn();
		int result = 0;
		try {
			String sql = "select count(*) from member where no > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제에 실패하였습니다.");
		} finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}

	
	
	public String spCharacter(String something) {
		
		
		something = something.replace("<", "&lt;");	//특수문자 치환 처리.!
		something = something.replace(">", "&gt;");
		something = something.replace("&", "&amp;");
		something = something.replace("\"", "&quot;");
		something = something.replace("'", "&apos;");
		
		
		
		return something;
		
		
		
	}

	public int getTotalRecord(String search_option, String search_data) {
		conn = getConn();
		int result = 0;
		try {
			String sql = "";
			sql += "select count(*) from member where no > ?";
			if(search_option.length()>0 && search_data.length()>0) {
				sql += " and " + search_option + " like ? ";
			}		
					
			int k = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++k, 0);
			
			if(search_option.length()>0 && search_data.length()>0) {
				pstmt.setString(++k, "%"+search_data+"%");
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제에 실패하였습니다.");
		} finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	
	
	
}
