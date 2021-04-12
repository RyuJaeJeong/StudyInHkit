package mall.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import db.DbExample;
import mall.model.dto.MallDTO;
import shop.model.dto.ProductDTO;
import sqlmap.MybatisManager;

public class MallDAO {

	//field
	   Connection conn;
	   PreparedStatement pstmt;
	   ResultSet rs;
	   
	   String tableName01 = "product";
	   String tableName02 = "cart";
	//cons
	   
	   public MallDAO() {
		// TODO Auto-generated constructor stub
	   }
	   
	//method
	   
	   public Connection getConn() {
			conn = DbExample.dbConn();
			return conn;
		}
		
		public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
			DbExample.dbConnClose(rs, pstmt, conn);
		}
		
		public int setInsert(MallDTO dto) {
			Map<String, Object> map = new HashMap<>();
			map.put("dto", dto);
			SqlSession session = MybatisManager.getInstance().openSession();
			int result = session.insert("mall.setInsert", map);
			session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
			session.close();
			return result;
		}
		
		public int totalRecord(int memberNo) {
			Map<String, String> map = new HashMap<>();
			map.put("memberNo", memberNo + "");
			SqlSession session = MybatisManager.getInstance().openSession();
			int result = session.selectOne("mall.totalRecord", map);
			session.close();
			return result;
		}
		
		public List<MallDTO> getListAll(int memberNo, int startRecord, int lastRecord) {
			Map<String, String> map = new HashMap<>();
			map.put("startRecord", startRecord + "");
			map.put("lastRecord", lastRecord + "");
			map.put("memberNo", memberNo  + "");
			
			SqlSession session = MybatisManager.getInstance().openSession();
			List<MallDTO> arr = session.selectList("mall.getListAll", map);
			session.close();
			return arr;
		}

		public void setDeleteBatch(String[] array) {
			Map<String, Object> map = new HashMap<>();
			map.put("array", array);
			
			SqlSession session = MybatisManager.getInstance().openSession();
			session.delete("mall.setDeleteBatch", map);
			session.commit();
			session.close();
			
		}

		public List<MallDTO> getListCartProductGroup() {
			SqlSession session = MybatisManager.getInstance().openSession();
			List<MallDTO> arr = session.selectList("mall.getListCartProductGroup");
			session.close();
			return arr;
		}
}
