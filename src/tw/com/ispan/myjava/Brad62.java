package tw.com.ispan.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * 傳送端
 */
public class Brad62 {
//10.10.243.19   13
//10.10.243.255  廣播
//255.255.255.0
	public static void main(String[] args) {
		String mesg="quit";
		byte[] data=mesg.getBytes();
		try {
			DatagramSocket socket=new DatagramSocket();
			DatagramPacket packet=new DatagramPacket(data,data.length,
					InetAddress.getByName("10.10.243.255"),8888);
			socket.send(packet);
			socket.close();
			System.out.println("nice");
//			InetAddress ip=InetAddress.getByName("10.10.243.13");//格式不對都算錯
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}