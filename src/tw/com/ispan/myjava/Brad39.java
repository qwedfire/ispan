package tw.com.ispan.myjava;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad39 {

	public static void main(String[] args) {
//		HashSet<Integer> nums=new HashSet<>(); //因為不會重複 所以增加進去的值不會重複
		TreeSet<Integer> numss=new TreeSet();  //列印出來的值會自動排列 
//		while(nums.size()<6) {
//			nums.add((int)(Math.random()*49+1));
//		}
		while(numss.size()<6) {
			numss.add((int)(Math.random()*49+1));
		}
//		System.out.println(nums);
//		for(Integer num:nums) {
//			System.out.print(num+" ");
//		}
		for(Integer num:numss) {
			System.out.print(num+" ");
		}
	}
}
