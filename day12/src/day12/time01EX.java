package day12;

public class time01EX {

	public static void main(String[] args) {
		
		time01 t1 = new time01();
		//기본생성자를 이용해서 새로운 객체를 생성하고
		//생성된 객체의 시작 번지를 t1 이라는 객체변수(인스턴스변수)에 담아라.
		t1.setName("류재정");
		t1.setHeight(186);
		t1.setWeight(80);
		
		time01 t2 = new time01("류우정",168,64);
		time01 t3 = new time01("류의정");
		t3.setHeight(175);
		t3.setWeight(66);
		
		time01 t4 = new time01(180,80);
		t4.setName("류승호");
		t1.disp();
		t2.disp();
		t3.disp();
		t4.disp();
		
		
	}
	
}
