package workshop.ws0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_2 {
	static int N;	// 재료 수
	static int L;	// 제한 칼로리
	static int ans;	// 최대 점수
	static int[] score;	// 점수
	static int[] cal;	// 제한 칼로리
	
	public static void hambuger(int count, int sumScore, int allCal) {
		/* 기저 사례: 여태 더한 칼로리량이 제한 칼로리보다 클때,*/
		if(allCal > L) {
			return;
		}
		
		/* N개의 재료까지 뽑았을경우 -> 최대 점수 비교*/
		if(count == N) {
			ans = Math.max(ans, sumScore);
			return;
		}
		
		/* 재귀호출(dfs): 재료수+1, 점수, 칼로리 합  */
		hambuger(count+1, sumScore+score[count], allCal+cal[count]);
		
		/* 재료 빼기 */
		hambuger(count+1, sumScore, allCal);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 재료 수
			L = Integer.parseInt(st.nextToken());	// 제한 칼로리
			score = new int[N];
			cal = new int[N];
			ans = 0;
			
			for(int i=0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			// 재료개수, 점수합, 칼로리량 0으로 Start
			hambuger(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}