package time_morning3;

public class Animal {
	//field �ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	String name;
	int age;
	//cons �ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//method �ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	public void sound () {
		
	}
	
	public void display () {
		System.out.println(name + "/" + age);
	}
	
	
}
