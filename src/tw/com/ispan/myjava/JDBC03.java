package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		// CREATE TABLE tb2 (id int primary auto_increment,f1 varchar(100),f2 date);
		//1.載入驅動程式 Load Driver
		//sqlserver(SQL寫法):  com.microsoft.sqlserver.jdbc.SQLServerDriver
		//mysqlserver(MySQL寫法): com.mysql.cj.jdbc.Driver
		//新版java不用寫此程式 此程式用於展示有build path成功
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println(e);
		}
		//2.create connection 驅動程式各自的(SQL MySQL...) 連線使用java官方的
		try {
			//(SQL連線寫法)jdbc:sqlserver://localhost;database=iii;user=sa;
			String url="jdbc:mysql://localhost:3306/iii?user=root&password=root";
			Properties prop=new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password","root");
			prop.setProperty("serverTimezone","Asia/Taipei");
			Connection conn=DriverManager.getConnection(url);
//			Connection conn=DriverManager.getConnection(url,"root","root"); // ( 連接MySQL指令/帳號/密碼)
//			Connection conn=DriverManager.getConnection(url,prop);
			System.out.println("ok2");
			
			Statement stmt=conn.createStatement(); //
//			String sql="insert into tb1(f1,f2)values ('Tom2','2023-02-01')";
			String sql="";
			int num=stmt.executeUpdate(sql); //stmt.executeUpdate(sql) 執行MySQL語句會回傳改動的數量
			System.out.println(num);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
