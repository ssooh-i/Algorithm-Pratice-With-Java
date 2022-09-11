package workshop.ws0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_12891_2 {
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
		int cnt = 0;
		int[] str1 = new int[4];
		
		for(int i = 0; i<in.length-P; i++) {
			for(int j = 0; j<P; j++) {
				result[j] = in[i+j];
				if(result[j] == 'A') str1[0]++;
				if(result[j] == 'C') str1[1]++;
				if(result[j] == 'G') str1[2]++;
				if(result[j] == 'T') str1[3]++;
				
			}
			for(int k =0; k<4; k++) {
				if(DNA[k] <= str1[k]) {
					//변수 하나를 더 만들어서 비교후에 카운트 넣음
					//그개수를 가지고 전체 CNT를 올려주기
				}else {
					break;
				}
			}
		}
		//출력
	}
}
