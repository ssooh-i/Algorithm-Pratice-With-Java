package workshop.ws0810;

//https://www.acmicpc.net/problem/16926
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16926_배열돌리기1 {
	private static int[] dx = {0,1,0,-1};  //반시계방향(하우상좌)
	private static int[] dy = {1,0,-1,0};  
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //행
		int M = Integer.parseInt(st.nextToken()); //열
		int R = Integer.parseInt(st.nextToken()); //회전 수
		
		int[][] map = new int[N][M]; //배열 선언
		
		//배열에 데이터 입력
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//회전해야 할 사각형의 수---------------------------------------------------------
		//2*2 행렬에서는 1개, 5*5에서는 2개, 4*5에서는 2개, 최솟값을 2로 나누면 그룹 수가 나온다
		//이 규칙에서 항상 시작점은 x,y값이 같은 값에서 시작
		int cnt = Math.min(N, M) / 2;  
		
		//회전횟수
		for(int i=0;i<R;i++) {
			//그룹 갯수만큼 반복
			for(int j=0;j<cnt;j++) {
				int x = j;
				int y = j;
				
				//나중에 값을 넣기 위해 따로 저장
				int tmp = map[x][y];
				int dic=0;      // 방향
				
				while(dic<4) {
					int nx = x + dx[dic];
					int ny = y + dy[dic];
					
					if(nx>=j && ny>=j && nx<N-j && ny<M-j) {  //범위 내에 있을 경우 돌리기
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					}else {                                   //범위 벗어나면 방향 전환
						dic++;
					}
				}
				map[j+1][j] = tmp;
			}
		}//end for
		
		//출력--------------------------------------------------------------------------------
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
/*
[입력]
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

[출력]
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
-----------------------
[입력]
5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28

[출력]
28 27 26 25
22 9 15 19
16 8 21 13
10 14 20 7
4 3 2 1
-----------------------
[입력]
2 2 3
1 1
1 1

[출력]
1 1
1 1
-----------------------
*/