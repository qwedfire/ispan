package tw.com.ispan.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//1.三碼不重複
//2.
public class GuessNumber extends JFrame implements ActionListener{
	private JTextField input; //文字行
	private JButton guess; //按鈕
	private JTextArea log; //文字區塊 
	private String answer; //隨機答案
	private int counter; //計算猜的次數
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		input=new JTextField();
		guess=new JButton("猜");
		log=new JTextArea();


		setLayout(new BorderLayout());
		add(log,BorderLayout.CENTER);
		
		JPanel top=new JPanel(new BorderLayout());
		add(top,BorderLayout.NORTH);
		top.add(input,BorderLayout.CENTER);
		top.add(guess,BorderLayout.EAST);
		
		guess.addActionListener(this); //觸發機制
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initMember();
		newGame();
		System.out.println(answer);
	}
	public static void main(String[] args) {
		new GuessNumber();
		
	}
	/**
	 * 按鈕動作
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		String inputString=input.getText();
//		String result=checkAB(inputString);
//		log.append(inputString+":"+result+"\n"); //顯示欄位部分
//		input.setText(""); //按鈕清空
//		String inputString = input.getText();
//		if (inputString.length() == 3) {
//			String result = checkAB(inputString);
//			log.append(inputString + ":" + result + "\n");
//			input.setText("");
//		}
		String inputString = input.getText();
		if (inputString.length() == 3) {
			counter++;
			String result = checkAB(inputString);
			log.append(String.format("%d.%s=>%s\n",counter,inputString,result));
			input.setText("");
			if(result.equals("3A0B")) {
				JOptionPane.showMessageDialog(null,"恭喜");
				newGame();
			}else if(counter==10){
				JOptionPane.showMessageDialog(null,"Loser\nAnswer is:"+answer);
				newGame();
			}
		}
	}
	/**
	 * 隨機不重複的答案
	 * @param d
	 * @return
	 */
	private String creatAnswer(int d) {
		final int num=10; //撲克張數
		int rand; //撲克亂數
		boolean isRepeat; //判斷撲克是否重複
		int poker[]=new int[num]; //poker[第幾張]=值=>52=>0
		for(int i=0;i<poker.length;i++) {
			do {
				rand=(int)(Math.random()*num);//rand 0-51
				//檢查機制
				isRepeat=false;
				for(int j=0;j<i;j++) {
					if(poker[j]==rand) {  
						//重複
						isRepeat=true;
						break;
					}
				}
			}while(isRepeat);
			poker[i]=rand;
		}	
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<d;i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
	}
	/**
	 * 開啟新局
	 */
	private void newGame() {
		answer=creatAnswer(3);
		System.out.println(answer);
		log.setText("");
		counter=0;
	}
	
	/**
	 * 設定字體大小
	 */
	private void initMember() {
		Font font1=new Font(null,Font.BOLD,30); //粗斜體
		input.setFont(font1);
		Font font2=new Font(null,Font.PLAIN,30); 
		log.setFont(font2);
//		log.setEnabled(false);
		log.setEditable(false);
	}
	/**
	 * 檢查規則 
	 * @return
	 */
	private boolean isValidInput(String g) { 
		//猜幾碼 長度有多少 只能數字並且不重複
		return true;
	}
	/**
	 * 幾A幾B
	 * @param g
	 * @return
	 */
	private String checkAB(String g) {
		int a=0,b=0;
		for(int i=0;i<answer.length();i++) {
			if(answer.charAt(i)==g.charAt(i)) {	
				a++;
			}else if(answer.indexOf(g.charAt(i))>=0){  //如果guess第i碼在answer中
				b++;
			}
		}
		return String.format("%dA%dB",a,b);
	}
}
