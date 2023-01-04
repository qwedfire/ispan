package tw.com.ispan.myjava;

public class Brad36 {

	public static void main(String[] args) {
		int a=10;
		Integer b=new Integer(10); //未來版本可能會刪除
		Integer c=10; //auto-boxing 自動封箱
		byte bb=c.byteValue();
		System.out.println(bb);
		int d=c; //auto-unboxing 自動解封
		byte f=12;
//		Integer e=f;
	}

}
