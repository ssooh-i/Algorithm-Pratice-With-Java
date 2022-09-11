package workshop.ws0804;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {
	static int N, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int mode = sc.nextInt();

		totalCnt = 0;
		numbers = new int[N];

		switch (mode) {
		case 1://중복 순열
			dice1(0);
			break;
		case 2://순열
			isSelected = new boolean[7]; // 0 안쓰고 주사위 눈에 맞춰서 쓸 꺼임
			dice2(0);
			break;
		case 3://중복 조합
			dice3(0,1);//1부터 시작해라(주사위 눈이 1부터니까)
			break;
		case 4://조합
			dice4(0,1);
			break;

		default:
			System.out.println("잘못된 입력임");
			break;
		}

		System.out.println("총 경우의 수: " + totalCnt);

	}

	// 주사위1: 중복 순열
	private static void dice1(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수 시도(주사위 눈1~6)
		for (int i = 1; i <= 6; i++) {
			// 수의 중복 선택이 가능함으로 중복 체크 필요없음
			// 해당 수 선택
			numbers[cnt] = i;
			// 다음 주사위 던지러 가기
			dice1(cnt + 1);
		}
	}

	// 주사위2: 순열
	private static void dice2(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수 시도(주사위 눈1~6)
		for (int i = 1; i <= 6; i++) {
			// 중복 체크 필요함
			if (isSelected[i])
				continue;
			// 해당 수 선택
			numbers[cnt] = i;
			isSelected[i] = true;
			// 다음 주사위 던지러 가기
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	// 주사위3: 중복 조합
	private static void dice3(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = start; i<=6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);//다음에도 똑같은 수를 뽑을 수 있게 i부터로 해줘야함
		}

	}

	// 주사위4: 조합
	private static void dice4(int cnt, int start) {//시작 범위를 주면 중복체크를 안해도 됨
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i<=6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}

	}
}
