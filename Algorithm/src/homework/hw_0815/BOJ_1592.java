package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1592 - 영식이와 친구들
public class BOJ_1592 {
	static int[] cnt;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// N명, 5
		int M = Integer.parseInt(st.nextToken());// 한사람이 M번받으면 종료, 3
		int L = Integer.parseInt(st.nextToken());// L번째 있는 사람에게 전달, 2

		cnt = new int[N + 1];// 사람번호와 인덱스 맞추기
		count = 0; // 반환할 총 공을 옮길 수

		cnt[1] = 1;// 처음은 1번 사람에게 가니까 고정값
		int index = 1; // 사람 번호 관리
		while (true) {
			if (cnt[index] == M)
				break;// 종료 조건, 사람 안에 있는 값이 M이라면 종료

			if (cnt[index] % 2 == 1) { // 카운트가 %2로 홀수가 나온다면 시계방향으로 진행
				index = index + L;
			} else {// 카운트가 %2로 짝수가 나온다면 반시계방향으로 진행
				index = index - L;
			}

			// 인덱스 범위를 벗어났다면?
			if (index > N) {
				index %= N; // index = index%N, 5->2 상황이라면 5%5=0인 상황
			} else if (index < 1) {//반시계방향인데 인덱스를 벗어나면?
				// 0이라는 인덱스를 안쓰기로 함, 사람명수 = index 번호 맞춤
				index += N;
			}
			// System.out.println(Arrays.toString(cnt));
			cnt[index]++;// 공 받았으면 인덱스값 올려주기
			count++;// 총 횟수 올려주기

		}
		System.out.println(count);
	}
}
