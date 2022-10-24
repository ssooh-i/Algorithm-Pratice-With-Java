package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//초콜릿 자르기
public class b1_2163 {
	public static void main(String[] args) throws Exception {
		//먼저 가로선 따라 초코 자르기 n-1
		//n개로 나눠진 초코를 m개로 각각 나눠야함 n*(m-1)
		//(n-1) + n(m-1) = > n-1 서로 빼면 n*m-1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append(n*m-1);
		System.out.println(sb);
		
	}

}
