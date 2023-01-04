package tw.com.ispan.myjava;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad35 extends JFrame implements ActionListener{
	private JButton b1,b2,b3;
	public Brad35() {
		b1=new JButton("B1");
		b2=new JButton("B2");
		b3=new JButton("B3");
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(b1);add(b2);add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public static void main(String[] args) {
		new Brad35();
	}
	public void actionPerformed(ActionEvent e) {
//		String str=e.getActionCommand(); 傳回B1 B2 B3(按鈕上的文字)
//		System.out.println(e.getSource());
		if(e.getSource()==b1) {
			doB1();
		}else if(e.getSource()==b2) {
			doB2();
		}else if(e.getSource()==b3) {
			doB3();
		}
	}
	private void doB1() {
		
	}
	private void doB2() {
			
	}
	private void doB3() {
		
	}
}
