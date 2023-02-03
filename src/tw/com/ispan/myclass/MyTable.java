package tw.com.ispan.myclass;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable{ //要可以放在視窗裡面
	private MyModel myModel;  //處理資料
	private GiftDB db;
	
	public MyTable() throws Exception{
		
		db=new GiftDB();
		db.queryData("select *from gift");
		
		myModel=new MyModel();
		setModel(myModel);
		myModel.setColumnIdentifiers(db.getHeader()); //增加欄位名稱
		
	}
	
	public void delRow() {
		myModel.removeRow(getSelectedRow()); //選擇自己選擇哪一筆資料(table會知道)
		repaint();
	}
	
	
	private class MyModel extends DefaultTableModel{
		/**
		 * 算出資料庫有幾筆資料
		 */
		@Override
		public int getRowCount() {
			return db.getRows();
		}
		/**
		 * 傳回有多少欄位
		 */
		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			
			return db.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			db.updateData(row+1,column+1,(String)aValue);
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return column>0; //除了第0個其他都可以改 因為第0個是id索引值 不能修改
		}
		
		@Override
		public void removeRow(int row) {
			db.delRow(row+1);
		}	
	}
}