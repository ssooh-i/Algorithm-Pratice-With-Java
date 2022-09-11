package workshop.ws0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] sour = new int[T]; // 신맛
		int[] bitter = new int[T]; // 쓴맛
		
		for (int i = 0; i < T; i++) { //값 저장
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken()); 
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}
