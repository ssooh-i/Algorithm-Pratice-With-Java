package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로탐색

public class s1_2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int lenCnt;
	static int min;

	static void BFS(int y, int x, int len) {
		Queue<Point> q = new LinkedList<Point>();
		while (!q.isEmpty()) {
			Point point = q.poll();

			for (int i = 0; i < 4; i++) {// 4방탐색
				int nextX = point.x + dx[i];
				int nextY = point.y + dy[i];

				// 범위 체크
				if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
					if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
						visited[nextY][nextX] = true; 
						BFS(nextY, nextX, len + 1);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // Y
		M = Integer.parseInt(st.nextToken()); // X
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		BFS(0, 0, 1);
//		q = new LinkedList<>();
//		q.add(new Point(0,0,1));
		lenCnt = 1;
		min = Integer.MAX_VALUE;

	}

}

//포인트 클래스로 포인트 객체만들기
class Point {
	int y;
	int x;
	int len;

	Point(int y, int x, int len) {// 좌표값과 지금 이동한 칸수
		this.y = y;
		this.x = x;
		this.len = len;
	}
}
