package tw.com.ispan.myjava;

public class Brad32 {

	public static void main(String[] args) {
		Brad321 obj1=new Brad321();
		Brad322 obj2=new Brad322();
		Brad321 obj3=new Brad322();
		Brad322 obj4=(Brad322)obj3;
//		obj1.m1();
//		obj2.m1();
//		obj2.m2();
		obj3.m1();
		
//		obj4.m1();
//		obj4.m2();
		System.out.println("-------");
		test1(obj3);
	}
	static void test1(Brad321 obj) {
		obj.m1();
	}
}
class Brad321{
	void m1() {
		System.out.println("brad321的m1");
	}
}
class Brad322 extends Brad321{
	void m1() {
		System.out.println("brad322的m1");
	}
	void m2() {
		System.out.println("brad322的m2");
	}
}
