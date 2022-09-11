package homework.hw_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA_1861 - 정사각형 방(반복문ver)
public class SWEA_1861 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {// 입력받기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 위치찾기
			int a = 0;
			int[] dy = { -1, 1, 0, 0 }; // 상하좌우
			int[] dx = { 0, 0, -1, 1 };
			int d = 0; // 현재 위치 인덱스 표시
			int count = 1; // 지금 들어간 방부터 1임
			int max_y = 0; // 진행 많이 된 곳 좌표 저장
			int max_x = 0;
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a = arr[i][j]; // 들어있는 값 저장//위치에 들은 값 확인
					//index 범위 확인
					int nextY = i+dy[d];//다음 좌표
					int nextX = i+dx[d];
					a = arr[nextY][nextX];
					
					if (0 <= nextY && nextY + i < N && 0 <= nextX && nextX < N) {
						if(arr[nextY][nextX]-1 == arr[i][j]) {
							arr[nextY][nextX] = arr[i][j];// 현재 값을  next자리에 넣어주기
							i = nextY;
							j = nextX;
						}else {
							if (d == 3) {// 방향 전환
								d = 0;
							} else {
								d++;
							}
							nextY = i + dy[d]; // 다음 좌표 다시 주기
							nextX = j + dx[d]; // 기본형변수는 넘겨주면 끝

							arr[nextY][nextX] = arr[i][j]; // 방향전환하고 그 다음 자리에 값 설정하기
							i = nextY;
							j = nextX;
						}
						
					}
				}
			}

			// 상하좌우 판단 & +1인 값이 있다면?
			// 있는 곳으로 위치 바꾸고 cnt++해서 가기
			// 없으면 지금 cnt 기록

//			for(int i=0; i<N; i++) {//확인용 배열 출력
//				System.out.println(Arrays.toString(arr[i]));
//			}

		}

	}
}
