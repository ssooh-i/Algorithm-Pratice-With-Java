package test.AlgoTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_2 {//조합
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());// 테스트케이스 수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());// 마을 개수
			int P = Integer.parseInt(st.nextToken());// 경찰서 개수
			int L = Integer.parseInt(st.nextToken());// 경찰서 개수
			
			int[] arr = new int[V];//마을이 들어갈 배열
			st = new StringTokenizer(br.readLine());
			
			for(int i =0; i<V; i++) {//마을 입력받기
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			
			System.out.println("#"+tc+" "+9);
		}
		
	}
	

}

