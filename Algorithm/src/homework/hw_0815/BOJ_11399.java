package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 11399 - ATM
public class BOJ_11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] n_arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			n_arr[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(n_arr);

		int time = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			time = n_arr[i] + time;
			sum += time;
		}

		System.out.println(sum);
	}
}
