package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//마법사 상어와 비바라기
public class g5_21610 {
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] cloud, map, command;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// map크기
		M = Integer.parseInt(st.nextToken());// 명령어 수

		map = new int[N][N];

		int[][] cloud = { {0, N-1}, {1, N-1}, {0, N-2}, {1, N-2} };
		
		for(int i =0; i<N; i++) { //map초기값 입력받기
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		command = new int[M][2];//명령어 저장 공간
		
		for(int i = 0; i<M; i++) { //명령어 입력받기
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//이동 번호
			int b = Integer.parseInt(st.nextToken());//이동 횟수
			moveDir(new Command(a, b));
		}
		
		
		
		//=============================연습 출력
		
		System.out.println("----map----");
		for(int i = 0; i<N; i++) { //명령어 입력받기
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println("----command----");
		for(int i = 0; i<M; i++) { //명령어 입력받기
			System.out.println(Arrays.toString(command[i]));
		}
		
	}

	static void moveDir(Command command) { //이동 방향 결정
		switch(command.a) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
			
		}
		
	}
}

class Command {
	int a;
	int b;
	Command(int a, int b){
		this.a = a;
		this.b = b;
	}
}
