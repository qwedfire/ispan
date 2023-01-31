package tw.com.ispan.myjava;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * 
 */
public class Brad66 {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket(InetAddress.getByName("10.10.243.1"),7777);
			OutputStream out=socket.getOutputStream();
			out.write(" ".getBytes()); //發送訊息
			out.flush();
			out.close();
			System.out.println("TCP OK");
			socket.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}