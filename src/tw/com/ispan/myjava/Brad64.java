package tw.com.ispan.myjava;

import java.net.InetAddress;
import java.net.Socket;

/*
 * 用戶端 使用TCP
 */
public class Brad64 {
	public static void main(String[] args) {
		//http=>80  port號
		//https=>443
		//ftp=>21
		//smtp=>25
		//pop3=>110
		for(int i=0;i<65536;i++) {
			try {
				Socket socket=new Socket(InetAddress.getByName("10.10.243.19"),i);
				socket.close();
				System.out.println("ok:"+i);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}