package workshop.ws0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3040_2 {

	static boolean[] visited;
	static int[] dw;

	static void dfs(int d) {
		//System.out.println("d: "+ d+", visited: "+Arrays.toString(visited));
		if (d == 7) {// 탈출 조건
			// visited 7개 가지고 와서 sum에 더해주기
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sum += dw[i];
				}
				//System.out.println("sum("+i+") : "+ sum);
			}

			// sum =100 -> 출력
			if (sum == 100) {
				for (int i = 0; i < visited.length; i++) {
					if (visited[i]) {
						System.out.println(dw[i]);
					}
				}
				System.exit(0);
			}
			
			return;
		}

		for (int i = 0; i < visited.length; i++) {//d가 7이 아닐 때
			//0-> visited[0] ==false -> true
			if(!visited[i]) {
				visited[i] = true;
				dfs(d+1); //d값이 바뀌지 않음, 그래서 원래값을 확인할 수 있음
				visited[i] = false;
			}
			//System.out.println(i);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dw = new int[9];
		visited = new boolean[9];

		for (int i = 0; i < 9; i++) {// 입력 받기
			dw[i] = Integer.parseInt(br.readLine());
			System.out.println(dw[i]);
		}
		
		dfs(0);
	}
}
