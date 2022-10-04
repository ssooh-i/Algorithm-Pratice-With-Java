package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//인구이동
public class g5_16234 {

	static int[] se = { -1, 0, 1, 0 };
	static int[] ga = { 0, 1, 0, -1 };
	static int N, L, R;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		int[][] pan = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;
		while (true) {
			int maxSize = -1;
			boolean[][] visit = new boolean[N][N];
			Queue<Nation> q = new LinkedList<>();
			System.out.println(days);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;
					sum = 0;
					movePop(pan, i, j, visit, q);
					int size = q.size();
					maxSize = Math.max(size, maxSize);
					int newPop = sum / size;
					while (!q.isEmpty()) {
						Nation cur = q.poll();
						pan[cur.y][cur.x] = newPop;
					}
				}
			}
			/*for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(pan[i]));
			}
			System.out.println();*/
			System.out.println(maxSize);
			if (maxSize == 1)
				break;
			days++;
		}
		System.out.println(days);
	}

	static void movePop(int[][] pan, int y, int x, boolean[][] visit, Queue<Nation> q) {
		if (visit[y][x])
			return;
		q.offer(new Nation(y, x));
		sum += pan[y][x];
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ys = y + se[i];
			int xg = x + ga[i];
			if (ys < 0 || xg < 0 || ys >= N || xg >= N || visit[ys][xg])
				continue;
			int diff = Math.abs(pan[y][x] - pan[ys][xg]);
			if (diff >= L && diff <= R) {
				movePop(pan, ys, xg, visit, q);
			}
		}
	}
}

class Nation {
	int y;
	int x;

	public Nation(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
