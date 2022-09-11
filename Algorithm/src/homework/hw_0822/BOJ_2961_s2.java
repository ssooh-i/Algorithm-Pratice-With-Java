package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 도영이가 만든 맛있는 음식
public class BOJ_2961_s2 {
	static int N;
	static int[] sour;// 신
	static int[] bitter;// 쓴
	static boolean[] select = new boolean[N];

	static int powerset(int idx) {
		int min = Integer.MAX_VALUE;
		if (idx == N) {
			int sour_mul = 1;
			int bitter_plus = 0;
			for(int i = 0; i<N; i++) {
				if(select[i]) {
					sour_mul *= sour[i];
					bitter_plus += bitter[i];
					System.out.println("sour: "+sour+", sour_mul: "+sour_mul);
					System.out.println("bitter: "+bitter+", bitter_plus: "+bitter_plus);
				}
			}
			
			min = Math.min(Math.abs(sour_mul-bitter_plus), min);
			return min;
		}

		
		
		select[idx] = true;
		powerset(idx+1);
		select[idx] = false;
		powerset(idx+1);
		
		return min;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sour = new int[N];
		bitter = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer sb = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(sb.nextToken());
			bitter[i] = Integer.parseInt(sb.nextToken());
		}

		System.out.println(powerset(0));

	}
}
