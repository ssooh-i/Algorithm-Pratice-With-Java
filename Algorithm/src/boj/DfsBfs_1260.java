package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_1260 {
	static int[][] check;// 간선 연결 저장
	static boolean[] visited;
	static int n;// 정점 수
	static int m;// 간선 수
	static int v;// 시작 정점
	static StringBuilder sb;

	static void dfs(int i) {
		sb.append(i + " ");

		for (int j = 0; j <= n; j++) {
			if (check[i][j] == 1 && visited[j] == false) {// 1이 들어있고 방문을 아직 안했다면 들어가기
				visited[j] = true; // 방문했다고 표시
				dfs(j);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {

			int now = q.poll();
			sb.append(now + " ");
			
			for (int j = 0; j <= n; j++) {
				if (check[now][j] == 1 && visited[j] == false) {// 1이 들어있고 방문을 아직 안했다면 들어가기
					visited[j] = true; // 방문했다고 표시
					q.add(j);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		check = new int[n + 1][n + 1];// n으로 하면 index오류나서 +1해줌
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {// 간선
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			check[a][b] = check[b][a] = 1;// 양방향에 넣어주기, 체크용 1
		}
		
		visited[v] = true;
		dfs(v);
		sb.append("\n");

		// visited = new boolean[n]; //확인상태 원래대로 돌리기
		Arrays.fill(visited, false);//false로 채우기
		bfs(v);
		
		System.out.println(sb.toString().trim());
	}
}
