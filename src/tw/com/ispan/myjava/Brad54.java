package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad54 {

	public static void main(String[] args) {
		long now=System.currentTimeMillis();
		//自動關閉語法
		try(FileInputStream fis=new FileInputStream("dir1/0.jpg");
				FileOutputStream fos=new FileOutputStream("dir2/01.jpg");) {
			int len;
			byte[]buf=new byte[1024*4];
			while((len=fis.read(buf))!=-1) {
				fos.write(buf,0,len);
			}
			fos.flush();
			System.out.println(System.currentTimeMillis()-now);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
