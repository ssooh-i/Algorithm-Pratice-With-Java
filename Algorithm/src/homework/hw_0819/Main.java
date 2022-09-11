package homework.hw_0819;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class  Main{ //Solution_1861_정사각형방
	static int N, ansMax, ansRoom;
	static int[][] map;
	static int tmp;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // end input

			ansMax = 0;
			ansRoom = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tmp = 1;
//					loop(i, j);
//					dfs(i, j);
					bfs(i, j);

					if (tmp > ansMax) {
						ansMax = tmp;
						ansRoom = map[i][j];
					} else if (tmp == ansMax) {
						ansRoom = Math.min(ansRoom, map[i][j]);
					}
				}
			}

			System.out.println("#" + tc + " " + ansRoom + " " + ansMax);
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>(); // 복사기 사용 계획표
		queue.add(new Point(i, j));

		while (!queue.isEmpty()) { // 복사기 쓸 사람이 남았으면 복사기는 계속 돌아감.
			Point now = queue.poll(); // 지금 복사기 사용하는 사람.
			for (int d = 0; d < 4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == map[now.i][now.j] + 1) {
					queue.add(new Point(nexti, nextj));
					tmp++;
					break;
				}
			}
		}

	}

	private static void dfs(int nowi, int nowj) {
		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == map[nowi][nowj] + 1) {
				dfs(nexti, nextj);
				tmp++;
				break; // break for d
			}
		}
	}

	private static void loop(int nowi, int nowj) {
		while (true) {
			boolean isGo = false;
			for (int d = 0; d < 4; d++) {
				int nexti = nowi + di[d];
				int nextj = nowj + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == map[nowi][nowj] + 1) {
					nowi = nexti;
					nowj = nextj;
					isGo = true;
					tmp++;
					break; // break for d
				}
			}
			if (!isGo)
				break;
		}
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
