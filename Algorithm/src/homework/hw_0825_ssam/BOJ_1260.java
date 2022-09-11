package homework.hw_0825_ssam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1260 - DFS와 BFS
public class BOJ_1260 {
	static boolean[] visited;// 방문관리
	static int[][] check; // 노드들이 있을 곳
	static int N, M, V;
	static StringBuilder sb;

	static void DFS(int v) {
		sb.append(v + " ");

		for (int i = 0; i <= N; i++) {//정점 수만큼 반복
			if (check[v][i] == 1 && !visited[i]) {//1이 들어있고 방문을 아직 안했다면 들어가기
				visited[i] = true; //방문체크
				DFS(i);
			}
		}
	}
	
	static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true; //방문체크
		
		while(!q.isEmpty()) { //큐가 비어있지 않다면
			int now = q.poll();//지금 일할 친구
			sb.append(now + " ");
			
			for (int i = 0; i <= N; i++) {//정점 수만큼 반복
				if (check[now][i] == 1 && !visited[i]) {//1이 들어있고 방문을 아직 안했다면 들어가기
					visited[i] = true; //방문체크
					q.add(i);
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점

		visited = new boolean[N + 1]; // 정점번호가 1부터 시작
		check = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			check[a][b] = check[b][a] = 1; // 양방향연결
		}

		sb = new StringBuilder();

		visited[V] = true;
		DFS(V);
		sb.append("\n");
		
		Arrays.fill(visited, false); //false로 초기화
		BFS(V);
		
		System.out.println(sb.toString().trim());

	}

}
