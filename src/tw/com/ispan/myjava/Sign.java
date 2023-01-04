package tw.com.ispan.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.com.ispan.myclass.MyDrawer;

public class Sign extends JFrame{
	private JButton clear,undo,redo;
	private MyDrawer myDrawer;
	private Sign() {
		super("簽名");
		clear=new JButton("清除");
		undo=new JButton("上一步");
		redo=new JButton("下一步");
		
		JPanel top=new JPanel(new FlowLayout());
		top.add(clear);top.add(undo);top.add(redo);
		
		setLayout(new BorderLayout());
		add(top,BorderLayout.NORTH);
		
		myDrawer=new MyDrawer();
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Sign();
	}
}
