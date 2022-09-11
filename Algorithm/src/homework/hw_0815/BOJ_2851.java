package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2851 - 슈퍼마리오
public class BOJ_2851 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] n_arr = new int[10];

		for (int n = 0; n < 10; n++) {// 입력받기
			n_arr[n] = Integer.parseInt(br.readLine());
		}

		int max_1 = 0; // 100-i
		int max_2 = 0; // 100-(i+1) 3
		int sum = 0; // result

		for (int i = 0; i < 10; i++) {
			if (i == 9) {
				max_1 += n_arr[i];
				if(Math.abs(100-max_1) < Math.abs(100-sum)) {
					break;
				}
			} else {
				max_1 += n_arr[i];
				max_2 += n_arr[i+1];
				
//				int a = 100-max_1;
//				int b = 100-max_2;
//				
//				if(a>b) {
//					sum = max_1;
//				}else {
//					break;
//				}
				
				if(Math.abs(100-max_1) > Math.abs(100-max_2)) {
					sum = max_1;
				}else {
					break;
				}

			}
			System.out.println("max_1:"+max_1+", max_2:"+max_2+", sum:"+sum);
		}
		
		System.out.println(sum);

	}
}
