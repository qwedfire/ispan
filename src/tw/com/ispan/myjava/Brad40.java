package tw.com.ispan.myjava;

import java.util.ArrayList;

public class Brad40 {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);    //1
		list.add(2);  //1 2
		list.add(1,3);  //1 3 2
		list.add(0,4);  //4 1 3 2
		list.add(5);  //4 1 3 2 5
		System.out.println(list);
	}
}
