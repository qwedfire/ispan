package tw.com.ispan.myjava;

import java.awt.Container;

import javax.swing.JFrame;

public class Brad27 extends JFrame{
	
	public Brad27() {
		this.setLocation(10,10); //位置
        this.setSize(500,400); //大小
        this.setTitle("季"); //標題
        this.setVisible(true); //是否可見化
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //叉叉
	}

	public static void main(String[] args) {
		Brad27 frm=new Brad27();
		
	}
}
