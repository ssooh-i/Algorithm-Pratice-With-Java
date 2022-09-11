package workshop.ws0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpotMart2_D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine()); // 4 10
			int n = Integer.parseInt(st.nextToken());// 4
			int m = Integer.parseInt(st.nextToken());// 10

			int[] nList = new int[n];// n개 과자 봉지 무게가 들어올 int형 배열

			st = new StringTokenizer(br.readLine());// 배열에 값저장
			for (int i = 0; i <n; i++) {
				nList[i] = Integer.parseInt(st.nextToken());
			}
			
			int max=0;
			int sum=0;
			
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					sum =nList[i]+nList[j];
					if(sum<=m && max<sum) {//배열이 m보다 작거나 같고, max보다 크면 갱신
						max=sum;
					}
				}
			}
			if(max == 0) {
				System.out.println("#"+tc+" -1");
			}else {
				System.out.println("#"+tc+" "+max);
			}

		}
	}
}
