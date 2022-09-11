package workshop.ws0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7576 - 토마토
/* 1은 이미 익은 토마토 0은 익지 않은 토마토
 * -1은 빈 공간
 * 상자안에 있는 토마토가 다 익을 경우 얼마나 걸리는 가?( 다안익으면 -1 출력)
 * 최소 일수 구하는 프로그램 , BFS + 4방탐색
 * */

class Point {// 좌표값 들고갈 클래스
	int i;
	int j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class BOJ_7576_Tomato {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };// 상하좌우
	static int[] dj = { 0, 0, -1, 1 };
	

	private static void BFS(int starti, int startj, int day) {
		Queue<Point> q = new LinkedList<>();
		// 큐에 넣을 거 찾는 반복문, 익은 토마토 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					q.add(new Point(i, j));// 익은 토마토 찾아서 Point클래스를 이용해서 좌표값 전달
			}
		}

		while (!q.isEmpty()) {// 더이상 탐색할 것이 없으면 끝남
			Point point = q.poll(); // 큐에서 하나꺼내와서 포인트 객체만들기

			// 상하좌우에 있는 토마토 탐색하기
			for (int i = 0; i < 4; i++) {
				int nexti = point.i + di[i];
				int nextj = point.j + dj[i];
				
				//인덱스 범위를 확인
				if(0<=nexti && nexti<N && 0<=nextj && nextj<M && !visited[nexti][nextj] ) {
					visited[nexti][nextj] = true;
					q.add(new Point(nexti,nextj));
				}
				
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		// i, j가 바뀌어서 받고 있음
		N = Integer.parseInt(str[1]); // j
		M = Integer.parseInt(str[0]); // i

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {// 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS(N, M, 0);

	}

}
