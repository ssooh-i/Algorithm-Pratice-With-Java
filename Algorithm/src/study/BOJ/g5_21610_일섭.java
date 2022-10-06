package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class g5_21610_일섭 {

	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static List<Cloud> clouds;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// map크기
		M = Integer.parseInt(st.nextToken());// 명령어 수

		map = new int[N][N];

		for (int i = 0; i < N; i++) { // map초기값 입력받기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clouds = new ArrayList<>();

		// 초기 구름 위치 추가
		clouds.add(new Cloud(N - 1, 0));
		clouds.add(new Cloud(N - 2, 0));
		clouds.add(new Cloud(N - 1, 1));
		clouds.add(new Cloud(N - 2, 1));

		for (int i = 0; i < M; i++) { // 명령어 입력받기
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;// d, 이동 번호, 1부터 시작해서 -1해준다
			int dist = Integer.parseInt(st.nextToken());// s, 이동 횟수 = 거리

			visited = new boolean[N][N];// 구름이 있던 곳 체크할 배열

			moveCloud(dir, dist, N);
			waterCopy();

			// 새로운 구름 만들 곳
			clouds = new ArrayList<>();
			// 새로운 구름 생성
			for (int n = 0; n < N; n++) {// 2차원배열 탐색
				for (int m = 0; m < N; m++) {
					// 기존에 구름이 있었으면 패스, 없었으면 2이상인지 판별해서 new 구름해주기
					if (visited[n][m]) {
						continue;
					} else {
						if (map[n][m] >= 2) {
							map[n][m] -= 2;
							clouds.add(new Cloud(n, m)); // 좌표넘겨주면서 구름 생성
						}
					}
				}
			}
		} // for문 끝 출력하기

		int total = 0;

		// 연습 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				total += map[i][j];
				// System.out.print(map[i][j]+" ");
			} // System.out.println();
		}

		System.out.println(total);

	}

	// 구름 이동
	static void moveCloud(int d, int s, int N) {
		for (int j = 0; j < clouds.size(); j++) { // 구름 이동
			Cloud c = clouds.get(j);
			// d방향으로 s번 이동
			for (int i = 0; i < s; i++) {
				c.y = c.y + dy[d]; // nextY로 안 만든 이유는 그냥 대입하려고
				c.x = c.x + dx[d];

				// 경계 밖으로 넘어가면 반대방향으로 보내기
				if (c.y < 0) {
					c.y += N;
				} else if (c.y >= N) {
					c.y -= N;
				}
				if (c.x < 0) {
					c.x += N;
				} else if (c.x >= N) {
					c.x -= N;
				}
			}
			visited[c.y][c.x] = true;// s번 만큼 이동하고 구름이 있는 자리 체크
			map[c.y][c.x] += 1; // 비 온 뒤 바구니 물 양+1
		}
	}

	// 물복사버그
	static void waterCopy() {// 지금 위치에서 있는 대각선에 물이 들어있으면 +1
		// 대각선 1,3,5,7
		for (int j = 0; j < clouds.size(); j++) {
			Cloud c = clouds.get(j);
			for (int i = 1; i < 8; i += 2) {
				int nextY = c.y + dy[i];// 다음 위치를 보고 현재자리에 더해줘야하니까 대입X
				int nextX = c.x + dx[i];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) {// 범위체크
					continue;
				}
				if (map[nextY][nextX] != 0) {// 물이 있으면 물 +1
					map[c.y][c.x]++;
				}
			}
		}
	}

	static class Cloud {
		int y;
		int x;

		Cloud(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
