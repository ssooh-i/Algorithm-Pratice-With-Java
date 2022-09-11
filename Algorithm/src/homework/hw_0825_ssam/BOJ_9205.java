package homework.hw_0825_ssam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 9205 - 맥주 마시면서 걸어가기
public class BOJ_9205 {
	static int N;
	static int beer;
	static int[] martY, martX;
	static int fy, fx;

	static void GO(int y, int x) {
		

		for (int i = 0; i < N; i++) {
			int nextY = y + martY[i];
			int nextX = x + martX[i];
			
			
			
			if (x == nextX) {// X가 같을 때
				beer = beer - ((nextY - y) / 50);
				if(beer >= 0 && (x == nextX && y == nextY)) {//맥주도 덜썼고 다음꺼랑 같으면
					beer = 20;
					GO(nextY, nextX);
				}

			} 
			if (y == nextY) {// Y가 같을 때
				beer = beer - ((nextX - x) / 50);
				if(beer >= 0 && (x == nextX && y == nextY)) {//맥주도 덜썼고 다음꺼랑 같으면
					beer = 20;
					GO(nextY, nextX);
				}
			}
			if (x != nextX && y != nextY) {// 둘 다 다를 때
				beer = beer - ((nextX - x) / 50);
				beer = beer - ((nextY - y) / 50);
				if(beer >= 0 && (x == nextX && y == nextY)) {//맥주도 덜썼고 다음꺼랑 같으면
					beer = 20;
					GO(nextY, nextX);
				}
				
			}
			if(nextY == fy && nextX == fx) {
				if (beer < 0) {
					System.out.println("sad");
				} else {
					System.out.println("happy");
				}
				
			}

			
		}
		
		return;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());// 편의점수
			beer = 20;
			String[] sang = br.readLine().split(" ");
			int sy = Integer.parseInt(sang[0]);// 상근이네 집 좌표
			int sx = Integer.parseInt(sang[1]);

			martY = new int[N ];
			martX = new int[N ];

			for (int i = 0; i < N; i++) {// 편의점+페스티벌장소
				String[] mart = br.readLine().split(" ");
				martY[i] = Integer.parseInt(mart[0]);// 편의점 좌표
				martX[i] = Integer.parseInt(mart[1]);
			}
			
			String[] festival = br.readLine().split(" ");
			fy = Integer.parseInt(festival[0]);// 편의점 좌표
			fx = Integer.parseInt(festival[1]);

			GO(sy, sx);

		}
	}

}
