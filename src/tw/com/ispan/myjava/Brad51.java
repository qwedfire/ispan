package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad51 {

	public static void main(String[] args) {
		long now=System.currentTimeMillis();
		try {
			FileInputStream fis=new FileInputStream("dir1/yo.png");
			FileOutputStream fos=new FileOutputStream("dir2/yo2.png");
			int b;
			while((b=fis.read())!=-1) {
				fos.write(b);
			}
			fos.flush();
			fos.close();
			fis.close();
			System.out.println(System.currentTimeMillis()-now);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
