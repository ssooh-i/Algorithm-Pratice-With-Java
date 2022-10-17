package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//평범한 배낭
public class g5_12865 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 물품 수
		int K = Integer.parseInt(st.nextToken());// 최대 무게

		int[][] bp = new int[N + 1][2];// backpack => bp
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {// 입력받기
			st = new StringTokenizer(br.readLine());
			bp[i][0] = Integer.parseInt(st.nextToken()); // 무게
			bp[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		for (int i = 1; i <= N; i++) {// dp
			// i이 몇번째 물건인지 j가 현재 무게
			for (int j = 1; j <= K; j++) {
				// 지금위치 뺴기 입력받은 무게 랑 위에꺼 비교해서 dp에 넣기
				if (j - bp[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j - bp[i][0]] + bp[i][1], dp[i - 1][j]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		for(int i =0; i<=N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[N][K]);
	}

}
