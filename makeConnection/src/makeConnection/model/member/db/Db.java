package makeConnection.model.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Db {
	
	public static Connection getConn() {
		DbImplOracle db = new DbImplOracle();
		return db.getConn();
	}
	
	public static void dbConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		DbImplOracle db = new DbImplOracle();
		db.getConnClose(rs, pstmt, conn);
	}
}
