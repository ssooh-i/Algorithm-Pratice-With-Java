package workshop.ws0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//9명 중에 7명 뽑을 껀대, 7명의 합이 100이 되어야함
//순서상관없고 중복 안됨 => 조합?
public class BOJ_3040 {
	static boolean[] visited;
	static int[] dwarf;

	static void loop(int d) {
		if (d == 7) {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (visited[i]) {
					sum += dwarf[i];
				}
			}

			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (visited[i]) {
						System.out.println(dwarf[i]);
					}
				}
				System.exit(0);
			}
			return;
		}

		// visited 체크하기, 재귀함수
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				loop(d + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean[9];
		dwarf = new int[9];

		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		loop(0);

	}
}
