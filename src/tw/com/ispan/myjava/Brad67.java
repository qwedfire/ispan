package tw.com.ispan.myjava;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * 
 */
public class Brad67 {
	public static void main(String[] args) {
		//read file
		try {
			Socket socket=new Socket(InetAddress.getByName("10.10.243.22"),1999);
			BufferedOutputStream bout=new BufferedOutputStream(socket.getOutputStream());
			FileInputStream fin=new FileInputStream("dir1/ball1.png");
			byte[] buf=new byte[4*1024];int len;
			while((len=fin.read(buf))!=-1) {
				bout.write(buf,0,len);
			}
			bout.flush();
			bout.close();
			fin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}