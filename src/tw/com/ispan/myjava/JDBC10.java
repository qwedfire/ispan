package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.com.ispan.myclass.Bike;

public class JDBC10 {
	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	private final static String SQL_ICON="update member set icon =? where id =?";
	private final static String SQL_BIKE="update member set bike =? where id =?";
	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.put("user", USER);prop.put("password",PASSWORD);
		Bike b1=new Bike();
		b1.upSeed();b1.upSeed();b1.upSeed();
		System.out.println(b1.getspeed());
		try {
			Connection conn=DriverManager.getConnection(URL,prop);	
			PreparedStatement pstmt=conn.prepareStatement(SQL_ICON);
			FileInputStream fin=new FileInputStream("dir1/ball0.jpg");
			pstmt.setBinaryStream(1,fin);  //二進制檔用InputStream存
			pstmt.setInt(2, 1);
			if(pstmt.executeUpdate()>0) {
				System.out.println("ok");
			}else {
				System.out.println("no good");
			}
			//此上半部分將ball檔案從java中存進MySQL中
			
			//此下半部分將Bike物件存進MySQL中
			System.out.println("-----------");
			PreparedStatement pstmt2=conn.prepareStatement(SQL_BIKE);
			pstmt2.setObject(1,b1);  //物件用object存
			pstmt2.setInt(2, 1);
			if(pstmt2.executeUpdate()>0) {
				System.out.println("ok");
			}else {
				System.out.println("no good");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
