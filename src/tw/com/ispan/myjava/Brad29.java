package tw.com.ispan.myjava;

import tw.com.ispan.myclass.Bike;

public class Brad29 {

	public static void main(String[] args) {
		String s1=new String("abcde");
		String s2="abcde";
		String s3="abcde";
		String s4=new String("abcde");
		System.out.println(s2==s3); 
		System.out.println(s1==s4);
		System.out.println(s1==s3);
		Bike b1=new Bike();
		Bike b2=new Bike();
		System.out.println(b1==b2);
		System.out.println(b1.equals(b2));
		
	}

}
