package homework.hw_0825_ssam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 9205 - 맥주 마시면서 걸어가기
public class BOJ_9205_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());// 편의점수
			int beer = 20;
			int L = N + 2;

			int[] martY = new int[L];
			int[] martX = new int[L];

			for (int i = 0; i < L; i++) {// 좌표 저장
				String[] mart = br.readLine().split(" ");
				martY[i] = Integer.parseInt(mart[0]);
				martX[i] = Integer.parseInt(mart[1]);
			}
			//갈수있을까?
			for (int i = 0; i < L-1; i++) {
				int nowY = martY[i];//지금
				int nowX = martX[i];
				int nextY = martY[i+1];
				int nextX = martX[i+1];
				
				beer -= (nextY-nowY)/50; //Y가 사용할 맥주
				beer -= (nextX-nowX)/50; //X가 사용할 맥주
				
				if(beer >= 0) {//다 뺐는데 0 이상이면 이동 한거니까 +20
					beer = 20;
				}
				
				//next가 페스티벌일때
				if((i+1) == (L-1)) {
					if (beer < 0) {
						System.out.println("sad");
					} else {
						System.out.println("happy");
					}
				}
			}
			

		}
	}

}
