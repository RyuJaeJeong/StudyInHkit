package Time_afernoon2;

public class Tv implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("-- tv�ѱ� --");// TODO Auto-generated method stub

	}

	@Override
	public void turnOff() {
		System.out.println(" --tv����--");

	}

	@Override
	public void setVolume(int i) {
		System.out.println("Television�� ������" +  i + "���� �����˴ϴ�.");
		// TODO Auto-generated method stub

	}

}
