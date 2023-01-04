package tw.com.ispan.myjava;

public class Brad33 {

	public static void main(String[] args) {
		Brad331 obj1=new Brad332();
		Brad331 obj2=new Brad333();
		obj1.m1();
		obj1.m2();
		obj2.m1();
		obj2.m2();
	}
}
abstract class Brad331{
	void m1() {
		System.out.println("brad331的m1");
	}
	abstract void m2();
}
class Brad332 extends Brad331{
	@Override
	void m2() {
		System.out.println("brad332的m2");
	}
}
class Brad333 extends Brad331{
	@Override
	void m2() {
		System.out.println("brad333的m2");
	}
}
