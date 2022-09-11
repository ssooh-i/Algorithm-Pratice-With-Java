package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 7568 - 덩치
public class BOJ_7568 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 사람수

		int[][] people = new int[N][2];

		for (int i = 0; i < N; i++) {// 입력받기
			String[] s = br.readLine().split(" ");
			people[i][0] = Integer.parseInt(s[0]);
			people[i][1] = Integer.parseInt(s[1]);
		}

		for (int i = 0; i < N; i++) {
			int rank = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;// 같은 사람은 비교안하기
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
	}
}
