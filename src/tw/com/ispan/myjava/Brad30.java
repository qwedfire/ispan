package tw.com.ispan.myjava;

import tw.com.ispan.myclass.TWid;

public class Brad30 {

	public static void main(String[] args) {
//		System.out.println(TWid.isValidId("A13456789")); //不足10 
//		System.out.println(TWid.isValidId("a123456789")); //小寫a
//		System.out.println(TWid.isValidId("A723456789")); //第二位不為1/2/8/9
//		System.out.println(TWid.isValidId("A123456789")); 
//		System.out.println(TWid.isValidId("A823456789")); //驗證碼不符
//		System.out.println(TWid.isValidId("A923456789")); //驗證碼不符
//		if(TWid.isValidId("A13456789")) {
//			System.out.println("OK");
//		}

		TWid id1=new TWid();
		TWid id2=new TWid(true);
		TWid id3=new TWid(1);
		TWid id4=new TWid(false,0);
		TWid id5=TWid.creatTWId("A123456789");
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		System.out.println(id5.getId());
	}
}
