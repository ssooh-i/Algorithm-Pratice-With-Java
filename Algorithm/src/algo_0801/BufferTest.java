package algo_0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferTest {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("inputTC.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime(); //시간 재기
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int sum =0;
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					sum += Integer.parseInt(st.nextToken());
				}
				
			}
			
			//스캐너로 만들기
			/*int N = sc.nextInt();
			int sum =0;
			for(int j = 0; j<N; j++) {
				sum += sc.nextInt();
			}*/
			System.out.println("#"+tc+" "+sum);
		}
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0+"s");
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine(); // readLine()은 오류가 뜸, throws IOException 해줘야 오류수정됨
		char[] ch = br.readLine().toCharArray();
		//char배열만들어주기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 토큰나이저로 받으면서 바로 공백을 기준으로 나눠받을 수 있다.
		int i = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		//st.nextToken() 다음 토큰
		System.out.println(i+j);*/
	}

}
