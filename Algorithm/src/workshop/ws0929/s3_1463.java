package workshop.ws0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1로 만들기
public class s3_1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		
		int[] dp = new int[X+1];
		
		dp[1] = 0;
		
		for(int i=2; i<=X ; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i%3 == 0) {
				min = Math.min(min, dp[i/3]);
			}if(i%2 == 0) {
				min = Math.min(min,  dp[i/2]);
			}
			min = Math.min(min,  dp[i-1]);
			
			dp[i] = min+1;
		}

		System.out.println(dp[X]);
		
	}
}
