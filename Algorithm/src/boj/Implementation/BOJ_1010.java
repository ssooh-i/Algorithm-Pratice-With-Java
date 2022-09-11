package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 1010 - 다리놓기
public class BOJ_1010 {
	static int N, M;
	static int[][] storage;
	
	static int comb(int n, int r) {//조합
		if(storage[n][r] != 0) return storage[n][r];
		
		// nC0 = nCn = 1
		if(n == r || r == 0) {
			return 1;
		}
		
		return storage[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
		
	}
	
	//시간초과 남
//	static int comb(int n, int r) {//조합
//		// nC0 = nCn = 1
//		if(n == r || r == 0) {
//			return 1;
//		}
//		
//		return comb(n - 1, r - 1) + comb(n - 1, r);
//		
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			
			storage = new int[N+1][M+1];
			
			System.out.println(comb(N, M));
			

		}

	}
}
