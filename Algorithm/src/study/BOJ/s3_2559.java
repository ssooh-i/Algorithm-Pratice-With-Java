package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class s3_2559 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 온도 측정을 한 전체 날짜
		int K = Integer.parseInt(st.nextToken());// 합을 구하기 위한 연속적인 날짜 수

		int[] temp = new int[N];// 온도 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {// 온도 배열 입력받기
			temp[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= N - K; i++) {//배열 범위를 잘 생각해보자,,
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += temp[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}

}
