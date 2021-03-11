package shop.mall.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import db.DbExample;
import shop.mall.model.dto.MallDTO;
import shop.model.dto.ProductDTO;

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
			conn = getConn();
			int result = 0;
			try {
				String sql = "insert into " + tableName02 + " values(seq_cart.nextval,?,?,?,CURRENT_TIMESTAMP)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getMemberNo());
				pstmt.setInt(2, dto.getProductNo());
				pstmt.setInt(3, dto.getAmount());
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				getConnClose(rs, pstmt, conn);
			}
			return result;
		}
		
		public int totalRecord(int memberNo) {
			int result = 0; 
			conn = getConn();
			try {
				String sql = "select count(*) from " + tableName02 + " where memberNo = ?";
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memberNo);
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
		
		public ArrayList<MallDTO> getListAll(int memberNo, int startRecord, int lastRecord) {
			 ArrayList<MallDTO> arr = new ArrayList<>();
			 conn = getConn();
			 try {
					String basicSql = "";
					basicSql += "select c.no, c.memberNo, c.productNo, c.amount, c.regi_date, p.name, p.price, p.description, p.product_img, (c.amount*p.price) buy_money ";
					basicSql += "from product p left outer join cart c ";
					basicSql += "on p.no = c.productNo ";
					basicSql += "where c.memberNo = ?";
					
					String sql = "";
					sql += "select*from(select A.*, Rownum Rnum from (" + basicSql +")A)";
					sql += "where Rnum>= ? and Rnum <= ?";
					
					pstmt = conn.prepareStatement(sql);
					System.out.println(sql);
					pstmt.setInt(1, memberNo);
					pstmt.setInt(2, startRecord);
					pstmt.setInt(3, lastRecord);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						MallDTO dto = new MallDTO();
						dto.setNo(rs.getInt("no"));
						dto.setMemberNo(rs.getInt("memberNo"));
						dto.setProductNo(rs.getInt("productNo"));
						dto.setAmount(rs.getInt("amount"));
						dto.setRegi_date(rs.getTimestamp("regi_date"));
						
						dto.setProduct_name(rs.getString("name"));
						dto.setProduct_price(rs.getInt("price"));
						dto.setProduct_description(rs.getString("description"));
						dto.setProduct_img(rs.getString("product_img"));
						
						dto.setBuy_money(rs.getInt("buy_money"));
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

		public boolean setDeleteBatch(String[] array) {
			int [] count = new int[array.length];
			conn = getConn();
			try {
				conn.setAutoCommit(false);
				String sql = "delete from cart where no = ?";
				pstmt = conn.prepareStatement(sql);
				
				for (int i = 0; i < count.length; i++) {
					if(array[i].equals("on")) {
						continue;
					}
					pstmt.setInt(1, Integer.parseInt(array[i]));
					pstmt.addBatch();
				}
				
				count = pstmt.executeBatch();
				conn.commit();
			}catch (Exception e) {
				System.out.println("삭제실패");
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}finally {
				try {
					conn.setAutoCommit(true);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			boolean result = true;
			for (int i = 0; i < count.length; i++) {
				System.out.println(i + ", " + count[i]);
				if(count[i] != -2) {
					result = false;
					break;
				}
			}
			return false;
		}

		public ArrayList<MallDTO> getListCartProductGroup() {
			ArrayList<MallDTO> list = new ArrayList<>();
			conn = getConn();
			try {
				String sql = "";
				sql += "select p.name product_name, sum(c.amount * p.price)buy_money ";
				sql += " from cart c inner join product p on c.productNo = p.no ";
				sql += "group by p.name ";
				sql += "order by product_name asc ";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MallDTO dto = new MallDTO();
					dto.setProduct_name(rs.getString("product_name"));
					dto.setBuy_money(rs.getInt("buy_money"));
					list.add(dto);
					System.out.println(dto.getProduct_name()+" / "+dto.getBuy_money());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				getConnClose(rs, pstmt, conn);
			}
			return list;
		}
}
