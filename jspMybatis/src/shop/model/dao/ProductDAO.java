package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import db.DbExample;
import shop.model.dto.ProductDTO;
import sqlmap.MybatisManager;




public class ProductDAO {

	   Connection conn;
	   PreparedStatement pstmt;
	   ResultSet rs;
	   
	   String tableName01 = "product";
	   String tableName02 = "cart";
	   
	   public ProductDAO() {
		// TODO Auto-generated constructor stub
	   }
	   
	   public Connection getConn() {
			conn = DbExample.dbConn();
			return conn;
		}
		
		public void getConnClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
			DbExample.dbConnClose(rs, pstmt, conn);
		}
	   
		
		public int setInsert(ProductDTO dto) {
			Map<String, Object> map = new HashMap<>();
			map.put("dto", dto);
			SqlSession session = MybatisManager.getInstance().openSession();
			int result = session.insert("product.setInsert", map);
			session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
			session.close();
			return result;
		}
		
		public int totalRecord() {
			Map<String, String> map = new HashMap<>();
			map.put("tableName01", tableName01);
			SqlSession session = MybatisManager.getInstance().openSession();
			int result = session.selectOne("product.totalRecord", map);
			session.close();
			return result;
			
		}
		
		public List<ProductDTO> getListAll(int startRecord, int lastRecord) {
				Map<String, String> map = new HashMap<>();
				map.put("startRecord", startRecord + "");
				map.put("lastRecord", lastRecord + "");
				map.put("tableName01", tableName01);
				
				SqlSession session = MybatisManager.getInstance().openSession();
				List<ProductDTO> arr = session.selectList("product.getListAll", map);
				session.close();
				return arr;
		}
		
		public ProductDTO getView(int no) {
			Map<String, String> map = new HashMap<>();
			map.put("no", no + "");
			map.put("tableName01", tableName01);
			SqlSession session = MybatisManager.getInstance().openSession();
			ProductDTO dto = session.selectOne("product.getView", map);
			session.close();
			return dto;
		}
		
		public int setUpdate(ProductDTO dto) {
			Map<String, Object> map = new HashMap<>();
			map.put("dto", dto);
			SqlSession session = MybatisManager.getInstance().openSession();
			int result = session.insert("product.setUpdate", map);
			session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
			session.close();
			return result;
		}
		
		public int getDelete(int no) {
			Map<String, String> map = new HashMap<>();
			map.put("no", no + "");
			SqlSession session = MybatisManager.getInstance().openSession();
			int result = session.insert("product.getDelete", map);
			session.commit();	//insert 이기때문에 커밋을 해준다. mybatis 는 오토커밋 지원 안한다.
			session.close();
			return result;
			
		}
}
