package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad58 {

	public static void main(String[] args) {
		Brad583 obj=new Brad583();
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("dir1/test.ok"));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			System.out.println("step1 ok");
			System.out.println("-----");
			ObjectInputStream oin=new ObjectInputStream(new FileInputStream("dir1/test.ok"));
			Brad583 obj2=(Brad583)oin.readObject();
			oin.close();
			System.out.println("step2 ok");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
class Brad581{
	Brad581(){
		System.out.println("Brad581");
	}
}
class Brad582 extends Brad581 implements Serializable{
	Brad582(){
		System.out.println("Brad582");
	}
}
class Brad583 extends Brad582 {
	Brad583(){
		System.out.println("Brad583");
	}
}