package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11050 - 이항계수 1 
public class BOJ_11050 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(comb(N, K));

	}
	//n개중에 k개 뽑기 = 조합
	static int comb(int n, int k) {

		// nC0 = nCn = 1
		if (n == k || k == 0) {
			return 1;
		}

		// n+1 C r+1 = nCr + nCr+1
		return comb(n - 1, k - 1) + comb(n - 1, k);
	}
}
