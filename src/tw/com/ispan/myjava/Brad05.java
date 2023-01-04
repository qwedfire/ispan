package tw.com.ispan.myjava;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Brad05 {
	public static void main(String[] args) {
		//輸入
		String str=JOptionPane.showInputDialog("x=?");
		int var1=Integer.parseInt(str);
		String str2=JOptionPane.showInputDialog("y=?");
		int var2=Integer.parseInt(str2);
		//運算
		int var3=var1+var2;
		int var4,var5,var6,var7; //int
		var4=var1-var2;
		var5=var1*var2;
		var6=var1/var2;
		var7=var1%var2;
		//輸出
//		System.out.printf("%d+%d=%d\n",var1,var2,var3);
//		System.out.printf("%d-%d=%d\n",var1,var2,var4);
//		System.out.printf("%d*%d=%d\n",var1,var2,var5);
//		System.out.printf("%d/%d=%d......%d\n ",var1,var2,var6,var7);
		JOptionPane.showMessageDialog(null, "Hello,world");
	}
}
