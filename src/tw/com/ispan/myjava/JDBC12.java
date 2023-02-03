package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
/*
 * 增刪修資料庫類別展示
 */
public class JDBC12 {
	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	private final static String SQL_QUERY="select * from gift ";
	
	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.put("user", USER);prop.put("password",PASSWORD);
		try{
			Connection conn=DriverManager.getConnection(URL,prop);
			//可以上下移動的(參數二) 隨時跟新(參數三) 加入rs指標才可以變動位置
			PreparedStatement pstmt=conn.prepareStatement(SQL_QUERY,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE); //可以上下移動的(參數二) 隨時跟新(參數三) 加入rs.first才不會爆錯
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				System.out.println(name);
			}
			System.out.println("---------");
			rs.first(); //將指標移到第一筆 會回傳boolean值 
			String name=rs.getString("name");
			System.out.println(name);
			System.out.println("---------");
			rs.absolute(5); //將指標移到第5筆
			name=rs.getString("name");
			System.out.println(name);
			/**
			 * 刪除
			 */
//			rs.deleteRow(); //將指標的資料刪除

			System.out.println("---------");
			/**
			 * 修改
			 */
			rs.absolute(2); //資料移到第二筆並且列印出來
			name=rs.getString("name");
			System.out.println(name); 
			rs.updateString("name","Brad豪華禮盒"); //修改資料(哪一個欄位,要改變的名稱)
			rs.updateString("city","台中市"); 
			rs.updateRow(); //改動資料更新
			System.out.println("---------");
			/**
			 * 新增
			 */
			//每個資料庫有個家的插入位置 因此使用此方法可以移動到每家(SQL MySQL)不同的插入位置
			rs.moveToInsertRow(); //移動到插入的位置(最後一筆)
			rs.updateString("name","Brad超級極品豪華禮盒");
			rs.updateString("place","台中市");
			rs.updateString("city","台中市");
			rs.updateString("town","台中市");
			rs.insertRow(); //改動資料新增
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
