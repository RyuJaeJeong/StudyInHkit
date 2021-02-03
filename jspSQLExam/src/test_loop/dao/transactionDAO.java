package test_loop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

import src.db.Db;
import src.db.DbImplOracle;

public class transactionDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public transactionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void getConn() {
		try {
			Db d1 = new DbImplOracle();
			conn = d1.dbConn();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("--오라클 접속 실패--");
		}
	}
	
	public void insert() {
		getConn();
		try {
			
			long start_time = System.currentTimeMillis();
			conn.setAutoCommit(false);  //자동커밋해제
			
			for(int i=1; i<=100000; i++) {
				
				String sql = "insert into transactionTBL values(?,?,CURRENT_TIMESTAMP)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, "N"+i);
				pstmt.executeUpdate();
				pstmt.close();
			}
			
			
			System.out.println("--입력 성공--");
			conn.commit();
			conn.setAutoCommit(true);  //자동커밋설정
			long end_time = System.currentTimeMillis();
			System.out.println("시작시간 : "+start_time+"종료시간 : "+end_time);	
			System.out.println(end_time-start_time);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력 실패--");
		}
	}
	
	public void insertBatch() {
		getConn();
		try {
			long start_time = System.currentTimeMillis();
			conn.setAutoCommit(false);  //자동커밋해제
			for(int i=1; i<=100000; i++) {
				String sql = "insert into transactionTBL values(?,?,CURRENT_TIMESTAMP)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, "N"+i);
				pstmt.addBatch();
				
			}
			pstmt.executeBatch();
			conn.commit();
			System.out.println("--입력 성공--");
			conn.setAutoCommit(true);  //자동커밋설정
			long end_time = System.currentTimeMillis();
			System.out.println("시작시간 : "+start_time+"종료시간 : "+end_time);	
			System.out.println(end_time-start_time);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("--입력 실패--");
		}
	}

}
