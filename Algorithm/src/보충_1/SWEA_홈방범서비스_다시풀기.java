package 보충_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//SWEA - 홈방범서비스
public class SWEA_홈방범서비스_다시풀기 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;

	static int max;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);

			arr = new int[N][M];

			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(str[j]);

				}
			}
			// ----------------- 입력 부 ------------------
			BFS(N, M);
			
			System.out.println("#" + tc + " " + (max - 1));
		}
	}

	public static void BFS(int N, int M) {
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1)
					// 집의 위치를 q에 모두 담는다
					q.add(new Point(i, j));
			}
		}

		while (!q.isEmpty()) {
			// 상하좌우는 큐에 담아야한다.
			Point point = q.poll();
			for (int i = 0; i < 4; i++) {// 4방탐색
				int nextX = point.x + dx[i];
				int nextY = point.y + dy[i];

				// 인덱스 확인
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				// 다음 위치에 집이 없으면 패스
				if (arr[nextX][nextY] != 0) {
					continue;
				}
				arr[nextX][nextY] = arr[point.x][point.y] + 1;
				q.add(new Point(nextX, nextY));
			}
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		//System.out.println(max - 1);

	}
}

class Point { // 좌표값 들고갈 포인트 클래스
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}