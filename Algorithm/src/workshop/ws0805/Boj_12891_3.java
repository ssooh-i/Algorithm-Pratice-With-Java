package workshop.ws0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_12891_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());// 9
		int P = Integer.parseInt(st.nextToken());// 8

		st = new StringTokenizer(br.readLine());
		String str = st.nextToken(); // CCTGGATTG
		char[] in = str.toCharArray();

		st = new StringTokenizer(br.readLine(), " ");// 2 0 0 1
		int[] DNA = new int[4];// ACGT 공간
		DNA[0] = Integer.parseInt(st.nextToken());// A, 2
		DNA[1] = Integer.parseInt(st.nextToken());// C, 0
		DNA[2] = Integer.parseInt(st.nextToken());// G, 0
		DNA[3] = Integer.parseInt(st.nextToken());// T, 1

		char[] result = new char[P];
		int cnt = 0;// 전체 카운트

		int[] str1 = new int[4];

		for (int i = 0; i <= in.length - P; i++) {
			for (int j = i , idx = 0; j < P+i; j++) {
				
				result[idx] = in[j];
				if (result[idx] == 'A')
					str1[0]++;
				if (result[idx] == 'C')
					str1[1]++;
				if (result[idx] == 'G')
					str1[2]++;
				if (result[idx] == 'T')
					str1[3]++;
				idx++;

			}
			int temp = 0;// 지금꺼만 카운트
			for (int k = 0; k < 4; k++) {
				if (DNA[k] <= str1[k]) {// 현재값이랑 DNA개수랑 비교, 최소치 이상
					temp++;
				} else {
					break;
				}
				if (temp == 4) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}
