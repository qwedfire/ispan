package tw.com.ispan.myclass;

public class Scooter extends Bike{
	private int gear;
	public Scooter() {
		color="黃色";
	}
	public Scooter(String color) {
		this.color=color;
	}	
	public void upgear() {
		gear=gear<4?gear+1:4;
	}
	public void downgear() {
		gear=gear==1?1:gear-1;
	}
	public boolean changeGear(int newgear) {
		if(gear>=0||gear<=4) {
			return true;
		}
		return false;
	}
	@Override
	public String getcolor() {
		return color;
	}
	@Override
	public void upSeed() {
		speed=speed<1?10:speed*2.5;
	}
	@Override
	public void downSpeed() {
		speed=speed<1?0:speed*0.5;
	}
}
