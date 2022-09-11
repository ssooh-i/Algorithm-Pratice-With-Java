package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 2차원 배열의 합
public class b1_2167_다시풀기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] ij = new int[K][2];
		int[][] xy = new int[K][2];
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			ij[i][0] = Integer.parseInt(st.nextToken())-1;
			ij[i][1] = Integer.parseInt(st.nextToken())-1;
			xy[i][0] = Integer.parseInt(st.nextToken())-1;
			xy[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		
		
		for(int k = 0; k< K; k++) {//몇번 돌릴 껀지
			for(int i = 0 ; i< K; i++) { //
				//ij[k][i];
			}
			
		}
		
		
	}

}
