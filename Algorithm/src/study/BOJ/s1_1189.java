package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//컴백홈
public class s1_1189 {
	static int R, C, K;
	static char[][] map;
	static int[][] visited;//방문체크
	static int answer; //정답 출력할 변수

	static int[] moveR = { 1, -1, 0, 0 }; //상하
	static int[] moveC = { 0, 0, 1, -1 }; //좌우

	static void dfs(int r, int c, int moved) {
		// 도착한다면 answer+1 해주기
		if (r == 0 && c == C - 1) {
			if (moved == K)
				answer++;
			return;
		}
		
		//사방탐색
		for (int i = 0; i < 4; i++) {
			int nextR = r + moveR[i];
			int nextC = c + moveC[i];
			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)//범위체크
				continue;
			if (visited[nextR][nextC] == 1 || map[nextR][nextC] == 'T')//T면 갈 수 없는 곳
				continue;//다음 꺼로 넘어가셈
			visited[nextR][nextC] = 1;//방문체크 O
			dfs(nextR, nextC, moved + 1);
			visited[nextR][nextC] = 0; //방문체크 X

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());// y
		C = Integer.parseInt(st.nextToken());// x
		K = Integer.parseInt(st.nextToken());// k 몇 거리만에 도착

		// 탐색, T: 못가는 길, K번째까지 탐색하려고 dfs사용
		// 출발지 (R-1,0) 도착 (0, C-1)

		map = new char[R][C]; //입력받은 지도
		visited = new int[R][C]; //방문체크

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		visited[R - 1][0] = 1;//출발지 방문체크 1이 들었으면 방문한 것으로 체크
		dfs(R - 1, 0, 1);//출발지

		System.out.println(answer);

	}

}
