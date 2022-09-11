package workshop.ws0811;

import java.util.Scanner;

public class SWEA_5215 {
	static int N;	// 재료 수
	static int L;	// 제한 칼로리
	static int ans;	// 최대 점수
	static int[] score;	// 점수
	static int[] cal;	// 칼로리
	
	
	public static void dfs(int count, int sumScore, int allCal) {
		if(allCal > L) {//칼로리가 제한을 넘는다면?
			return;
		}
		if(count == N) {// N개의 재료까지 뽑았을경우 -> 최대 점수 비교
			ans = Math.max(ans, sumScore);//둘 중에 max값을 answer로 넣어주기
			return;
		}
		// 재귀호출(dfs): 재료수+1, 점수, 칼로리 합  
		dfs(count+1, sumScore+score[count], allCal+cal[count]);
		
		//중복 재료되면 안되니까 재료 빼기 
		dfs(count+1, sumScore, allCal);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			N = sc.nextInt();	// 재료 수
			L = sc.nextInt();	// 제한 칼로리
			
			score = new int[N]; //점수 담을 곳
			cal = new int[N]; //칼로리 담을 곳
			ans = 0;
			
			for(int i=0; i<N; i++) {//입력받기
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			// 재료개수, 점수합, 칼로리량 0으로 Start
			dfs(0, 0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}