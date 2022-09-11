package boj.retry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 12891 - DNA 비밀번호
public class BOJ_12891_s2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());// 재료 길이
		int P = Integer.parseInt(st.nextToken());// 비밀번호 길이

		char[] arr = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());// 최소 조건 수
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int a = 0;// 카운팅할 변수
		int c = 0;
		int g = 0;
		int t = 0;

		int result = 0;// 최종 결과값
		for (int j = 0; j < S - P; j++) {
			for (int i = j; i <= P + i; i++) {
				System.out.println(arr[i]);
				if (arr[i] == 'A') {
					a++;
				}
				if (arr[i] == 'C') {
					c++;
				}
				if (arr[i] == 'G') {
					g++;
				}
				if (arr[i] == 'T') {
					t++;
				}

				if (A == a && C == c && G == g && T == t) {// 조건을 다 만족했을 떄
					result++;
				}
				
			}
			System.out.println();
		}

		System.out.println(result);

	}
}
