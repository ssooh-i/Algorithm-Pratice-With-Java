package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//AC

//33%에서 시간초과, 에러만뜸

public class g5_5430 {
//	static void dfs(int r, int c, int moved) {
//
//	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());// 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			char[] command = br.readLine().toCharArray();// 명령어 하나씩 잘라서 배열로 저장

			int N = Integer.parseInt(br.readLine()); // 명령처리가 될 배열 길이
			List<Integer> arr = new LinkedList<>();// 추가 될 곳

			char[] a = br.readLine().toCharArray();

			for (int i = 0; i < a.length; i++) {
				if (a[i] == '[' || a[i] == ']' || a[i] == ',')
					continue;
				else {
					arr.add(Character.getNumericValue(a[i]));
					// Character.getNumericValue(a[i])로 char -> int형으로 변환가능
				}
			}

			for (int i = 0; i < N; i++) {// 명령어 꺼내서 실행하기
				for (int j = 0; j < command.length; j++) {
					if (arr.isEmpty()) {// 배열이 비었으면 error 프린
						System.out.println("error");
					} else {

						if (command[j] == 'R') { // 뒤집기
							Collections.reverse(arr);
						}
						if (command[j] == 'D') { // 버리기
							arr.remove(0);// 0번째 삭제
						}
					}
				}
			}

			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();

		}
	}

}
