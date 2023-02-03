package tw.com.ispan.myclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;


/*
 * 專門處理gift資料的類別
 */
public class GiftDB {
	private final static String USER="root";//整理資料
	private final static String PASSWORD="root";
	private final static String URL="jdbc:mysql://localhost:3306/iii";
	private Connection conn;
	private ResultSet rs;
	private String [] fieldNames;
	
	public GiftDB() throws Exception{
		Properties prop=new Properties();
		prop.put("user", USER);prop.put("password",PASSWORD);
		conn=DriverManager.getConnection(URL,prop);	
	}
	
	public void queryData(String sql) throws Exception{
		Statement stmt = 
			conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd=rs.getMetaData() ;
		int colCount = rsmd.getColumnCount();
		fieldNames = new String[colCount];
		for (int i=0; i<colCount; i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
		}
	}
	
	public int getRows() {
		try {
			rs.last(); //指標移動到最後一筆傳回這筆的指標
			return rs.getRow();
		}catch(Exception e) {
			return 0; //如果有錯直接回傳0
		}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	
	public String getData(int row,int col) {
		try {
			rs.absolute(row);
			String data=rs.getString(col);
			return data;
		}catch(Exception e) {
			return "XX";
		} 
	}
	
	public String[] getHeader() {
		return fieldNames;
	}
	/**
	 * 改變資料哪一欄哪一行改動資料
	 * @param row
	 * @param clo
	 * @param data
	 */
	public void updateData(int row,int col,String data) {
		try {
			rs.absolute(row);
			rs.updateString(col,data);
			rs.updateRow();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delRow(int row) {
		try {
			rs.absolute(row);
			rs.deleteRow();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}