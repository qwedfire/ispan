package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {
	private static Connection conn;
	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	private final static String SQL_CHECK="select count(*) count from member where account=? ";
	private final static String SQL_INSERT="insert into member(account,password,realname)values(?,?,?) ";	
	public static void main(String[] args) {		
		Scanner sc=new Scanner(System.in);
		System.out.print("Account:");
		String account=sc.next();
		System.out.print("Password:");
		String password=sc.next();
		System.out.print("Real Name:");
		String realname=sc.next();
		
		Properties prop=new Properties();
		prop.put("user", USER);prop.put("password",PASSWORD);
		try {
			conn=DriverManager.getConnection(URL,prop);	
			if(checkAccount(account)) {
				if(addMember(account,password,realname)) {
					System.out.println("Register success");
				}else {
					System.out.println("Register failue");
				}
			}else {
				//相同帳號
				System.out.println("acount exist");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * 檢查帳號是否存在
	 * @param account
	 * @return
	 */
	private static boolean checkAccount(String account) throws Exception {
		boolean ret;
		PreparedStatement pstmt=conn.prepareStatement(SQL_CHECK);
		pstmt.setString(1, account);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		ret=rs.getInt("count")==0;
		pstmt.close(); //pstmt為區域變數關閉可以讓記憶體釋放
		return ret;
	}
	/**
	 * 創建帳號
	 * @return
	 */
	private static boolean addMember(String account,String password,String realname) throws Exception{
		boolean isOK=false;
		PreparedStatement pstmt=conn.prepareStatement(SQL_INSERT);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
		pstmt.setString(3, realname);
		isOK=pstmt.executeUpdate()!=0;
		pstmt.close();
		return isOK; //等於0沒創建成功
	}
}