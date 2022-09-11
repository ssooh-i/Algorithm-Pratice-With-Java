package workshop.ws0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
//11860kb, 84ms
public class Main_1010 {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
			// M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N이다.
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());   // N = r
			int M = Integer.parseInt(st.nextToken());   // M = n
			sb.append(combi(M, N)).append('\n');
		}
		System.out.println(sb);
	}
	
	static int combi(int n, int r) {
		// 이미 풀린 경우 바로 반환
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
		// 2번 성질
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		// 1번 성질
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}
/*
[입력]
4
2 2
3 3
1 5
13 29

[출력]
1
5
67863915

*/