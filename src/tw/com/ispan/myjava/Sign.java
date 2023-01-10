package tw.com.ispan.myjava;
//多重執行序
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tw.com.ispan.myclass.MyDrawer;
import tw.com.ispan.myclass.MyDrawerV2;
import tw.com.ispan.myclass.MyDrawerV3;
//存檔 JFileChoose showDialog
public class Sign extends JFrame{
	private JButton clear,undo,redo,chWidth,chColor,saveJpeg,saveLine,loadLine;
	private JTextField inputWidth;
	private MyDrawer myDrawer;
	private Sign() {
		super("簽名");
		clear=new JButton("清除");
		undo=new JButton("上一步");
		redo=new JButton("下一步");
		chWidth=new JButton("換粗細");
		saveJpeg=new JButton("存");
		saveLine=new JButton("存線");
		loadLine=new JButton("載入線");
		inputWidth=new JTextField(4);
		chColor=new JButton("換顏色");
		JPanel top=new JPanel(new FlowLayout());
		top.add(clear);top.add(undo);top.add(redo);
		top.add(inputWidth);top.add(chWidth);top.add(chColor);top.add(saveJpeg);
		top.add(saveLine);top.add(loadLine);
		setLayout(new BorderLayout());
		add(top,BorderLayout.NORTH);
		
		myDrawer=new MyDrawer();
		add(myDrawer,BorderLayout.CENTER);
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	/**
	 * 所有按鈕的動作
	 */
	private void init() {
		clear.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();				
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();				
			}
		});
//		chWidth.addActionListener(new ActionListener() {			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				myDrawer.setNowWidth(Float.parseFloat(inputWidth.getText()));
//			}
//		});
//		chColor.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				changerColor();
//			}
//		});
		saveJpeg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJEPG();
			}
		});
		saveLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveLines();
			}
		});
		loadLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.loadLines();
			}
		});
	}
//	private void changerColor() {
//		Color newColor=JColorChooser.showDialog(this, "選顏色",myDrawer.getNowColor());
//		if(newColor!=null) {
//			myDrawer.setNowColor(newColor);
//		}
		
//	}
	public static void main(String[] args) {
		new Sign();
	}
}
