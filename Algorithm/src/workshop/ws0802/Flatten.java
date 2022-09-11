package workshop.ws0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			int dump = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int[] arr = new int[100];
			for(int i = 0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());			
			}
			Arrays.sort(arr);
			
			for(int i=0; i<dump; i++) {
				arr[0] = arr[0]+1;
				arr[99] = arr[99]-1;
				Arrays.sort(arr);
			}
			System.out.println("#"+t+" "+(arr[99]-arr[0]));

		}}}
			
			//Arrays 안쓰고 만들어보기
			/*int[] w = new int[100];
			
			for (int i = 0; i < 100; i++) {// char-> int바꾸기
				while (st.hasMoreTokens()) {
					w[i] = Integer.parseInt(st.nextToken());
				}
			}*/
			
			
			//int result = w[99]-w[0];
			//System.out.println(w[0] + " "+ w[99]);
			
			/*for(int i = 0; i<dump; i++) {
				Arrays.sort(w);
				
				w[99] -= 1;
				w[0] += 1; 
				
				Arrays.sort(w);
				System.out.println(w[0] + " "+ w[99]);
			}
			*/
			//System.out.println(result);
			
			
			
			

			/*
			int max_index = 0;
			int max = 0;
			int min_index = 0;
			int min = 100;

			for (int i = 0; i < 100; i++) {// char-> int바꾸기
				while (st.hasMoreTokens()) {
					w[i] = Integer.parseInt(st.nextToken());
					if (w[i] > max) {
						max = w[i];
						max_index = i;

					}
					if (w[i] < min) {
						min = w[i];
						min_index = i;
					}
				}
			}
			// 평탄화작업
			for (int i = 0; i < dump; i++) {
				for (int k = 0; k < 100; k++) {
					if (w[k] > max) {
						max = w[k];
						max_index = k;

					}
					if (w[k] < min) {
						min = w[k];
						min_index = k;
					}
				}
				w[max_index] = w[max_index]-1;
				max = max-1;
				w[min_index] = w[min_index]+1;
				min=min+1;
				System.out.println(max+" "+ min);
			}
			System.out.println("#"+t+" "+(max-min));
			*/
		/*}

	}

}
*/