package tw.com.ispan.myjava;

import java.io.File;

public class Brad45 {

	public static void main(String[] args) {
		File f1=new File("E:\\dir1");
		if(!f1.exists()) {
			f1.mkdir();
		}
		System.out.println(f1);
	}
}
