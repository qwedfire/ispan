package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC09 {
	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	public static void main(String[] args) {
		
		String sql="SELECT e.firstName ,SUM(od.UnitPrice*od.Quantity) sum FROM orders o "
				+ "JOIN employees e ON(o.EmployeeID=e.EmployeeID) "
				+ "JOIN orderdetails od ON(o.OrderID=od.OrderID) "
				+ "GROUP BY e.EmployeeID "
				+ "ORDER BY sum DESC";
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn=DriverManager.getConnection(URL,prop);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				String name =rs.getString("Firstname");
				double num=rs.getDouble("sum");
				System.out.printf("%s=>%f\n",name,num);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
