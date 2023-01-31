package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Server端 使用TCP
 */
public class Brad65 {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(7777);
			System.out.println("listening.....");
			Socket socket=server.accept(); //listening
			InputStream in=socket.getInputStream();
			BufferedReader br=new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String line;
			while((line=br.readLine())!=null) {
				System.out.println();
			}
			server.close();
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}