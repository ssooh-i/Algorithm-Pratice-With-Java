package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//기상캐스터
public class s5_10709 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];

		for (int i = 0; i < H; i++) {// 입력받기
			String str = br.readLine();
			int n = str.length(); //W로 대체 가능

			char[] arr = new char[n];
			for (int k = 0; k < n; k++) { // arr 안쓰고 바로 넣어도 됨
				arr[k] = str.charAt(k);
			}
			
			for (int j = 0; j < W; j++) {
				if (arr[j] == 'c') {// 구름이면 0
					map[i][j] = 0;
				} else {// .은 -1로
					map[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < H; i++) {//map범위만큼 탐색하기
			for (int j = 0; j < W; j++) {

				if (map[i][j] == 0) {// 0이라면 구름자리인 것
					int cnt = 1;// 1초부터 계산

					for (int k = j + 1; k < W; k++) {// 오른쪽으로만 이동, j+1한 이유는 j는 구름 자리

						if (map[i][k] == 0) {// 오른쪽으로 가다가 구름을 만나면 거기는 건너뛰기
							break;
						} else {
							map[i][k] = cnt;// cnt로 바꿔주고 +1 해주기
							cnt++;
						}
					}
				} else {
					continue;
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
