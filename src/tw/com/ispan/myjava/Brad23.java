package tw.com.ispan.myjava;

public class Brad23 {

	public static void main(String[] args) {
		int a=10,b=3;
		a=a+b; //a=13
		b=a-b; //b=10
		a=a-b; //a=3
//		System.out.printf("a=%d,b=%d",a,b);
		int arr[]=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
			System.out.println(arr[i]);
		}
		arr=swap(arr,0,2);
		System.out.println("-------");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	static int[] swap(int[]arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		return arr;
	}
	
}
