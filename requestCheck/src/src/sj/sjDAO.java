package src.sj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class sjDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConn() {
		try {
			String driver ="oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbId = "happyNewYear";
			String dbPasswd = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbId,dbPasswd);
			System.out.println("--오라클 접속 성공--");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	//method
	public int setInsert(sjDTO dto) {
		int result = 0;
		getConn();
		try {
			String sql = "insert into sj values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNme());
			pstmt.setString(2, dto.getsNme());
			pstmt.setInt(3, dto.getMun_1());
			pstmt.setInt(4, dto.getMun_2());
			pstmt.setInt(5, dto.getMun_3());
			pstmt.setInt(6, dto.getMun_4());
			pstmt.setInt(7, dto.getMun_5());
			pstmt.setString(8, dto.getMun_ox_1());
			pstmt.setString(9, dto.getMun_ox_2());
			pstmt.setString(10, dto.getMun_ox_3());
			pstmt.setString(11, dto.getMun_ox_4());
			pstmt.setString(12, dto.getMun_ox_5());
			pstmt.setInt(13, dto.getJumsu());
			result = pstmt.executeUpdate();
			System.out.println("입력성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력실패");
		}
		return result;
	}


	public ArrayList<sjDTO> getListAll() {
		ArrayList<sjDTO> arr = new ArrayList<>();
		getConn();
		try {
			String sql = "select*from sj";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sjDTO dto = new sjDTO();
				dto.setNme(rs.getString("nme"));
				dto.setsNme(rs.getString("sNme"));
				dto.setMun_1(rs.getInt("mun_1"));
				dto.setMun_2(rs.getInt("mun_2"));
				dto.setMun_3(rs.getInt("mun_3"));
				dto.setMun_4(rs.getInt("mun_4"));
				dto.setMun_5(rs.getInt("mun_5"));
				dto.setMun_ox_1(rs.getString("mun_ox_1"));
				dto.setMun_ox_2(rs.getString("mun_ox_2"));
				dto.setMun_ox_3(rs.getString("mun_ox_3"));
				dto.setMun_ox_4(rs.getString("mun_ox_4"));
				dto.setMun_ox_5(rs.getString("mun_ox_5"));
				dto.setJumsu(rs.getInt("jumsu"));
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
	
}
