package tw.com.ispan.myjava;

import java.io.FileReader;

public class Brad50 {

	public static void main(String[] args) {
		//文字資料可以直接用FileReader
		try {
			FileReader reader=new FileReader("./dir1/file1.txt");
			int c;
			while((c=reader.read())!=-1) {
				System.out.print((char)c);
			}
			reader.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
