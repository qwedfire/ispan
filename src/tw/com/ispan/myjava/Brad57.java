package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Brad57 {

	public static void main(String[] args) {
		try(
		ObjectInputStream oin=new ObjectInputStream(new  FileInputStream("dir1/brad.score"));){
			System.out.println("nice");
			Student s1=(Student)oin.readObject();
			System.out.println(s1);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

