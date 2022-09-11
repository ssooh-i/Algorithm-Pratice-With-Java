package samsumg01.exam1;

//1. 전기 자동차 충전소
/*
 * 전기 자동차 충전소와 N개의 집 사이의 거리 합이 최소가 되는 값을 출력
 * 
 * 충전소의 개수는 최소한의 개수만 지어야하고 최대 2개
 * 충전소를 2개 지을 경우 각 집과 충전소간 거리는 가까운 충전소를 기준으로 한다
 * 충전소를 2개를 지어도 전기자동차를 구입할 수 없는 집이 있으면 -1출력
 * 집의 위치에는 충전소를 지을 수 없다
 * 
 * 집 위치를 기준으로 받은 거리를 4방탐색해서 +1로 바꿔줌
 * 모든 집을 탐색하고 그 중 max값을 찾아냄
 * max 값이 하나라면 거기에 충전소를 지으면 되고
 * 만약 max값이 여러개라면 2개의 충전소만 설치, 만약 충전소가 더 필요하다면 -1반환
 * 
 * 충전소에서 각 집의 거리의 합을 구해서 result반환
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;
	static int[] tam;//탐색할 범위 저장하는 배열
	static int[][] map; //map범위 

	static int max;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[30][30];
			arr = new int[N][N];
			tam = new int[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			BFS(N, N);
			
			System.out.println("#" + tc + " " + (max - 1));
		}
	}

	public static void BFS(int N, int M) {
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1)
					// 집의 위치를 q에 모두 담는다
					q.add(new Point(i, j));
			}
		}

		while (!q.isEmpty()) {
			// 상하좌우는 큐에 담아야한다.
			Point point = q.poll();
			for (int i = 0; i < 4; i++) {// 4방탐색
				int nextX = point.x + dx[i];
				int nextY = point.y + dy[i];

				// 인덱스 확인
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				// 다음 위치에 집이 없으면 패스
				if (arr[nextX][nextY] != 0) {
					continue;
				}
				arr[nextX][nextY] = arr[point.x][point.y] + 1;
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