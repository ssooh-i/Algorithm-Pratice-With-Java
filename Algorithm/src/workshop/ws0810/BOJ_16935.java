package workshop.ws0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int N, M;

	static String[][] rotate1(String[][] matrix) {
		String[][] result = new String[N][M];
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				result[N - i - 1][j] = matrix[i][j];
			}
		}
		return result;
	}

	static String[][] rotate2(String[][] matrix) {
		String[][] result = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][M - j - 1] = matrix[i][j];
			}
		}
		return result;
	}

	static String[][] rotate3(String[][] matrix) {

		String[][] result = new String[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[j][N - 1 - i] = matrix[i][j];
			}
		}
		int temp = M;
		M = N;
		N = temp;

		return result;
	}

	static String[][] rotate4(String[][] matrix) {
		String[][] result = new String[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[M - 1 - j][i] = matrix[i][j];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		return result;
	}

	static String[][] rotate5(String[][] matrix) {
		String[][] result = new String[N][M];
		// 1->2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j + (M / 2)] = matrix[i][j];
			}
		}
		// 2->3
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i + (N / 2)][j] = matrix[i][j];
			}
		}
		// 3->4
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i][j - (M / 2)] = matrix[i][j];
			}
		}
		// 4->1
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i - (N / 2)][j] = matrix[i][j];
			}
		}
		return result;
	}

	static String[][] rotate6(String[][] matrix) {
		String[][] result = new String[N][M];
		// 1->4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i + (N / 2)][j] = matrix[i][j];
			}
		}
		// 4->3
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j + (M / 2)] = matrix[i][j];
			}
		}
		// 3->2
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i - (N / 2)][j] = matrix[i][j];
			}
		}
		// 2->1
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				result[i][j - (M / 2)] = matrix[i][j];
			}
		}
		return result;
	}

	static void print(String[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// Y
		M = Integer.parseInt(st.nextToken());// X
		int R = Integer.parseInt(st.nextToken());// 연산 몇번 할 지

		String[][] matrix = new String[N][M];// Y X

		for (int i = 0; i < N; i++) {// 입력받기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = st.nextToken();
			}
		}

		int[] command = new int[R];// 명령어 넣을 공간
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		for (int r = 0; r < R; r++) {// R개수만큼 반복
			// 연산 명령어 번호
			if (command[r] == 1) {
				matrix = rotate1(matrix);

			} else if (command[r] == 2) {
				matrix = rotate2(matrix);

			} else if (command[r] == 3) {
				matrix = rotate3(matrix);

			} else if (command[r] == 4) {
				matrix = rotate4(matrix);

			} else if (command[r] == 5) {
				matrix = rotate5(matrix);

			} else if (command[r] == 6) {
				matrix = rotate6(matrix);

			}
		}
		print(matrix);
	}
}
