package tw.com.ispan.myjava;

import tw.com.ispan.myclass.Bike;

public class Brad25 {
	public static void main(String[] args) {
		Bike bike1=new Bike();
		Bike bike2=new Bike();
		while(bike1.getspeed()<10) {
			bike1.upSeed();
		}
		bike2.upSeed();
		bike2.upSeed();
		bike2.upSeed();
		bike2.upSeed();
		bike2.downSpeed();
		System.out.println("bike1的速度:"+bike1.getspeed());
		System.out.println("bike2的速度:"+bike2.getspeed());
	}
}
