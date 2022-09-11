package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Palindrome_1259 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int a = Integer.parseInt(br.readLine());

			String str = Integer.toString(a);
			char[] arr = str.toCharArray();
			if (a == 0) {
				break;
			} else {
				int N = arr.length - 1;
				// System.out.println(N);

				char[] arr2 = new char[arr.length];

				for (int i = 0; i < arr.length; i++) {
					arr2[i] = arr[N - i];
				}

				int cnt = 0;
				for (int i = 0; i < arr.length; i++) {
					// System.out.println(arr[i] + " , "+ arr2[i]);
					if (arr[i] == arr2[i]) {
						cnt++;
						// System.out.println(cnt);
					}
				}

				if (cnt == (N + 1)) {
					System.out.println("yes");
				} else {
					System.out.println("no");

				}
			}
		}

	}
}
