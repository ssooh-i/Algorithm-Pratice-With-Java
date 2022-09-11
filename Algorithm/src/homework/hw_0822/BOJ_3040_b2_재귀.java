package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 - 백설공주와 일곱난쟁이(재귀)
public class BOJ_3040_b2_재귀 {
	static int[] dwarf;
	static boolean[] check;

	static void comb(int start, int cnt) {
		if (cnt == 7) {// 7개 요소 뽑았을 때
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (check[i]) {
					sum += dwarf[i];
				}
			}
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (check[i]) {
						System.out.println(dwarf[i]);
					}
				}
			}
			return;
		}
		
		if(start==9) { // false, false, false, ... 이렇게 앞에서 넘나 안뽑아서 R개가 안된 경우
			return;
		}

		check[start] = true;
		comb(start + 1, cnt + 1);
		check[start] = false;
		comb(start + 1, cnt);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dwarf = new int[9];
		check = new boolean[9];

		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		comb(0, 0);

	}
}
