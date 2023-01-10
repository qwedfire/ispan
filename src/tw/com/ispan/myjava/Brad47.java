package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad47 {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("./dir1/file1.txt");
			int c1;
			while((c1=fis.read())!=-1) {//fis.read()==-1 代表沒資料
				System.out.print((char)c1);			
			}
			fis.close();
//			System.out.println("ok");
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println(e.toString());
		}
	}
} //file >>textfiler/binaryfile(文字資料/非文字資料)
//alt+數字可以查ASCII表



