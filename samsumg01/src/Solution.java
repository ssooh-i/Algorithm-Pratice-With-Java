//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
////2. 전원연결
///*
// * 가장 자리에 있는 core은 연결되어있다고 치기, 연결 안되는 코어도 있음
// * 
// * 입력 받을 때 core위치를 받아서 point 객체에 넣어서 q에 넣어주기 0
// * q가 비어있지 않다면 while문 실행 0
// * q에서 가지고 온 코어 하나를 가지고 와서 0
// * 4방 탐색을 할 꺼임 0 
// * 0일 때 전진할 수 있고 1을 만난다면 그 값은 저장안하고 return 
// * 만약 인덱스 끝까지 0번이나 n-1자리까지 전진을 했다면 그 길이를 저장한다
// * 4방으로 모두 전진만 진행하고 4개의 값이 return되어 돌아올 때
// * 그 중 가장 적은 수인 곳을 찾고
// * 그 줄을 1로 모두 바꿔준다 (다른 코어가 진행될때 갈 수 없게 조치)
// * 다른 코어 진행하면서 합을 계속 더해주고
// * 마지막 q에 들은 point 객체까지 불러 와서 실행하기
// * 가장 짧은 거리의 합들로만 이루어진 result를 반환해서 정답 제출하기
// * 
// * */
//
//public class Solution {
//	static int[] dx = { -1, 1, 0, 0 };// 좌우상하
//	static int[] dy = { 0, 0, -1, 1 };
//	static int[][] arr;
//	static int maxCore;
//	static int minLen;
//
//	public static void main(String args[]) throws Exception {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//
//		for (int tc = 1; tc <= T; tc++) {
//			int N = Integer.parseInt(br.readLine());
//
//			arr = new int[N][N];
//
//			for (int i = 0; i < N; i++) {// 입력받기
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {
//					arr[i][j] = Integer.parseInt(st.nextToken());
//
//				}
//			}
//			//result = 0;
//			BFS(N, N);
//
//			//System.out.println("#" + tc + " " + result);
//		}
//	}
//
//	static int search(Queue<Point> q) {
//		int sum = 0;
//		int core = 0;
//		
//		while (!q.isEmpty()) {
//			Point point = q.poll();
//
//			int min = Integer.MAX_VALUE;
//			Queue<Point> path = new LinkedList<>();
//
//			for (int i = 0; i < 4; i++) {
//				
//				int nextY = point.y;
//				int nextX = point.x;
//				int cnt = 0;
//				
//				Queue<Point> temp = new LinkedList<>();
//				
//				while (true) {
//
//					nextY = nextY + dy[i];
//					nextX = nextX + dx[i];
//
//					if (0 <= nextY && nextY < arr.length && 0 <= nextX && nextX < arr[nextY].length) {
//						if (arr[nextY][nextX] != 0) {
//							break;
//						}
//						cnt++;
//						temp.add(new Point(nextY, nextX));
//					} else {
//						min = Math.min(min, cnt);
//						//if(min  cnt) {
//							
//						//}
//						break;
//					}
//
//				}
//
//			}
//			if (min != Integer.MAX_VALUE) {
//				sum += min;
//				core++;
//				while(!path.isEmpty()) {
//					
//				}
//			}
//			
//		}
//		if (core > maxCore) {
//			maxCore = core;
//			minLen = sum;
//		}
//		else if(core == maxCore) {
//			minLen = Math.min(minLen, sum);
//		}
//	}
//
//	public static void BFS(int N, int start) {
//		Queue<Point> q = new LinkedList<Point>();
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (arr[i][j] == 1)
//					// 코어의 위치를 q에 모두 담는다
//					q.add(new Point(i, j));// 포인트객체로 위치 전달
//			}
//		}
//
//		while (!q.isEmpty()) {
//			Point point = q.poll();// 하나 꺼내오기
//
//			if (point.x == 0 || point.x == N - 1 || point.y == 0 || point.y == N - 1) {// 코어 값이 가장자리면 pass
//				continue;
//			}
//
//			int[] val = new int[4];
//			// 좌
//			int[][] map1 = arr.clone();
//			int x1 = 0;
//			for (int i = point.x; i >= 0; i--) {
//				int nextX = point.x + dx[0];
//				if (map1[nextX][point.y] != 0) {
//					break;
//				} else {
//					x1++;
//				}
//			}
//			val[0] = x1;
//
//			// 우
//			int[][] map2 = arr.clone();
//			int x2 = 0;
//			for (int i = point.x; i < N; i++) {
//				int nextX = point.x + dx[1];
//				if (map2[nextX][point.y] != 0) {
//					continue;
//				} else {
//					x2++;
//				}
//			}
//
//			val[1] = x2;
//
//			// 상
//			int[][] map3 = arr.clone();
//			int y1 = 0;
//			for (int i = point.y; i >= 0; i--) {
//				int nextY = point.y + dy[2];
//				if (map3[point.x][nextY] != 0) {
//					continue;
//				} else {
//					y1++;
//				}
//			}
//			val[2] = y1;
//
//			// 하
//			int[][] map4 = arr.clone();
//			int y2 = 0;
//			for (int i = point.y; i < N; i++) {
//				int nextY = point.y + dy[3];
//				if (map4[point.x][nextY] != 0) {
//					continue;
//				} else {
//					y2++;
//				}
//			}
//			val[3] = y2;
//
////			min = Integer.MAX_VALUE;
////			for (int i = 0; i < 4; i++) {
////				min = Math.min(min, val[i]);
////			}
////
////			result += min;
//
//		}
//	}
//}
//
//class Point { // 좌표값 들고갈 포인트 클래스
//	int y;
//	int x;
//
//	Point(int y, int x) {
//		this.y = y;
//		this.x = x;
//	}
//}