package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//경쟁적전염
public class s5_18405 {
	static int[] dy = { 1, -1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];

		Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.time != o2.time)
					return o1.time - o2.time;
				else
					return o1.virus - o2.virus;
			}
		});

		for (int i = 0; i < N; i++) { // map배열 입력받기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // y == i, x == j
				if (map[i][j] != 0) {// 비어있지 않다면 큐에 추가
					queue.add(new Node(i, j, map[i][j], 0)); // 0초일 때, 맨처음 입력받는 큐, 객체로 넣기
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); //몇초뒤에 X,Y 자리에 있는 바이러스 번호를 알고싶음
		int X = Integer.parseInt(st.nextToken()) - 1;//(0, 0) 부터가 아니라 (1,1)로 값을 받아서 -1 해줌
		int Y = Integer.parseInt(st.nextToken()) - 1;

		int cnt = 0; // 최종적으로 몇번 걸리는 지 리턴해 줄 변수

		while (!queue.isEmpty()) {
			int size = queue.size();// 큐 사이즈만큼 돌면 cnt 증가시키기
			// S초 뒤에 존재하는 결과를 보고 싶은거니까 현재 cnt가 S랑 똑같아지면 그만돌리기
			if (cnt++ >= S)
				break;

			for (int q = 0; q < size; q++) {
				Node now = queue.poll();
				int y = now.y;
				int x = now.x;
				int virus = now.virus;

				for (int i = 0; i < 4; i++) {// 사방탐색
					int nextY = dy[i] + y;
					int nextX = dx[i] + x;
					if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || map[nextY][nextX] != 0) {
						continue; //범위안의 값이 아니고 다음자리가 0이 아니면 다음 꺼 검사하기
					}
						map[nextY][nextX] = virus; // 지금 가지고 있는 번호의 바이러스 추가
						queue.add(new Node(nextY, nextX, virus, cnt));// 지금 몇초인지를 함께 가져감
				}
			}//size만큼의 for문 종료
			
//			for(int i=0; i<N; i++) {//감염되는거 확인하는 for문 (한바퀴 다돌면)
//				System.out.println(Arrays.toString(map[i]));
//			}System.out.println();
			
		}
		//최종적으로 S초 뒤의 map[X][Y]자리 출력
		System.out.println(map[X][Y]);//<<X,Y자리 헷갈리지 말기

	}

	static class Node {
		int y, x, virus, time;

		Node(int y, int x, int virus, int time) {
			this.y = y;
			this.x = x;
			this.virus = virus;
			this.time = time;
		}
	}
}
