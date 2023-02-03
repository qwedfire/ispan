package tw.com.ispan.myjava;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.com.ispan.myclass.Bike;

public class JDBC11 {

	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	private final static String SQL_QUERY="select * from member where id =?";
	
	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.put("user", USER);prop.put("password",PASSWORD);
		try{
			Connection conn=DriverManager.getConnection(URL,prop);	
			PreparedStatement pstmt=conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			InputStream in=rs.getBinaryStream("icon");
			FileOutputStream fout=new FileOutputStream("dir3/icon.jpg");
			byte[] buf=new byte[64*1024]; //圖表最大限制64k 設定64k可以一次讀取完畢 不用加迴圈
			int len=in.read(buf);
			fout.write(buf,0,len);
			in.close();
			fout.flush();
			fout.close();
			//此上半部將ball圖檔從資料庫抓下來傳到java/dir3的資料夾裡
			
			//此下半部將資料庫的物件屬性bike抓出來 將其內容列印出來
			
			
			//這裡不能使用object 物件被存進去相當物件序列化 這邊要做的是解序列畫 解序列化的檔案產生串流再連接
			InputStream bin=rs.getBinaryStream("bike");//物件存進去再用串流解序列化出來 
			ObjectInputStream oin=new ObjectInputStream(bin);
			Object obj=oin.readObject();
			if(obj instanceof Bike) {
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
			Bike b1=(Bike)obj;
			System.out.println(b1.getspeed());
			
			
			
			System.out.println("kk");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
