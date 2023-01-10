package tw.com.ispan.myjava;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel []roads=new JLabel[8];
	private Car[] cars=new Car[8];
	private int rank;
	public Racing () {
		go=new JButton("start");
		setLayout(new GridLayout(9,1));
		add(go);
		for(int i=0;i<roads.length;i++) {
			roads[i]=new JLabel("第"+(i+1)+"跑道:");
			add(roads[i]);
		}
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		setSize(1024,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private class Car extends Thread{
		private int lane;
		Car(int lane){  //賽車知道在第幾跑道
			this.lane=lane;
		}
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				roads[lane].setText(roads[lane].getText()+">"+(i==9?++rank:""));
				if(rank==1) {
					stopGame();
				}
				try {
					Thread.sleep(10+(int)(Math.random()*200));
				} catch (InterruptedException e) {
					break;
				}
			}
//			rank++;
//			roads[lane].setText(roads[lane].getText()+" 名次:"+rank);
		}
		
	}
	/**
	 * 按鈕go的方法  (方便維護)
	 */
	private void go() {
		go.setEnabled(false);
		rank=0;
		for(int i=0;i<roads.length;i++) {
			roads[i].setText("第"+(i+1)+"跑道:");
		}
		for(int i=0;i<roads.length;i++) {
			cars[i]=new Car(i);
			cars[i].start();  
		}
	}
	/**
	 * 暫停 中斷
	 */
	private void stopGame() {
		for(int i=0;i<cars.length;i++) {
			cars[i].interrupt();
		}
		go.setEnabled(true);
	}
	public static void main(String[] args) {
		new Racing();

	}
	
}
