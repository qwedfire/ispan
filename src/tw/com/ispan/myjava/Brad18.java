package tw.com.ispan.myjava;

public class Brad18 {

	public static void main(String[] args) {
		int []a;
		a=new int [4];
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println("-----");
		a[2]=127;
//		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]);
//		}
		System.out.println(a);
		for(int x:a) {
			System.out.println(x);
		}
	}

}
