package homework.hw_0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 알파벳
public class BOJ_1987 {
	static int R, C;
	static char[][] map;
	static boolean[] visited;
	static int maxCnt;
	static int[] dy = { -1, 1, 0, 0 };// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	static void dfs(int y, int x, int cnt) {
//		System.out.println("map[y][x]: "+map[y][x]);
//		System.out.println("Y: " + y + ", X: " + x + ", cnt: " + cnt);
		if (maxCnt < cnt) {
			maxCnt = cnt;
		}
		for (int d = 0; d < 4; d++) {

			int nextY = y + dy[d];// 다음위치
			int nextX = x + dx[d];

			if (0 <= nextY && nextY < R && 0 <= nextX && nextX < C) {// 인덱스 범위확인
				if (!visited[map[nextY][nextX] - 'A']) {
					visited[map[nextY][nextX] - 'A'] = true;
					dfs(nextY, nextX, cnt + 1);
					visited[map[nextY][nextX] - 'A'] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[26];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 초기 설정
		maxCnt = 1;
		int a = map[0][0] - 'A';
		// System.out.println(map[0][0]+" , "+a);
		visited[a] = true;

		dfs(0, 0, 1);
		System.out.println(maxCnt);

//		for(int i = 0; i< R; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
	}

}
