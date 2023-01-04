package tw.com.ispan.myjava;

public class Brad03 {

	public static void main(String[] args) {
		byte v1,v2=3;
		v1 =10;
		int v3=v1 + v2; //v1+v2自動轉換為int型別 因此v3會報錯
		//byte v6=v1+v2;
		//short v5=v1+v2;
		long v4=v1+v2;
		System.out.println(v3);
		//%d:整數 %s:字串
		System.out.printf("%d +%d =%d\n",v1,v2,v3);
		//System.out.println(v1+"+"+v2+"="+v3);
		System.out.printf("%d -%d =%d\n",v1,v2,v1-v2);
		System.out.printf("%d *%d =%d\n",v1,v2,v1*v2);
		System.out.printf("%d /%d =%d\n",v1,v2,v1/v2);
	}
	
}
