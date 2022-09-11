package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//단어의 개수
public class b2_1152 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();// 앞뒤 공백 제거
		if (s.equals(" ")) {
			System.out.println(0);
		} else {
			String[] arr = s.trim().split(" ");// 공백 기준으로 나누어 배열저장
			System.out.println(arr.length);// 배열 길이 = 단어 수
		}
	}

}
