package workshop.ws0818;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {

	static int[][] adjMatrix;
	static int N;
	static boolean[] visited;

	private static void bfs() {
		// 0번 정점을 시작점
		Queue<Integer> q = new ArrayDeque<>();
		//boolean[] visited = new boolean[N]; // 방문관리 배열

		visited[0] = true;
		q.offer(0);

		while (!q.isEmpty()) {

			int cur = q.poll();
			System.out.print((char) (cur + 'A'));

			// 현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[cur][i] != 0) {// 방문하지 않았으며, 인접한 경우
					visited[i] = true;
					q.offer(i);
				}

			}

		}
		System.out.println();

	}

	static void dfs(int cur) {
		
		visited[cur] = true; //방문처리를 맨 위로 뻬주면서 체크를 해줘서 0을 따로 true 안해줘도됨
		System.out.print((char) (cur + 'A'));

		// 현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[cur][i] != 0) {// 방문하지 않았으며, 인접한 경우
				dfs(i);
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();

		adjMatrix = new int[N][N]; // 0으로 자동 초기화
		visited = new boolean[N];
		
		for (int i = 0; i < E; i++) { // 간선 정보에 해당하는 부분만 덮어줌
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1; // 무향그래프(양방향 연결)
		}

		//bfs();
		dfs(0);
	}

}
