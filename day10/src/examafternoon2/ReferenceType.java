 package examafternoon2;

class Dog {
	String petName;
	int petAge;
	
	public Dog(String petName, int petAge) {
		this.petName = petName;
		this.petAge = petAge;
	}
}

class Temp {
	//field
	String name;
	int age;
	Dog dog; //�����ڷ���, Ŭ���� Ÿ���� �ڷ���
	
	
	//constructor
	public Temp(String name, int age, Dog dog) {
		this.name = name;
		this.age = age;
		this.dog = dog;
	}
	//Method
	public void display () {
		System.out.printf("%s,%d,%s,%d",name, age, dog.petName, dog.petAge);
	}
	
	
	
	
	
	
	
}












public class ReferenceType {

	public static void main(String[] args) {
		Dog dog1 = new Dog("�ٵ���", 3);
		Temp t1 = new Temp("������",26,dog1);
		t1.display();
		
	}

}
