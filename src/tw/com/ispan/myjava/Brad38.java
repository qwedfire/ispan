package tw.com.ispan.myjava;

import java.util.HashSet;
import java.util.Iterator;

public class Brad38 {

	public static void main(String[] args) {
		HashSet<String>names=new HashSet<>();
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("E");
		names.add("F");
		names.add("G");
		names.add("H");
		System.out.println(names);
		Iterator<String> it=names.iterator();
		while(it.hasNext()) {
			String name=it.next();
			System.out.print(name+" ");
		}
		System.out.println("-------");
		for(String name:names) {
			System.out.print(name+" ");
		}
	}
}
