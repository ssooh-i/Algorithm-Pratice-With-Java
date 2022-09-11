package workshop.ws0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail_D2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<T+1; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];//n*n배열
			int len = N*N+1;
			int now_x = 0;//현재위치
			int now_y = 0;
			
			//동남서북
			int[] x_idx = {1, 0, -1, 0}; 
			int[] y_idx = {0, 1, 0, -1};
			int D = 0;
			
			for(int i=1; i< len; i++) {//값 채워줄 for문
				arr[now_y][now_x] = i;
				
				int next_y = now_y +y_idx[D];
				int next_x = now_x +x_idx[D];
				
				if((next_y >= N)||(next_x>=N)) {//범위설정
					if(D == 3) {//한바퀴 동남서북 돌면 다시 0번째 자리로 보내기
						D = 0;
					}else {
						D +=1;
					}
					
				}else if ((next_y < 0)||(next_x < 0)) {
					if(D == 3) {
						D = 0;
					}else {
						D +=1;
					}
				}else if(arr[next_y][next_x] != 0) {
					if(D == 3) {
						D = 0;
					}else {
						D +=1;
					}
				}
				now_y += y_idx[D];
				now_x += x_idx[D];
			}
			
			
			System.out.println("#"+t+" ");
			
			for(int i = 0; i<arr.length; i++) {
				for(int j = 0; j<arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}System.out.println();
			}
		}
		
	}
}
