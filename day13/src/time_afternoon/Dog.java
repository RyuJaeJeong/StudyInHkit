package time_afternoon;

public class Dog extends Animal  {
public Dog() {
System.out.println("dog");	// TODO Auto-generated constructor stub
}
	@Override  //어노테이션 "정상적으로 재정의 되있는지 확인해"
	public void sound() {
	   System.out.println("멍멍 월월");
		
	}
	
}
