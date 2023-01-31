package tw.com.ispan.myjava;

import java.net.InetAddress;

public class Brad61 {
//10.10.243.19   13
//255.255.255.0
	public static void main(String[] args) {
		try {
			InetAddress[] ips=InetAddress.getAllByName("www.microsoft.com");
			for(InetAddress ip:ips) {
				System.out.println(ip.getHostAddress());
			}
//			InetAddress ip=InetAddress.getByName("10.10.243.13");//格式不對都算錯
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}