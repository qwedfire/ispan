package tw.com.ispan.myjava;

public class Brad20 {

	public static void main(String[] args) {
		int []arr=new int[7];
		for(int i=0;i<10000;i++) {
			int rand=(int)(Math.random()*9+1);
			arr[rand>6?rand-3:rand]++;
//			if(rand<=6) {
//				arr[rand]++;
//			}else {
//				arr[rand-3]++;
//			}
		}
		for(int i=1;i<=6;i++) {
			System.out.printf("%d出現%d次\n",i,arr[i]);
		}
		for(int v:arr) {
			System.out.println(v);
		}
	}

}
