package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04 {

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
			Connection conn=DriverManager.getConnection(url,prop);
			String sql="insert into tb1(f1,f2)value(?,?)";
			//隱碼攻擊在username進行檢查不會執行MySQL語句
			PreparedStatement pstmt=conn.prepareStatement(sql);//避免隱碼攻擊
			pstmt.setString(1, "eric");
			pstmt.setString(2, "1999-03-04");
			int num=pstmt.executeUpdate();
			System.out.println(num);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
