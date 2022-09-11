package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//
public class SWEA_chef {
	static int N;
	static int[][] synergy;
	static int min;
	static boolean[] visited;

	// N/2개 재료선택해서 A그룹에 시너지 합 넣어주기
	// 선택 안된 N/2 시너지합 구해서 B그룹에 넣기
	// Math.abs(A-B) 해서 절대값 차가 젤 작은 애를 min로 갱신해주기
	// min 출력해주기

	static void comb(int idx, int cnt) {

		if (cnt == N / 2) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					for (int j = 0; j < N; j++) {
						if (visited[j]) {
							a += synergy[i][j];
						}
					}
				} else {
					for (int j = 0; j < N; j++) {
						if (!visited[j]) {
							b += synergy[i][j];
						}
					}
				}
			}

			min = Math.min(Math.abs(a - b), min);

			return;
		}

		if(idx >= N) {
			return;
		}

		visited[idx] = true;
		comb(idx + 1, cnt + 1);
		visited[idx] = false;
		comb(idx + 1, cnt);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			synergy = new int[N][N];
			visited = new boolean[N];// 재료를 선택하는 거임, 시너지 파악 아님
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0);

			System.out.println("#"+tc+" "+min);

		}
	}
}
