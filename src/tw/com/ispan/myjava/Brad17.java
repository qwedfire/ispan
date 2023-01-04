package tw.com.ispan.myjava;

public class Brad17 {
	public static void main(String[] args) {
//		for(int i=1;i<10;i++) {
//			for(int j=1;j<10;j++) {
//				System.out.print(j+"*"+i+"="+i*j+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println("---------");
		final int ROWS=3;
		final int START=1;
		final int COLS=3;
		for(int k=0;k<ROWS;k++) {
			for(int i=1;i<=9;i++) {
				for(int j=START;j<START+COLS;j++) {
					System.out.print((j+k*COLS)+"*"+i+"="+i*(j+COLS*k)+"\t");
				}
				System.out.println();
			}
			System.out.println("---------");
		}
//		System.out.println("---------");
//		for(int i=1;i<10;i++) {
//			for(int j=1;j<10;j++) {
//				System.out.print(i+"*"+j+"="+i*j+"\t");
//			}
//			System.out.println();
//		}
		
		
		
//		for(int i=2;i<=5;i++) {
//			for(int j=1;j<=9;j++) {
//				int  r=i*j;
//			}
//		}
	}
}
