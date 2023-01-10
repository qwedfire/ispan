package tw.com.ispan.myjava;

import java.io.IOException;

import tw.com.ispan.myclass.Bike;

public class Brad42 {

	public static void main(String[] args) {
		int a=0,b=0;
		int c;
		try {
			c=a/b;
			System.out.println(c);
			int []d= {1,2,3,4};
			System.out.println(d[9]);
			Bike b1=null;
			b1.downSpeed();
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Game Over");
	}
}
