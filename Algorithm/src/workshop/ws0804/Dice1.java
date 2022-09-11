package workshop.ws0804;

import java.util.Arrays;
import java.util.Scanner;

public class Dice1 {
	static int N, total;
	static int[] numbers;
	static boolean[] isSelceted;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int mode = sc.nextInt();
		
		numbers = new int[N];
		total = 0;
		System.out.println("총 경우의 수: "+total);
		
		switch(mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice1(0);
			break;
		case 3:
			dice1(0);
			break;
		case 4:
			dice1(0);
			break;
		case 5:
			dice1(0);
			break;
		case 6:
			dice1(0);
			break;
		}
	}
	//주사위 던지기 2 : 순열
		private static void dice2(int cnt) {
			if(cnt == N) {
				System.out.println(Arrays.toString(numbers));
				return;
			}
			//가능 한 모든 수 시도 (주사위 눈 1~6)
			for(int i=0; i<=6 ; i++) {
				numbers[cnt] = i;
				dice1(cnt+1);
			}
		}
		
		//주사위 던지기 1 : 중복 순열
		private static void dice1(int cnt) {
			if(cnt == N) {
				System.out.println(Arrays.toString(numbers));
				return;
			}
			//주사위 눈 1~6
			for(int i=0; i<=6 ; i++) {
				numbers[cnt] = i;
				dice1(cnt+1);
			}
		}
}
