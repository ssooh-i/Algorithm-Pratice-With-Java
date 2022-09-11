package workshop.ws0824;

import java.io.BufferedReader;
import java.io.IOException;
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
public class BOJ_7576_Tomato_2 {
	static int[][] map;
	static int ans; // 모든 토마토가 익는데 걸린 날짜
	static int M, N; // M:가로=j, N:세로=i

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // j
		N = Integer.parseInt(st.nextToken()); // i

		map = new int[N][M];

		Queue<Tomato> queue = new LinkedList<>();// BFS는 큐

		for (int i = 0; i < N; i++) {// 입력받기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // map에 넣으면서 익은 토마토는 큐에 넣어주기
					queue.add(new Tomato(i, j, 0)); // day=0으로 객체 만들어서 큐에 담기
				}
			}
		}

		while (!queue.isEmpty()) {// 더이상 탐색할 것이 없으면 끝남
			Tomato now = queue.poll(); // 지금 일할 토마토를 하나꺼내서 now객체로 만들기

			ans = now.day;// 지금 몇일 차인지 들고오기

			for (int d = 0; d < 4; d++) {// 상하좌우에 있는 토마토 탐색하기
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];

				// 인덱스확인 + 익지 않은 토마토인지 확인
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && map[nexti][nextj] == 0) {
					queue.add(new Tomato(nexti, nextj, now.day + 1));//다음 날에 익는 거니까 +1로 전달
					map[nexti][nextj] = 1;//익은토마토니까 1로 바꿔주기
				}
			}
		}
		
		//익지 않은 토마토가 있는 지 확인하는 for문
		//0이 발견되면 -1출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					ans = -1;
			}
		}
		
		//결과출력
		System.out.println(ans);
	}

	static class Tomato {
		int i, j, day;

		Tomato(int i, int j, int day) {
			this.i = i;
			this.j = j;
			this.day = day;
		}
	}
}
