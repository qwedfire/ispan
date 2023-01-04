package tw.com.ispan.myjava;

import java.util.Scanner;

public class Brad11 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
//		if(year%4==0&&year%100!=0||year%400==0) {
//			System.out.println("閏年");
//		}else {
//			System.out.println("平年");
//		}
		boolean isLeap;
		if(year%4==0) {
			//isLeap=true;
			if(year%100==0) {
				//isLeap=false;
				if(year%400==0) {
					//29
					isLeap=true;
				}else {
					//28
					isLeap=false;
				}
			}else {
				//29
				isLeap=true;
			}
		}else {
			//28
			isLeap=false;
		}
		System.out.printf("%d年是%s年", year, (isLeap?"潤":"平") );
	}
}
