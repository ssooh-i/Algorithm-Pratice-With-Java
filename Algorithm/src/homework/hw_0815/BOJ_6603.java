package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 6603 - 로또
public class BOJ_6603 {
	static int N;
	static int[] arr;
	static boolean[] result;
	static StringTokenizer st;

	private static void Pick(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < N; i++) {
				if (result[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}

		for (int i = start; i < N; i++) {
			result[i] = true;
			Pick(i + 1, depth + 1);
			// 출력하고 돌아올땐 다시 사용해야 하므로 false로
			result[i] = false;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}
			arr = new int[N];
			result = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Pick(0, 0);
			System.out.println();

		}
	}

}