package workshop.ws0803;

import java.util.Scanner;

public class Fly_D2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flys = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					flys[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for(int i = 0; i<N-M+1; i++) {
				for(int j = 0; j<N-M+1; j++) {
					max = Math.max(max, summing(flys, i, j, M));
				}
				
			}
			System.out.println("#"+t+" "+max);
			
		}
		
		
		
	}
	public static int summing(int[][] flys, int startY, int startX, int M) {
		int sum =0;
		for(int i = startY; i<startY+M; i++) {
			for(int j = startX; j< startX+M; j++) {
				sum += flys[i][j];
			}
		}
		return sum;
	}
}
