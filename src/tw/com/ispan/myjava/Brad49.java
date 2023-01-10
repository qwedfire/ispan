package tw.com.ispan.myjava;

import java.io.FileOutputStream;
import java.io.IOException;

public class Brad49 {
	public static void main(String[] args) {
		String data="I am Brad\nOK";
		try {
			FileOutputStream fos=new FileOutputStream("./dir2/file1.txt");
			fos.write(data.getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			System.out.println(e);		
		}
	}
} 


