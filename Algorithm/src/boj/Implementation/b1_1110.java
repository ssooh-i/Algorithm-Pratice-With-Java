package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//더하기 사이클
public class b1_1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0; // 사이클 횟수 변수
		int copy = N; // 처음입력값을 가지고있는 변수
		
		do {//최소 한번은 돌아야해서 do - while문 사용
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			//((N % 10) * 10) : 10의 자리수, N이 한자리이면 0, 그 외에는 10의 자리 수 그대로 반환
			//(((N / 10) + (N % 10)) % 10) : 1의 자리수, 뒤의 1의 자리수 는 나머지인 % 를 하면 된다
//			System.out.println(((N % 10) * 10));
//			System.out.println((((N / 10) + (N % 10)) % 10));
//			System.out.println(N);
//			System.out.println();
			cnt++;
		}while(copy != N);
		// System.out.println();
		System.out.println(cnt);
		
	}
}
