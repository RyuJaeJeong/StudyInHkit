package shop.model.dto;

import java.sql.Timestamp;

/**
 * @author R2j
 *
 */
public class ProductDTO {
	
	   //field	
	   private int no;
	   private String name;
	   private int price;
	   private String description;
	   private String product_img;
	   private Timestamp regi_date;
	   
	   private String preName;
	   private String nxtName;
	   private int preNo;
	   private int nxtNo;
	   
	   private int buy_count;
	   
	   //constructor
	   public ProductDTO() {
		// TODO Auto-generated constructor stub
	   }
	   
	   
	   //getter&setter
		public int getNo() {
			return no;
		}
	
		public void setNo(int no) {
			this.no = no;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public int getPrice() {
			return price;
		}
	
		public void setPrice(int price) {
			this.price = price;
		}
	
		public String getDescription() {
			return description;
		}
	
		public void setDescription(String description) {
			this.description = description;
		}
	
		public String getProduct_img() {
			return product_img;
		}
	
		public void setProduct_img(String product_img) {
			this.product_img = product_img;
		}
	
		public Timestamp getRegi_date() {
			return regi_date;
		}
	
		public void setRegi_date(Timestamp regi_date) {
			this.regi_date = regi_date;
		}


		public String getPreName() {
			return preName;
		}


		public void setPreName(String preName) {
			this.preName = preName;
		}


		public String getNxtName() {
			return nxtName;
		}


		public void setNxtName(String nxtName) {
			this.nxtName = nxtName;
		}


		public int getPreNo() {
			return preNo;
		}


		public void setPreNo(int preNo) {
			this.preNo = preNo;
		}


		public int getNxtNo() {
			return nxtNo;
		}


		public void setNxtNo(int nxtNo) {
			this.nxtNo = nxtNo;
		}


		public int getBuy_count() {
			return buy_count;
		}


		public void setBuy_count(int buy_count) {
			this.buy_count = buy_count;
		}
	   
	   
	   
	   

}
