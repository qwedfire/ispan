package tw.com.ispan.myjava;

import java.util.HashSet;

import tw.com.ispan.myclass.Bike;

public class Brad37 {

	public static void main(String[] args) {
		HashSet set=new HashSet();
		set.add("Brad");
		set.add(new Bike());
		set.add(12);
		set.add(12.3);
		set.add("Brad");
		System.out.println(set.size());
		System.out.println(set);
	}
}
