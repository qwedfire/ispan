package tw.com.ispan.myjava;

import java.util.Scanner;

public class Brad04 {
	public static void main(String[] args) {
		//輸入
		Scanner sc=new Scanner(System.in);
		System.out.print("x=");
		int var1=sc.nextInt();
		System.out.print("y=");
		int var2=sc.nextInt();
		//運算
		int var3=var1+var2;
		int var4,var5,var6,var7; //int
		var4=var1-var2;
		var5=var1*var2;
		var6=var1/var2;
		var7=var1%var2;
		//輸出
		System.out.printf("%d+%d=%d\n",var1,var2,var3);
		System.out.printf("%d-%d=%d\n",var1,var2,var4);
		System.out.printf("%d*%d=%d\n",var1,var2,var5);
		System.out.printf("%d/%d=%d......%d\n ",var1,var2,var6,var7);
	}

}
