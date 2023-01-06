package tw.com.ispan.myclass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;
//1.決定線條全部換顏色和粗細或單一線條顏色和粗細

public class MyDrawerV3 extends JPanel{
	private LinkedList<Line> lines,recycle;
	private Color nowColor;
	private float nowWidth;
	public MyDrawerV3() {
		setBackground(Color.PINK);
		MyListener listener=new MyListener();
		addMouseListener(listener);  
		addMouseMotionListener(listener); 
		lines=new LinkedList<>();
		recycle=new LinkedList<>();
		nowColor=Color.red;
		nowWidth=1;
	}
	@Override  //看到的外觀由paint方法處理
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);//需要先完成父類別
		Graphics2D g2d=(Graphics2D)g;	
		for(Line line:lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth())); //字體粗細
			for(int i=1;i<line.getPoints().size();i++) {
				HashMap<String,Integer>p0=line.getPoints().get(i-1);
				HashMap<String,Integer>p1=line.getPoints().get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
				
			}
		}
	}
	//內部類別(外部類別已經有繼承因此創建內部類別繼承)
	private class MyListener extends MouseAdapter{ 
		@Override
		public void mousePressed(MouseEvent e) {
			HashMap<String ,Integer>point=new HashMap();
			point.put("x", e.getX());point.put("y", e.getY());
			Line line=new Line(nowColor,nowWidth);
			line.getPoints().add(point);
			lines.add(line);
			repaint(); //重畫component類別方法
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String ,Integer>point=new HashMap();
			point.put("x", e.getX());point.put("y", e.getY());
			lines.getLast().getPoints().add(point);
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
	public Color getNowColor() {
		return nowColor;
	}
	public void setNowColor(Color nowColor) {
		this.nowColor = nowColor;
	}
	public float getNowWidth() {
		return nowWidth;
	}
	public void setNowWidth(float nowWidth) {
		this.nowWidth = nowWidth;
	}
}
