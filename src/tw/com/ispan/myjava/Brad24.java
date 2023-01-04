package tw.com.ispan.myjava;

import java.util.Scanner;

public class Brad24 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=0;
		int num=sc.nextInt();
		int ans=0;
		while(a<=num) {
			ans+=a++;
		}
		System.out.println(ans);
	}
}
