package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ACM 호텔
public class b2_10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());//높이
			int W = Integer.parseInt(st.nextToken());//가로
			int N = Integer.parseInt(st.nextToken());//손님번호

			int cnt = 0;
			
			for(int j = 1; j<=W; j++) {
				for(int i = 1; i<=H; i++) {
					if(++cnt == N) {
						System.out.println((i*100)+j);
					}
				}
			}

		}

	}

}
