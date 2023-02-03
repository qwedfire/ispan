package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad73 {
	public static void main(String[] args) {
		String passwd="123456";
		String passwd2=BCrypt.hashpw(passwd, BCrypt.gensalt());//(未加密,產生)
		System.out.println(passwd2);
		String passwd3="$2a$10$Msfb1nd22O31oiCz9GvIvONsRjVihbkzd9gRj4gh/o7vXi.OFMrSm";
		String passwd4="$2a$10$iirv3ZkLendSk6SsrSRD.ebmO2BcirJ.81hiSJE50adlbuJbvgGp2";
		if(BCrypt.checkpw(passwd, passwd4)) { //(未加密,加密參數)  無法比對(加密參數/加密參數)
			System.out.println("nice");
		}else {
			System.out.println("no");
		}
		//$2a$10$3bwG/VXcpdfWhhNmiNo.xuzw2af.0dBZGOWUxC1qO42TJQW5v1JUi
	}
}
