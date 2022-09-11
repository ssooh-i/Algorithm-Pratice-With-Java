package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 도영이가 만든 맛있는 음식
public class BOJ_2961_s2_2 {
	static int N, min;
	static int[] sour;// 신
	static int[] bitter;// 쓴
	static boolean[] isSelect;

	static void powerset(int cnt, int s, int b) {
		if (cnt == N) {
			int falseCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelect[i])
					continue;
				falseCnt++;
			}
			if (falseCnt == N) return;
			min = Math.min(Math.abs(s - b), min);

			return;
		}
		isSelect[cnt] = true;
		powerset(cnt + 1, s * sour[cnt], b + bitter[cnt]);
		isSelect[cnt] = false;
		powerset(cnt + 1, s, b);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sour = new int[N];
		bitter = new int[N];
		isSelect = new boolean[N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer sb = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(sb.nextToken());
			bitter[i] = Integer.parseInt(sb.nextToken());
		}

		powerset(0, 1, 0);
		System.out.println(min);

	}
}
