package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DbExample;
import model.board.dto.BoardDTO;
import shop.model.dto.ProductDTO;

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
			conn = getConn();
			int result = 0;
			try {
				String sql = "insert into " + tableName01 + " values(seq_product.nextval,?,?,?,?,CURRENT_TIMESTAMP)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getPrice());
				pstmt.setString(3, dto.getDescription());
				pstmt.setString(4, dto.getProduct_img());
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				getConnClose(rs, pstmt, conn);
			}
			return result;
		}
		
		public int totalRecord() {
			int result = 0; 
			conn = getConn();
			try {
				String sql = "select count(*) from " + tableName01;
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
		
		public ArrayList<ProductDTO> getListAll(int startRecord, int lastRecord) {
			 ArrayList<ProductDTO> arr = new ArrayList<>();
			 conn = getConn();
			 try {
					String basicSql = "";
					basicSql += "select no, name, price, description, product_img, regi_date, ";
					basicSql += "(select count(*) from cart group by productno having product.no = cart.productno) as buy_count ";
					basicSql += "from product";
					System.out.println(basicSql);
					String sql = "";
					sql += "select*from(select A.*, Rownum Rnum from (" + basicSql +")A)";
					sql += "where Rnum>= ? and Rnum <= ?";
					int k = 1;
					
					System.out.println("sql : " + sql);
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(k++, startRecord);
					pstmt.setInt(k++, lastRecord);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						ProductDTO dto = new ProductDTO();
						dto.setNo(rs.getInt("no"));
						dto.setName(rs.getString("name"));
						dto.setPrice(rs.getInt("price"));
						dto.setDescription(rs.getString("description"));
						dto.setProduct_img(rs.getString("product_img"));
						dto.setRegi_date(rs.getTimestamp("regi_date"));
						dto.setBuy_count(rs.getInt("buy_count"));
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
		
		public ProductDTO getView(int no) {
			conn = getConn();
			ProductDTO dto = new ProductDTO();
			try {
				String sql = "";
				sql += "select * from ";
				sql += "(";
				sql += "select b.*, ";
				sql += "LAG(no) OVER (ORDER BY regi_date desc) preNo, ";
				sql += "LAG(name) OVER (ORDER BY regi_date desc) preName, ";
				sql += "LEAD(no) OVER (ORDER BY regi_date desc) nxtNo, ";
				sql += "LEAD(name) OVER (ORDER BY regi_date desc) nxtName ";
				sql += "from "+ tableName01 +" b order by regi_date desc ";
				sql += ") where no = ? ";
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto.setNo(rs.getInt("no"));
					dto.setName(rs.getString("name"));
					dto.setPrice(rs.getInt("price"));
					dto.setDescription(rs.getString("description"));
					dto.setProduct_img(rs.getString("product_img"));
					dto.setRegi_date(rs.getTimestamp("regi_date"));
					dto.setPreNo(rs.getInt("preNo"));
					dto.setNxtNo(rs.getInt("nxtNo"));
					dto.setPreName(rs.getString("preName"));
					dto.setNxtName(rs.getString("nxtName"));
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("연결 실패");
			}finally {
				getConnClose(rs, pstmt, conn);
			}
			return dto;
		}
		
		public int setUpdate(ProductDTO dto) {
			conn = getConn();
			int result = 0;
			try {
				String sql = "";
				sql += "update " + tableName01 + " set name = ?, price = ?, description = ?, product_img = ? where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getPrice());
				pstmt.setString(3, dto.getDescription());
				pstmt.setString(4, dto.getProduct_img());
				pstmt.setInt(5, dto.getNo());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				getConnClose(rs, pstmt, conn);
			}
			return result;
		}
		
		public int getDelete(int no) {
			conn = getConn();
			int result = 0;
			try {
				String sql = "";
				sql += "delete from " + tableName01 + " where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				getConnClose(rs, pstmt, conn);
			}
			return result;
		}
}
