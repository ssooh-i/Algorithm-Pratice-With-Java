package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//수 정렬하기
public class b2_2750 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N - 1; i++) {
			for(int j = i+1; j<N; j++) {
				int temp =0;
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		//System.out.println(Arrays.toString(arr));//한번에 결과보기
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
