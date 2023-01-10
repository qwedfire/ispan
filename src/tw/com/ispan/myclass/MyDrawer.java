package tw.com.ispan.myclass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;
//1.決定線條全部換顏色和粗細或單一線條顏色和粗細

public class MyDrawer extends JPanel{
	private LinkedList<LinkedList<HashMap<String,Integer>>> lines,recycle;
	public MyDrawer() {
		setBackground(Color.PINK);
		MyListener listener=new MyListener();
		addMouseListener(listener);  //
		addMouseMotionListener(listener); //
		lines=new LinkedList<>();
		recycle=new LinkedList<>();
	}
	@Override  //看到的外觀由paint方法處理
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);//需要先完成父類別
//		if(g instanceof Graphics2D) { 判斷g是不是Graphics2D的子類別或是實作介面
//			System.out.println("ok");
//		}else {
//			System.out.println("no");
//		}
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(4)); //字體粗細
		
//		g2d.drawLine(0, 0, 100, 200); 原點0,0 畫到100,200
		for(LinkedList<HashMap<String,Integer>> line:lines) {
			for(int i=1;i<line.size();i++) {
				HashMap<String,Integer>p0=line.get(i-1);
				HashMap<String,Integer>p1=line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
				
			}
		}
	}
	//內部類別(外部類別已經有繼承因此創建內部類別繼承)
	private class MyListener extends MouseAdapter{ 
		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("press"+e.getX()+","+e.getY());
			HashMap<String ,Integer>point=new HashMap();
			point.put("x", e.getX());point.put("y", e.getY());
			LinkedList<HashMap<String,Integer>> line=new LinkedList<>();
			line.add(point);
			lines.add(line);
			repaint(); //重畫component類別方法
		}
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			System.out.println("Released"+e.getX()+","+e.getY());
//		}
		@Override
		public void mouseDragged(MouseEvent e) {
//			System.out.println("Dragged"+e.getX()+","+e.getY());
			HashMap<String ,Integer>point=new HashMap();
			point.put("x", e.getX());point.put("y", e.getY());
			lines.getLast().add(point);
			repaint();
		}		
	}
	/**
	 * 清空按鈕
	 */
	public void clear() {
		lines.clear();
		repaint(); //清空後重畫
	}
	/**
	 * 上一步
	 */
	public void undo() {
		recycle.add(lines.removeLast());
		repaint();
	}
	/**
	 * 復原
	 */
	public void redo() {
		lines.add(recycle.removeLast());
		repaint();
	}
	/**
	 * 儲存成jepg檔案
	 */
	public void saveJEPG() {
		BufferedImage img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d=img.createGraphics();
		paint(g2d);//Jpanel 畫到物件g2d
		try {
		ImageIO.write(img, "jpeg", new File("dir1/brad.jpg"));
		System.out.println("save ok");
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	public void saveLines() {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("dir1/lines.sign"))){
			oos.writeObject(lines);
			oos.flush();
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void loadLines() {
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("dir1/lines.sign"))){
			lines=(LinkedList<LinkedList<HashMap<String,Integer>>>)ois.readObject();
			repaint();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
