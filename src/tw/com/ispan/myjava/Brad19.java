package tw.com.ispan.myjava;

public class Brad19 {
	public static void main(String[] args) {
		int one=0,two=0,three=0,four=0,five=0,six=0;
		for(int i=0;i<100;i++) {
			int num=(int)(Math.random()*6+1);
			System.out.print(num+"\t");
			if(num==1) {
				one++;
			}else if(num==2) {
				two++;
			}else if(num==3) {
				three++;
			}else if(num==4) {
				four++;
			}else if(num==5) {
				five++;
			}else  {
				six++;
			}
		}
		System.out.println();
		System.out.println(one+"\t"+two+"\t"+three+"\t"+four+"\t"+five+"\t"+six+"\t");
	}
}
