package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//리모콘
public class g5_1170 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //원하는 채널 번호
		int M = Integer.parseInt(br.readLine()); //고장난 버튼 수
		int[] btn = new int[M]; //고장난 번호들
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<M; i++) {
			btn[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}

}
