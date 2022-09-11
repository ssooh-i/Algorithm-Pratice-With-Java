package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 - 부녀회장이 될테야
public class b1_2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());// 층
			int N = Integer.parseInt(br.readLine());// 호

			int[][] map = new int[K + 1][15];

			for (int i = 0; i < 15; i++) {// 초기 0층 설정
				map[0][i] = i;
			}
			// 자리에 배정하기
			for (int i = 1; i <= K; i++) {
				int p = 0;
				for (int j = 1; j < 15; j++) {
					p += map[i-1][j];
					map[i][j] = p;
				}
			}
			
			System.out.println(map[K][N]);

		}
	}
}
