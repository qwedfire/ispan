package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/*
 * 讀取網頁原始碼 範例(資策會)
 */
public class Brad69 {
	public static void main(String[] args) {
		try {
			URL url=new URL("https://www.iii.org.tw");
			URLConnection conn=url.openConnection();
//			if(conn instanceof HttpURLConnection) {
//				System.out.println("yes");
//			}else {
//				System.out.println("no	");
//			}
			conn.connect();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			
			System.out.println(e);
		}
	}
}