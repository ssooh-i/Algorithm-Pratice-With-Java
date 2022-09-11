package workshop.ws0804;

import java.util.Scanner;

//n개의 수를 입력받고 가능한 모든 부분집합 생성
public class SubSetTest {
	static int N, totalCnt;
	static int[] input;// 입력된 수 기록
	static boolean[] isSeclected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		totalCnt = 0;
		input = new int[N];
		isSeclected = new boolean[N]; // index로 맞출 꺼니까 N개

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		subset(0);
		System.out.println("총 경우의 수: " + totalCnt);

	}

	private static void subset(int index) {// cnt: 직전까지 고려한 원소 수

		if (index == N) {// 더 이상 고려할 원소가 없다면 부분집합의 구성이 완성
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print(isSeclected[i] ? input[i] : "X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		// 원소선택
		isSeclected[index] = true;
		// if(index+1<N) 여기에 조건을 넣는 것보다 따로 만드는 게 좋음
		subset(index + 1);

		// 원소 미선택
		isSeclected[index] = false;
		subset(index + 1);
	}
}
