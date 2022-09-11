package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//국회의원 선거
public class s5_1417 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int max = 0;
		// 낮은 숫자가 우선순위인 int형 우선순위 큐 선언
		// PriorityQueue<Integer> q = new PriorityQueue<>();

		// 높은 숫자가 우선순위인 int형 우선순위 큐 선언
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int A = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				A = Integer.parseInt(br.readLine());
			} else {
				q.add(Integer.parseInt(br.readLine()));
			}
		}
		int cnt = 0;
		if (N == 1) {//예외처리
			System.out.println(0);
		} else {
			// 가장 표가 많은 사람한테서 표 뺏어오기
			while (true) {
				if (A > q.peek()) {// 이때는 꺼내지말고 보기
					System.out.println(cnt);
					break;
				} else {
					int b = q.poll() - 1; //표가 가장 많은 후보에서 표 하나 빼오기
					A += 1; //A에 더해주기
					++cnt;//먼저 더해주기
					q.add(b);
				}
			}
		}
	}
}
