package Time_afernoon2;

public class Tv implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("-- tv켜기 --");// TODO Auto-generated method stub

	}

	@Override
	public void turnOff() {
		System.out.println(" --tv끄기--");

	}

	@Override
	public void setVolume(int i) {
		System.out.println("Television의 볼륨은" +  i + "으로 조정됩니다.");
		// TODO Auto-generated method stub

	}

}
