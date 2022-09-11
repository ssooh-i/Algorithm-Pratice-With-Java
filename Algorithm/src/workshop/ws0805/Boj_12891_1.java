package workshop.ws0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_12891_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());//9
		int P = Integer.parseInt(st.nextToken());//8
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken(); //CCTGGATTG
		int[] str1 = new int[5];
		char a;
		for(int i =0; i< str.length(); i++) {
			a = str.charAt(i);
			if(a == 'A') str1[0]++;
			if(a == 'C') str1[1]++;
			if(a == 'G') str1[2]++;
			if(a == 'T') str1[3]++;
			else str1[4]++;
		}
		
		int [] DNA = new int[4];//ACGT 공간
		st = new StringTokenizer(br.readLine(), " ");// 2 0 0 1
		DNA[0] = Integer.parseInt(st.nextToken());//A, 2
		DNA[1] = Integer.parseInt(st.nextToken());//C, 0
		DNA[2] = Integer.parseInt(st.nextToken());//G, 0
		DNA[3] = Integer.parseInt(st.nextToken());//T, 1
		
		int cnt = 0;
		for(int i =0; i<4; i++) {
			if(DNA[i] == str1[i]) {
				cnt += str1[i];
			}else {
				System.out.println("0");
				break;
			}
		}
		
	}
}
