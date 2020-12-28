package db;

public class HumanDTO {
	private String aptId;
	private String security;
	private String light;
	private String aircondition;
	private String tv;
	private String cucu;
	
	public HumanDTO(String aptId, String security, String light, String aircondition, String tv, String cucu ) {
		this.aptId = aptId;
		this.security = security;
		this.light = light;
		this.aircondition = aircondition;
		this.tv = tv;
		this.cucu = cucu;
		
		
		// TODO Auto-generated constructor stub
	}

	public String getAptId() {
		return aptId;
	}

	public void setAptId(String aptId) {
		this.aptId = aptId;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		security = security;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getAircondition() {
		return aircondition;
	}

	public void setAircondition(String aircondition) {
		this.aircondition = aircondition;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getCucu() {
		return cucu;
	}

	public void setCucu(String cucu) {
		cucu = cucu;
	}
	
	
	
	
}
