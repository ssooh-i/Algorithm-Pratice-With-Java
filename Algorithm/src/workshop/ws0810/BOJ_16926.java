package workshop.ws0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // Y
		int M = Integer.parseInt(st.nextToken()); // X
		int R = Integer.parseInt(st.nextToken());

		int level = Math.min(N, M) / 2;// 안에 얼마나 들어가야하는 지

		String[][] matrix = new String[N][M];// Y X
		String[][] matrix2 = new String[N][M];// 복사해서 값 넣을 공간

		for (int i = 0; i < N; i++) {// 입력받기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = st.nextToken();
			}
		}

		int[] dy = { 1, 0, -1, 0 };// 이동할 방향
		int[] dx = { 0, 1, 0, -1 };
		int d = 0; // 현재 진행방향

		for (int r = 0; r < R; r++) {// 전체 돌리는 R 수
			for (int l = 0; l < level; l++) {// 몇 바퀴 들어갈까
				int X = l;// 현재 좌표
				int Y = l;
				int cnt = ((N - 1) * 2) - (4 * l) + ((M - 1) * 2) - (4 * l);

				for (int c = 0; c < cnt; c++) {
					int nextY = Y + dy[d]; // 다음 좌표
					int nextX = X + dx[d];
					if (0 + l <= nextY && nextY < N - l && 0 + l <= nextX && nextX < M - l) { // 인덱스 안의 값이라면 들어가기
						matrix2[nextY][nextX] = matrix[Y][X];// 현재 값을 matrix2 next자리에 넣어주기
						Y = nextY;
						X = nextX;

					} else {
						if (d == 3) {// 방향 전환
							d = 0;
						} else {
							d++;
						}
						nextY = Y + dy[d]; // 다음 좌표 다시 주기
						nextX = X + dx[d]; // 기본형변수는 넘겨주면 끝

						matrix2[nextY][nextX] = matrix[Y][X]; // 방향전환하고 그 다음 자리에 값 설정하기
						Y = nextY;
						X = nextX;
					}

				}

			}

			for (int i = 0; i < N; i++) {
				matrix[i] = Arrays.copyOf(matrix2[i], matrix[i].length);
			}

		}

		for (int i = 0; i < N; i++) {// 출력하기
			for (int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}
