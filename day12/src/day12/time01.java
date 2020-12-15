package day12;

public class time01 {
	//Member Field
	private String name;
	private int height;
	private int weight;
	
	//Constructor - overloading : 생성자가 하는 일은 객체 초기화. 
	
	
	public time01() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public time01(String name) {
		super();
		this.name = name;
	}

	

	

	public time01(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}



	public time01(String name, int height, int weight) {

		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	//method
	
	public void disp() {
		System.out.println(name+"/"+height+"/"+weight);
	}
	
	//getter&setter

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

	
	
	
}
