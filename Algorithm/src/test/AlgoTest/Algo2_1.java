package test.AlgoTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//범죄없는 마을을 위한 워밍업
public class Algo2_1 {//조합
	static int[] arr;
	static boolean[] select;
	static int  V, P;
	static int a;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());// 테스트케이스 수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());// 마을 개수
			P = Integer.parseInt(st.nextToken());// 경찰서 개수
			
			arr = new int[V];//조합을 만들 배열
			select = new boolean[V];// 뽑힌 변수 관리할 select
			a = 0;//경우의 수 저장할 변수
			
			for (int i = 0; i < V; i++) {// 배열에 임의값 넣어주기
				arr[i] = i + 1;
			}
			
			comb(0, 0);//comb 메소드 호출
			System.out.println("#"+tc+" "+a);
		}
		
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==P) {//P개 만큼 뽑힐 때 경우의 수 올려주기
			a++;
			return;
		}
		if(idx == arr.length) return;
		
		select[idx] = true;//선택하는 경우
		comb(idx+1, cnt+1);
		select[idx] = false;//선택 안하는 경우
		comb(idx+1, cnt);
	}
}

