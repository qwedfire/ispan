package tw.com.ispan.myjava;

import java.util.Arrays;

public class pokerV3 {
	public static void main(String[] args) {
		final int num=52; //牌組總數量
		final int player=4; //玩家總數
		final int cardList=num/player; //手牌張數
		int card[]=new int [num]; //一副牌組
		int cardLists[][]=new int[player][cardList]; //每位玩家的手牌
		//洗牌
		washcard(num,card);
		//發牌
		shuffle(player,card,cardLists);
		//排序手牌
		sort(player,cardList,cardLists);
		//攤牌
		print(player,cardList,cardLists);
	}
	/**
	 * 交換
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	static int[] swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		return arr;
	}
	/**
	 * 交換
	 * @param arr
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	static int[][] swap(int[][] arr,int i,int j,int k) {
		int tmp=arr[i][j];
		arr[i][j]=arr[i][k];
		arr[i][k]=tmp;
		return arr;
	}
	/**
	 * 排序每位玩家手上的牌
	 * @param player
	 * @param cardList
	 * @param cardLists
	 */
	static void sort(int player,int cardList,int[][]cardLists) {
		for(int k=0;k<player;k++) {
			for(int i=0;i<cardList-1;i++) {
				for(int j=0;j<cardList-1-i;j++) {
					if(cardLists[k][j]%cardList>cardLists[k][j+1]%cardList) {
						cardLists=swap(cardLists,k,j,j+1);
					}
				}
			}
		}
	}
	/**
	 * 發給每一位玩家手牌
	 * @param player
	 * @param card
	 * @param cardLists
	 */
	static void shuffle(int player,int []card,int[][]cardLists) {
		for(int i=0;i<card.length;i++) {
			cardLists[i%player][i/player]=card[i];  //i%4 >>0 1 2 3  i/4 0 0 0 0 
		}
	}
	/**
	 * 洗牌
	 * @param num
	 * @param card
	 */
	static void washcard(int num,int card[]) {
		for(int i=0;i<card.length;i++) {
			card[i]=i;
		}
		for(int i=0;i<1000;i++) {
			int rand1=(int)(Math.random()*num);
			int rand2=(int)(Math.random()*num);
			card=swap(card,rand1,rand2);
		}
	}
	/**
	 * 列印出每位玩家手上的牌
	 * @param player
	 * @param cardList
	 * @param cardLists
	 */
	static void print(int player,int cardList,int[][]cardLists) {
		String suit[]= {"黑桃","愛心","方塊","梅花"};
		String number[]= {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K ",};
		int count=1;	
		for(int i=0;i<player;i++) {
			System.out.println("第"+count+"位玩家:");
			for(int j=0;j<cardList;j++) {
				System.out.print(suit[cardLists[i][j]/13]+number[cardLists[i][j]%13]+"\t");
			}
			System.out.println();
			count++;
		}	
	}
}
