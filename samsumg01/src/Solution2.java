import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2. 전원연결
/*
 * 가장 자리에 있는 core은 연결되어있다고 치기, 연결 안되는 코어도 있음
 * 
 * 입력 받을 때 core위치를 받아서 point 객체에 넣어서 q에 넣어주기 0
 * q가 비어있지 않다면 while문 실행 0
 * q에서 가지고 온 코어 하나를 가지고 와서 0
 * 4방 탐색을 할 꺼임 0 
 * 0일 때 전진할 수 있고 1을 만난다면 그 값은 저장안하고 return 0
 * 만약 인덱스 끝까지 0번이나 n-1자리까지 전진을 했다면 그 길이를 저장한다
 * 4방으로 모두 전진만 진행하고 4개의 값이 return되어 돌아올 때
 * 그 중 가장 적은 수인 곳을 찾고
 * 그 줄을 1로 모두 바꿔준다 (다른 코어가 진행될때 갈 수 없게 조치)
 * 다른 코어 진행하면서 합을 계속 더해주고
 * 마지막 q에 들은 point 객체까지 불러 와서 실행하기
 * 가장 짧은 거리의 합들로만 이루어진 result를 반환해서 정답 제출하기
 * 
 * */

public class Solution2 {
	static int[] dx = { -1, 1, 0, 0 };//좌우상하
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;

	static int max;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {//입력받기
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			
			BFS(N, N);
			
			System.out.println("#" + tc + " " + (max - 1));
		}
	}

	public static void BFS(int N, int start) {
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1)
					// 코어의 위치를 q에 모두 담는다
					q.add(new Point(i, j));//포인트객체로 위치 전달
			}
		}

		while (!q.isEmpty()) {
			Point point = q.poll();//하나 꺼내오기
			
			//좌
			int[][] map = arr.clone();
			int x1 = 0;
			for (int i = point.x; i <= 0; i--) {// 4방탐색
				int nextX = point.x + dx[0];
				int nextY = point.y + dy[0];
				
				// 인덱스 범위 확인
				if (nextX <= 0) {
					map[nextX][nextY] = map[point.x][point.y] + i; // 다음 위치
					q.add(new Point(nextX, nextY));
					x1++;
				}
				if (map[nextX][nextY] != 0) {
					continue;
				}
				return;
				
				
			}
			System.out.println(x1);
			
			
			
			
			
			
			// 상하좌우는 큐에 담기
			for (int i = 0; i < 4; i++) {// 4방탐색
				int nextX = point.x + dx[i];
				int nextY = point.y + dy[i];
				
				// 인덱스 범위 확인
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				// 다음 위치에 0이 아닌게 들어있으면 나가기
				if (arr[nextX][nextY] != 0) {
					continue;
				}
				arr[nextX][nextY] = arr[point.x][point.y] + 1; // 다음 위치
				q.add(new Point(nextX, nextY));
			}
		}
		
		
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		//System.out.println(max - 1);

	}
}

class Point { // 좌표값 들고갈 포인트 클래스
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}