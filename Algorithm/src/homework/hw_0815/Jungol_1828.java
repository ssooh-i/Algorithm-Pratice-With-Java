package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//정올 1828 - 냉장고
//활동 선택하는 문제
//1. 냉장고의 최고 보관 온도를 기준으로 내림차순으로 정렬한다(최고보안온도가 같을 때 최저 보관온도로 재정렬)
//2. 현재 최저 보관온도와 다음 최저온도를 비교
//3. 현재 최저 온도가 더 낮으면 -1해주고 max도 바꿔주기
//4. 현재 최저 보관온도와 다음 최저온도를 비교
//5. 온도가 겹치지 않는다면 필요한 냉장고 수를 +1해준다
// 다음 최저 온도가 현재 최고 온도보다 낮으면 같은 냉장고를 사용할 수 있다

public class Jungol_1828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// n이 한개면 당연히 냉장고 1개
		if (n == 1) {
			System.out.println(1);
			return;
		}

		StringTokenizer st;
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {// 입력받기
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {// arr 배열을 가지고 정렬하기
			@Override
			public int compare(int[] o1, int[] o2) {
				//System.out.println("o1[1]:"+o1[1]+", o2[1]:"+o2[1]+", compare 결과: "+Integer.compare(o1[1], o2[1]));//최고 온도로 정렬
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int result = 1;// 냉장고수는 1부터 시작
		int max = arr[0][1];// 초기 max 값

		for (int i = 1; i < n; i++) {
			if (max < arr[i][0]) {// 최고온도보다 다음 배열의 최저온도가 크다면?
				max = arr[i][1];// 최고온도 바뀌주기
				result++; // 냉장고 수 +1해주기
			}
		}

		System.out.println(result);
	}
}
