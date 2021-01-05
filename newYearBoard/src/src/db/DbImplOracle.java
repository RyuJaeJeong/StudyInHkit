package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbImplOracle implements Db {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Connection dbConn() {
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
			System.out.println("--오라클 접속 실패1--");
		}
		return conn;
	}

	@Override
	public void dbConnClose() {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}	
			if (conn != null) {conn.close();}	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	

}
