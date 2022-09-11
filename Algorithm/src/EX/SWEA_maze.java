package EX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//SWEA - 미로2 
public class SWEA_maze {

	static int[][] map;
	static boolean[] visited;
	static int tmp;
	static int start, end;

	static int[] di = { 0, 0, 1, -1 }; // 좌우상하
	static int[] dj = { 1, -1, 0, 0 };

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));

		while (!q.isEmpty()) {// q 안에 값이 있으면 계속 돌아감
			Point now = q.poll(); // 지금 사용할 꺼

			for (int d = 0; d < 4; d++) {// 4방탐색
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if (nexti >= 0 && nexti < 100 && nextj >= 0 && nextj < 100 && map[nexti][nextj] == map[now.i][now.j] + 1) {
					q.add(new Point(nexti, nextj));
					tmp++;
					break;
				}

			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			map = new int[100][100];
			start = 0;
			end = 0;
			tmp=1;
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						//start;
					}
				}
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					bfs(i,j);
					
					
				}
			}
			// 출력
//		for(int i = 0; i<100; i++) {
//			for(int j = 0; j<100; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}

			System.out.println("#" + tc + " ");
		}

	}
}
