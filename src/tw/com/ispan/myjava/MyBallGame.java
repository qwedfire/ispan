package tw.com.ispan.myjava;

import javax.swing.JFrame;

import tw.com.ispan.myclass.MyPanel;

public class MyBallGame extends JFrame{
	private MyPanel myPanel;
	public MyBallGame(){
		myPanel=new MyPanel();
		add(myPanel);
		setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyBallGame();
	}
}