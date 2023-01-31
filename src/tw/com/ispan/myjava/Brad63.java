package tw.com.ispan.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * 接收端
 */
public class Brad63 {
//10.10.243.19   13
//255.255.255.0
	public static void main(String[] args) {
		while(true) {
			byte[]buf=new byte[1024];
			try {
				DatagramSocket socket=new DatagramSocket(8888);
				DatagramPacket packet=new DatagramPacket(buf,buf.length);
				System.out.println("waiting...");
				socket.receive(packet);
				socket.close();
//				System.out.println("recive ok");
				String yourip=packet.getAddress().getHostAddress();
				int len=packet.getLength();
				byte[] data=packet.getData();
				String mesg=new String(data,0,len);
				System.out.printf("%s=>%s",yourip,mesg);
				System.out.println();
				if(mesg.equals("quit")) {
					break;
				}
	 		} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}