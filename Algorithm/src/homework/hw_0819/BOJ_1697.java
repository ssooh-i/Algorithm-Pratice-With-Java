package homework.hw_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 언니
		int K = Integer.parseInt(st.nextToken()); // 동생

		boolean[] visited = new boolean[100001];

		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(N);
		visited[N] = true;
		int time = 0;
		int a = N;//위치
		
		
		
		while (a != K) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				a = q.poll();
				//System.out.println("a: "+a);
				if(a == K) {
					time =time-1; 
					break;
				} 
				if (0 <= a - 1 && !visited[a - 1]) {
					q.offer(a - 1);
					visited[a - 1] = true;
				}
				if (100000 >= a + 1 && !visited[a + 1]) {
					q.offer(a + 1);
					visited[a + 1] = true;
				}
				if (100000 >= a * 2 && !visited[a * 2]) {
					q.offer(a * 2);
					visited[a * 2] = true;
				}
				
			}
			time++;
			//System.out.println("time: "+time);
			

		}
		System.out.println(time);

	}

}
