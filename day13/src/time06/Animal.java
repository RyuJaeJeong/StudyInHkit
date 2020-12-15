package time06;


//java에서 추상화를 달성하는 또 다른 방법은 인터페이스를 사용하는 것이다.
//인터페이스는 객체를 만들 수 없다. - 생성자 필요없음. 
//상수, 추상 메소드
public interface Animal {
	public final int min_volumn = 0;
	public final int max_volumn = 100;
	
	public void sound();
	public void disp();

}
