package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.com.ispan.myclass.Member;

public class JDBC08 {
	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	private final static String SQL_LOGIN="select * from member where account=? ";
	private final static String SQL_CHPASSWORD="update member set password=? where id=?";

	public static void main(String[] args) {		
		Scanner sc=new Scanner(System.in);
		System.out.print("Account:");
		String account=sc.next();
		System.out.print("Password:");
		String password=sc.next();
		//登入資料庫
		Properties prop=new Properties();
		prop.put("user", USER);prop.put("password",PASSWORD);
		
		try (Connection conn=DriverManager.getConnection(URL,prop);
				PreparedStatement pstmt=conn.prepareStatement(SQL_LOGIN)){
			pstmt.setString(1, account);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) { //唯一一筆
				if(BCrypt.checkpw(password,rs.getString("password"))) {
					//login
					Member member=new Member(rs.getInt("id"),rs.getString("account"),rs.getString("realname"),null);
					System.out.printf("welcome,%s/%s\n",member.getRealname(),member.getAccount());
					//change password process
					System.out.println("change password(newpassword or no):");
					String newPassword=sc.next();
					if(newPassword.length()>=6) {
						PreparedStatement pstmt2=conn.prepareStatement(SQL_CHPASSWORD);
						pstmt2.setString(1, BCrypt.hashpw(newPassword,BCrypt.gensalt()));
						pstmt2.setInt(2,member.getId());
						if(pstmt2.executeUpdate()>0) {
							//SUCCESS
							System.out.println("change password success!");
						}else {
							//更換失敗
							System.out.println("change password failure!");
						}
					}else {
						//不想換
						System.out.println("no change~");
					}
				}else {
					//帳號不存在
					System.out.println("login failure(2)");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
//			Scanner scanner = new Scanner(System.in);
//			
//			System.out.print("Account: ");
//			String account = scanner.next();
//			
//			System.out.print("Password: ");
//			String passwd = scanner.next();
//
//			Properties prop = new Properties();
//			prop.put("user", USER); prop.put("password", PASSWORD);
//
//			try (Connection conn = DriverManager.getConnection(URL, prop);
//					PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN)) {
//				pstmt.setString(1, account);
//				ResultSet rs = pstmt.executeQuery();
//				if (rs.next()) {
//					if (BCrypt.checkpw(passwd, rs.getString("password"))) {
//						// login
//						Member member = new Member(rs.getInt("id"),
//								rs.getString("account"), rs.getString("realname"), null);
//						System.out.printf(
//							"Welcome, %s / %s\n", member.getRealname(), member.getAccount());
//						
//						// change password process
//						System.out.print("Change Password(newpasswd or NO): ");
//						String newPasswd = scanner.next();
//						
//						if (newPasswd.length() >= 6) {
//							PreparedStatement pstmt2 = conn.prepareStatement(SQL_CHPASSWORD);
//							pstmt2.setString(1, BCrypt.hashpw(newPasswd, BCrypt.gensalt()));
//							pstmt2.setInt(2, member.getId());
//							if (pstmt2.executeUpdate() > 0 ) {
//								// SUCCESS
//								System.out.println("change passwd success!");
//							}else {
//								// 更換失敗
//								System.out.println("change passwd failure!");
//							}
//						}else {
//							// 不想換
//							System.out.println("no change");
//						}
//						
//						
//					}else {
//						// failure
//						System.out.println("login failure(1)");
//					}
//				}else {
//					// 帳號不存在
//					System.out.println("login failure(2)");
//				}
//				
//			}catch (Exception e) {
//				System.out.println(e);
//			}
//		}	
//	}