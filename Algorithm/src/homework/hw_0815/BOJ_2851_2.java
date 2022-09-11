package homework.hw_0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 2851 - 슈퍼마리오
public class BOJ_2851_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int diff = 100;
		int answer = -1;

		for (int i = 0; i < 10; i++) {
			sum += Integer.parseInt(br.readLine());

			if (Math.abs(100 - sum) <= diff) {
				//100-sum의 절대값이 100보다 적거나 같다면?
				diff = Math.abs(100 - sum);
				//100에서 계속  sum값을 빼줘서 가장 마지막에는 최소차만 남음
				//System.out.println(diff);
				answer = sum;
				//최소차가 남을 때 sum값을 정답으로 갱신
			}
		}

		System.out.println(answer);
	}
}