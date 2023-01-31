package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
/*
 * 讀取網頁原始碼 範例(資策會)
 */
public class Brad71 {
	public static void main(String[] args) {
		try {
			String json=getData("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			parseJSON(json);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * 導入外面資料 
	 * @param json
	 */
	static void parseJSON(String json) {
		JSONArray root=new JSONArray(json);
		for(int i=0;i<root.length();i++) {
			JSONObject row=root.getJSONObject(i);
			String name=row.getString("Name"); 
			String county=row.getString("County");
			String township=row.getString("Township");
			System.out.printf("%s-%s %s\n",name,county,township);
		}
	}
	static String getData(String urlString)throws Exception {
		URL url=new URL(urlString);
		URLConnection conn=url.openConnection();
//			if(conn instanceof HttpURLConnection) {
//				System.out.println("yes");
//			}else {
//				System.out.println("no	");
//			}
		conn.connect();
		BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;StringBuffer sb=new StringBuffer();
		while((line=reader.readLine())!=null) {
			sb.append(line);
		}
		reader.close();
		return sb.toString();
	}
}
