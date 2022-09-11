package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 8958 - OX퀴즈
public class BOJ_8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			char[]a =  br.readLine().toCharArray();

			int count = 0;
			int result = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 'O') {
					result += ++count;
				}else {
					count = 0;
				}
			}
			System.out.println(result);
		}
	}
}
