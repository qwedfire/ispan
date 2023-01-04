package tw.com.ispan.myjava;

public class Brad21 {
	public static void main(String[] args) {
		int [][]arr=new int[3][];
		arr[0]=new int[4];
		arr[1]=new int[5];
		arr[2]=new int[3];
		
		arr[0][1]=123;
		arr[0][2]=17;
		arr[1][0]=32;
		arr[2][2]=67;
		
		for(int[] a:arr) {
			for(int b:a) {
				System.out.print(b+"\t");
			}
			System.out.println();
		}
	}
}
