package CRM.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import CRM.model.dto.ClientDTO;


public class ClientDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName01 = "client";
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "jspTest2";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();};
			if(conn != null) {conn.close();};
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public int setInsert(ClientDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "";
			sql += "insert into ";
			sql += tableName01;
			sql += " (no, name, bornYear, email) ";
			sql += "values (seq_client.nextval,?,to_timestamp(?),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBornYear());
			pstmt.setString(3, dto.getEmail());
			result = pstmt.executeUpdate();
			System.out.println("입력 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 실패");
		}
		return result;
	}

	public int totalRecord() {
		int result = 0; 
		getConn();
		try {
			String sql = "select count(*) from " + tableName01 + " ";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return result;
	}
	
	
	public List<ClientDTO> getListAll(int startRecord, int lastRecord) {
		List<ClientDTO> arr =  new ArrayList<ClientDTO>();
		getConn();
		try {
			String basicSql = "";
			basicSql += "select t1.* "; 
			basicSql += "from " + tableName01 + " t1 ";
			basicSql += "order by no desc ";
			
			String sql = "";
			sql += "select*from(select A.*, Rownum Rnum from (" + basicSql +")A)";
			sql += "where Rnum>= ? and Rnum <= ?";
			
			int k = 1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(k++, startRecord);
			pstmt.setInt(k++, lastRecord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClientDTO dto = new ClientDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setBornYear(rs.getString("bornYear"));
				dto.setEmail(rs.getString("email"));		
				arr.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return arr;
	}
	
	public List<ClientDTO> getListAll() {
		List<ClientDTO> arr =  new ArrayList<ClientDTO>();
		getConn();
		try {
			String basicSql = "";
			basicSql += "select t1.* "; 
			basicSql += "from " + tableName01 + " t1 ";
			basicSql += "order by no desc ";
			pstmt = conn.prepareStatement(basicSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClientDTO dto = new ClientDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setBornYear(rs.getString("bornYear"));
				dto.setEmail(rs.getString("email"));		
				arr.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		return arr;
	}

	public List<ClientDTO> getTodayAll() {
		List<ClientDTO> arr =  new ArrayList<ClientDTO>();
		getConn();
		try {
			String basicSql = "";
			basicSql += "select t1.* "; 
			basicSql += "from " + tableName01 + " t1 ";
			basicSql += "where TO_CHAR(bornYear, 'MM/DD') = TO_CHAR(sysdate, 'MM/DD') ";
			basicSql += "order by no desc ";
			System.out.println("basicSql : " + basicSql);
			pstmt = conn.prepareStatement(basicSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("1");
				ClientDTO dto = new ClientDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setBornYear(rs.getString("bornYear"));
				dto.setEmail(rs.getString("email"));		
				arr.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}finally {
			getConnClose(rs, pstmt, conn);
		}
		System.out.println(arr);
		return arr;
	}
	
}
