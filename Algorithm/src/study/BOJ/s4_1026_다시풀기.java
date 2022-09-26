package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//보물
public class s4_1026_다시풀기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //배열의 길이
		
		// 낮은 숫자가 우선순위인 int형 우선순위 큐 선언
		PriorityQueue<Integer> A = new PriorityQueue<>();

		// 높은 숫자가 우선순위인 int형 우선순위 큐 선언
		PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());//A배열만들기
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());//B배열만들기
		for (int i = 0; i < N; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int S = 0;
		for(int i = 0; i<N; i++ ) {
			S += (A.poll() * B.poll());
			//System.out.println(S);
		}
		
		System.out.println("total: " + S);
	}
}
