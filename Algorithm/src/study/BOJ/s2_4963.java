package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//섬의 개수
public class s2_4963 {

	static int W; // 너비
	static int H; // 높이
	static int[][] map; // 지도 들어갈 곳
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 }; // 8방탐색
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean[][] visited; // 방문 체크
	static int cnt; // 섬의 개수
	
	public static void DFS(int i, int j) { //i = y = h, j = x = w
		
		for(int k=0; k<8; k++) {//8방 탐색
			int nextY = i + dy[k];
			int nextX = j + dx[k];
			//범위 체크
			if(0<=nextX && nextX<W && 0<=nextY && nextY<H ) {
				if(map[nextY][nextX] == 1 && !visited[nextY][nextX]) {//다음 지도좌표가 섬(1)이고 방문을 안했다면 방문하기	
					visited[nextY][nextX] = true; //지금 들어온 값 방문했다고 표시
					DFS(nextY, nextX);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) {
				//System.exit(0); // 시스템 종료
				break;
			}

			map = new int[H][W]; // 지도 생성
			visited = new boolean[H][W]; // 지도 만큼 체크 배열생성

			for (int i = 0; i < H; i++) {// 지도 입력받기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0; // 섬 개수 초기화

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					//dfs에 들어가면 cnt증가
					if(map[i][j] == 1 && !visited[i][j]) {//지도좌표가 섬(1)이고 방문을 안했다면 방문하기
						visited[i][j] = true;
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
