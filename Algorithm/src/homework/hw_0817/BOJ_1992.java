package homework.hw_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992 {
	static StringTokenizer st;
	static int N;
	static char[][] str;

	static void Divided(int y, int x, int size) {

		if (isSame(y, x, size)) {
			System.out.print(str[y][x]);
			return;
		}
		System.out.print("(");
		// x,y, 나눌 size
		Divided(y, x, size / 2);// 1사분면
		Divided(y, x + size / 2, size / 2);// 2사분면
		Divided(y + size / 2, x, size / 2);// 4사분면
		Divided(y + size / 2, x + size / 2, size / 2);// 3사분면
		System.out.print(")");
	}

	static boolean isSame(int y, int x, int size) {
		char a = str[y][x];

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (a != str[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		str = new char[N][N];

		for (int i = 0; i < N; i++) {// 입력받기
			str[i] = br.readLine().toCharArray();
		}

		Divided(0, 0, N); // 시작점, 시작값

	}

}
