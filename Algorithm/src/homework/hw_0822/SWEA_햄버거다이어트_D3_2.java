package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트_D3_2 {
	static int maxKcal, N; // 초기값
	static int[] material, kcal; // 재료점수, 칼로리점수 배열
	static boolean[] isSelect;
	static int max;//최대값

	static void powerset(int idx, int m, int k) {
		
		if (idx == N) {
			if (k <= maxKcal) {
				max = Math.max(max, m);
			}
			return;
		}
		if(k + kcal[idx]<= maxKcal) {
			powerset(idx + 1, m + material[idx], k + kcal[idx]);
		}
		
		powerset(idx + 1, m, k);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder(T*20);
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			maxKcal = Integer.parseInt(st.nextToken());

			material = new int[N];
			kcal = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				material[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			
			max = 0;
			
			powerset(0, 0, 0);
			sb.append("#"+tc+" "+max+"\n");
			//System.out.println("#"+tc+" "+max);
		}
		System.out.println(sb);
	}
}
