package tw.com.ispan.myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad53 {

	public static void main(String[] args) {
		long now=System.currentTimeMillis();
		try {
			File source=new File("dir1/0.jpg");
			FileInputStream fis=new FileInputStream("dir1/0.jpg");
			FileOutputStream fos=new FileOutputStream("dir2/02.jpg");
			int len;
			//直接準備容量相等的大小 存取
			byte[]buf=new byte[(int)source.length()];  //一次性讀寫 效能增加
			fos.write(buf);
			fos.flush();
			fis.read(buf);
			fis.close();
			System.out.println(System.currentTimeMillis()-now);
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
