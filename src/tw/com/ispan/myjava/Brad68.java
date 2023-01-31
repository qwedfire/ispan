package tw.com.ispan.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 */
public class Brad68 {
	public static void main(String[] args) {
		//read file
		while(true) {
			try {
				ServerSocket server=new ServerSocket(6666);
				Socket socket=server.accept();
				String ip=socket.getInetAddress().getHostAddress();
				FileOutputStream fout=new FileOutputStream(String.format("dir3/%s.jpg",ip));
				BufferedInputStream bin=new BufferedInputStream(socket.getInputStream());
				byte[]buf=new byte[1024*2];int len;
				while((len=bin.read())!=-1) { //網路讀進來的行為
					fout.write(buf,0,len);
				}
				bin.close();
				fout.flush();
				fout.close();
				server.close();
				System.out.println("TCP接收完畢");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}