package tw.com.ispan.myclass;

public class TWid {
	private String id;
	private static String letters="ABCDEFGHJKLMNPQRSTUVXYWZIO";
	//建構子的overload
	//無傳參數自動產生有效的身分證
	public TWid() {
		//super();
		this((int)(Math.random()*2)==0); //傳入第二個建構子boolean
	}
	//男生true 女生false
	public TWid(boolean isMale) {
		this(isMale,(int)(Math.random()*26)); //傳入第四個建構子boolean,int
	}
	//給定地區
	public TWid(int area) {
		this((int)(Math.random()*2)==0,area); //傳入第四個建構子boolean,int
	}
	//台中男生
	public TWid(boolean isMale,int area) {
		//super();
		String c1=letters.substring(area,area+1);
		StringBuilder sb=new StringBuilder(c1);
		sb.append(isMale?'1':'2');
		for(int i=0;i<7;i++) {
			sb.append((int)(Math.random()*10));
		}
		for(int i=0;i<10;i++) {
			String tmp=sb.toString(); //StringBuilder轉成字串toString
			if(isValidId(tmp+i)) {
				id=tmp+i;
				break;
			}
		}
	}
	private TWid(String id) {
		this.id=id;
	}
	
	/**
	 * 判斷輸入的身分證是否有效(用在建構子)
	 * @param id
	 * @return
	 */
	public static TWid creatTWId(String id) {
		TWid rand=null;
		if(isValidId(id)) {
			rand=new TWid();
		}
		return rand;
	}
	
	public String getId() {
		return this.id;
	}
	/**
	 * 判斷身分證是否有效
	 * @param id
	 * @return
	 */
	public static boolean isValidId(String id) {
		//65-90 97-122
		//1.length=10
		//2.c1=A~Z
		//3.c2=1/2/8/9
		//4.c3-c10=0-9
		//id=""
		boolean isValid=false;
		if(id.matches("[A-Z][1289][0-9]{8}")) {//第一個字元A~Z第二個字元1289都可第三個字元0~9都可以重複八次
			isValid=true;
			char c1=id.charAt(0);
			int n12=letters.indexOf(c1)+10;
			int n1=n12/10;
			int n2=n12%10;
			int n3=Integer.parseInt(id.substring(1, 2));
			int n4=Integer.parseInt(id.substring(2, 3));
			int n5=Integer.parseInt(id.substring(3, 4));
			int n6=Integer.parseInt(id.substring(4, 5));
			int n7=Integer.parseInt(id.substring(5, 6));
			int n8=Integer.parseInt(id.substring(6, 7));
			int n9=Integer.parseInt(id.substring(7, 8));
			int n10=Integer.parseInt(id.substring(8, 9));
			int n11=Integer.parseInt(id.substring(9, 10));
			int sum=n1*1+n2*9+n3*8+n4*7+n5*6+n6*5+n7*4+n8*3
					+n9*2+n10*1+n11*1;
			isValid=sum%10==0;
		}
		return isValid;
//		boolean isValid=false;
//		String az="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String math="0123456789";
//		if(id.length()==10) {
//			char c1=id.charAt(0);
//			String str=c1+"";
//			if(az.contains(str)) {
//				char c2=id.charAt(1);
//				if(c2==49||c2==50||c2==56||c2==57) {
//					for(int i=2;i<10;i++) {
//						char c3=id.charAt(i);
//						String str1=c3+"";
//						if(!math.contains(str1)) {
//							break;
//						}
//					}
//					int sum=0;
//					for(int i=2;i<10;i++) {
//						char c3=id.charAt(i);
//						String str1=c3+"";
//						int s=Integer.parseInt(str1);
//						
//					}
//					isValid=true;
//				}
//			}
//		}
//		return isValid;
	}
}
