package tw.com.ispan.myjava;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/*
 * 瀏覽網站實現轉pdf功能
 */
public class Brad70 {
	public static void main(String[] args) {
		try {
			URL url=new URL("https://pdfmyurl.com/?url=https://www.gamer.com.tw");		
			URLConnection conn=(HttpsURLConnection)url.openConnection();
			conn.connect();
			BufferedInputStream bin=new BufferedInputStream(conn.getInputStream());
			FileOutputStream fout=new FileOutputStream("dir3/test.pdf");
			byte[] buf=new byte[4*1024];int len;
			while((len=bin.read(buf))!=-1) {
				fout.write(buf,0,len);
			}
			fout.flush();
			fout.close();
			bin.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}