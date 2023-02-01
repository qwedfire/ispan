package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.print("keyword= ");
//		String key=sc.next(); 查關鍵字
		System.out.print("page= ");
		int page=sc.nextInt(); //查詢第幾頁
		int rpp=10;
		int start =(page-1)*rpp;
		try {
			String url="jdbc:mysql://localhost:3306/iii?user=root&password=root";
			Properties prop=new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password","root");
			prop.setProperty("serverTimezone","Asia/Taipei");
			Connection conn=DriverManager.getConnection(url,prop);
			String sqlcount="select count (*) from gift";
			Statement stmt=conn.createStatement();
			ResultSet recount=stmt.executeQuery(sqlcount);
			recount.next();
			int count=recount.getInt("count");
			int pages=(int)Math.ceil(count*1.0/rpp)+1;
//			if(page>pages) throw new Exception("aaaa");
			String sql="select id,name,place addr from gift order by id limit ?,? ";
//			String sql="select*from gift order by id limit ?,? ";
//			String sql="select*from gift where name like ? or place like ?";
			PreparedStatement pstmt=conn.prepareStatement(sql);//避免隱碼攻擊
//			pstmt.setString(1,"%"+key+"%");
//			pstmt.setString(2,"%"+key+"%");
			pstmt.setInt(1,start);
			pstmt.setInt(2,rpp);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {  //當有下一個進迴圈
				String v0=rs.getString("id"); 
				String v1=rs.getString("addr");   //如果使用別名必續使用別名替代原本名字
				String v2=rs.getString("name");
				System.out.printf("%s:%s:%s \n",v0,v1,v2);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
