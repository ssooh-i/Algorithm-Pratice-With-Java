package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());// 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			char[] command = br.readLine().toCharArray();// 명령어 하나씩 잘라서 배열로 저장

			int N = Integer.parseInt(br.readLine()); // 명령처리가 될 배열 길이
			Deque<Integer> arr = new ArrayDeque<>();// 추가 될 곳

			char[] a = br.readLine().toCharArray();

			for (int i = 0; i < a.length; i++) {
				if (a[i] == '[' || a[i] == ']' || a[i] == ',')
					continue;
				else {
					arr.add(Character.getNumericValue(a[i]));
					// Character.getNumericValue(a[i])로 char -> int형으로 변환가능
				}
			}

			boolean flag = true;// 정방향

			for (int i = 0; i < N; i++) {// 명령어 꺼내서 실행하기
				for (int j = 0; j < command.length; j++) {

					if (command[j] == 'R') { // 뒤집기
						if (flag) {
							flag = false;
						} else {
							flag = true;
						}

					}
					if (command[j] == 'D') { // 버리기
						if (arr.isEmpty()) {// 배열이 비었으면 error 프린
							System.out.println("error");
							break;
						}else {
						if (flag) {
							arr.removeLast();// 0번째 삭제
						} else {
							arr.removeFirst();// 0번째 삭제
						}
						}
						
					}
				}
			}
			
			sb.append("[");
			for (int aa = 0; aa < arr.size(); aa++) {
				sb.append(arr.pollFirst());
				if((arr.size())-1 == aa) {
					continue;
				}
				sb.append(",");
			}
			sb.append("]");
		}

		
		System.out.println(sb.toString());

	}
}
