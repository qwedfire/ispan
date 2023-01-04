package tw.com.ispan.myjava;

public class Brad08 {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.random());
		System.out.println("-------");
		int score=(int)(Math.random()*101);
		System.out.println(score);
		
		if(score >=90) {  //boolean =>true/false
			System.out.println("A");
		}else if(score>=80) {
			System.out.println("B");
		}else if(score>=70) {
			System.out.println("C");
		}else if(score>=60) {
			System.out.println("D");
		}else {
			System.out.println("E");
		}
	}
}
