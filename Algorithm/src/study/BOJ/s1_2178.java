package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로탐색
public class s1_2178 {

	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 }; // 상하 방향배열, n
	static int[] dx = { 0, 0, -1, 1 }; // 좌우 방향배열, m

	public static void BFS(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { y, x });

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int nowY = now[0];
			int nowX = now[1];

			for (int i = 0; i < 4; i++) {
				int nextY = nowY + dy[i];
				int nextX = nowX + dx[i];

				if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
					continue;
				if (visited[nextY][nextX] || map[nextY][nextX] == 0)
					continue;

				q.add(new int[] { nextY, nextX });
				map[nextY][nextX] = map[nowY][nowX] + 1;//들어간 값에서 +1
				visited[nextY][nextX] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());//Y
		m = Integer.parseInt(st.nextToken());//X

		map = new int[n][m]; // 지도 배열 선언
		visited = new boolean[n][m];//지도 배열만큼 방문할 배열 선언

		for (int i = 0; i < n; i++) {// 입력받기
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		visited[0][0] = true; // 처음 들어가는 값 true만들어주기
		BFS(0, 0);
		System.out.println(map[n - 1][m - 1]);//배열 마지막에 들어간 값 출력
	}

}