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
	Dog dog; //참조자료형, 클래스 타입의 자료형
	
	
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
		Dog dog1 = new Dog("바둑이", 3);
		Temp t1 = new Temp("류재정",26,dog1);
		t1.display();
		
	}

}
