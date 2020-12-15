package practice;

public class receiptDTO {
	//field
	private String nme1; 
	private String pri1;
	private String nme2;
	private String pri2;
	private String nme3;
	private String pri3;
	//constructor
	public receiptDTO() {
		System.out.println(pri1+pri2+pri3);// TODO Auto-generated constructor stub
	}
	//method
	public int tot() {
		int tot= Integer.parseInt(pri1)+Integer.parseInt(pri2)+Integer.parseInt(pri3);
		return tot;
	}
	
	//getter&setter
	public String getNme1() {
		return nme1;
	}
	public void setNme1(String nme1) {
		this.nme1 = nme1;
	}
	public String getPri1() {
		return pri1;
	}
	public void setPri1(String pri1) {
		this.pri1 = pri1;
	}
	public String getNme2() {
		return nme2;
	}
	public void setNme2(String nme2) {
		this.nme2 = nme2;
	}
	public String getPri2() {
		return pri2;
	}
	public void setPri2(String pri2) {
		this.pri2 = pri2;
	}
	public String getNme3() {
		return nme3;
	}
	public void setNme3(String nme3) {
		this.nme3 = nme3;
	}
	public String getPri3() {
		return pri3;
	}
	public void setPri3(String pri3) {
		this.pri3 = pri3;
	}

	

}
