package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DNA
public class s5_1969_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// DNA 개수
		int M = Integer.parseInt(st.nextToken());// DNA 길이

		char[][] DNA = new char[N][M];
		char[] result = new char[M];//최종적으로 출력할 DNA
		int hamming = 0; //최종적으로 출력할 해밍길이

		for (int i = 0; i < N; i++) {// 입력받기
			char[] tmp = br.readLine().toCharArray();
			int[] cnt = { 0, 0, 0, 0 };
			for (int j = 0; j < tmp.length; j++) {
				DNA[i][j] = tmp[j];
				switch (DNA[i][j]) {

				case 'A':
					cnt[0]++;
					break;

				case 'C':
					cnt[1]++;
					break;

				case 'G':
					cnt[2]++;
					break;

				case 'T':
					cnt[3]++;
					break;

				}// switch end
			} // j end
			int max = 0;
			int maxIndex = 0;
			for(int k = 3; k>=0; k--) {//제일 높은 수 찾고 저장하기
				if(cnt[k]>max) {
					max = cnt[k];
					maxIndex = k;
				}
				System.out.println(maxIndex);
			}
			System.out.println("-----");
		} // i end

//		for(int i = 0; i<M; i++) {
//			for(int j = 0; j<N; j++) {
//				DNA[i][j] = st.nextToken(); 
//			}
//		}
		
	}
}
