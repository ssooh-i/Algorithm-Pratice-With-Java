package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 11866 - 요세푸스 문제 0
public class BOJ_11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		//q만들고 q안에 값 순서대로 N까지 넣기
		Queue<Integer> q = new LinkedList<>();
		for(int i =1; i<=N; i++) {
			q.add(i);
		}
		
		Queue<Integer> q2 = new LinkedList<>();//빠져나오는 애들 넣어줄 곳
		
		int cnt = 0;
		while(!q.isEmpty()) {//큐가 비어있지 않다면 실행
			if(q.size() == 1) {
				q2.add(q.poll());
			}
			else {
				int size  = q.size();
				for(int i = 0; i<size ; i++) {
					cnt++;
					if(cnt == K) {
						q2.add(q.poll());
						cnt = 0;
					}else {
						q.add(q.poll());
						
					}
				}
			}
		}
		System.out.print("<");
		while(q2.size() != 1) {
			System.out.print(q2.poll()+", ");
		}
		System.out.println(q2.poll()+">");
	}
}
