package 보충_1;

public class Test_Combination {//조합
	static String[] cards = {"A","B","C"};
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		comb(0, 0);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==2) {
			System.out.print("지금 만들어진 조합 : { ");
			for(int i=0; i<cards.length; i++) {
				if(select[i])
					System.out.print(cards[i]+" ");
			}
			System.out.println("}");
			return;
		}
		if(idx == cards.length) return;
		
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
}
