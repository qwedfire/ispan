package tw.com.ispan.myjava;

public class Brad14 {

	public static void main(String[] args) {
		final byte a=100;
		byte b=127;
		switch(b) { //byte,short,char,int ,String
		case 1:
			System.out.println("A");
			break;
		case a:
			System.out.println("B");
			break;
		case a+4+1+1+1+5*4:
			System.out.println("C");
			break;
		default:
			System.out.println("X");
			break;
		}
		System.out.println("finish");
	}
}
