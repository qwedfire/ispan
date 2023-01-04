package tw.com.ispan.myjava;

public class PokerV1 {

	public static void main(String[] args) {
		long start=System.currentTimeMillis(); // 計算程式所需時間1970/1/1 0:0:0~2022 幾分幾秒
		final int num=52; //撲克張數
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
			System.out.println(poker[i]);	
		}	
		long end=System.currentTimeMillis();
		System.out.println("------");
		System.out.println(end-start);
	}

}
