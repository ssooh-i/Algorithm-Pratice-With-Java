package workshop.ws0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2563 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		StringTokenizer st;

		boolean[][] matrix = new boolean[100][100]; // 100*100

		int sum = 0;

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if ((y + j) < 100 && (x + k) < 100) {
						if (!matrix[y + j][x + k]) {
							matrix[y + j][x + k] = true;
							sum++;
						}
					}
				}
			}
		}
		System.out.println(sum);

	}
}
