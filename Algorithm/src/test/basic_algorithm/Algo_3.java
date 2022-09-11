package test.basic_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 입력받기
 * 2차원 배열만들어서 맵 만들기
 * 값 넣어주고
 * 화산탄 날아와서 굴러지는 걸 조건으로 만들기
 * */
public class Algo_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//br을 이용해서 라인별로 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());//스트링토크나이저를 이용해서 하나씩 들고 올것
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		String[][] map = new String[R][C];
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());//스트링토크나이저를 이용해서 하나씩 들고 올것.
			for(int j = 0; i<C; j++) {
				map[i][j] = st.nextToken();
			}
		}
		int N = Integer.parseInt(br.readLine());
		int[] n = new int[N];
		for(int i = 0; i<N; i++) {
			n[i ]= Integer.parseInt(br.readLine());
		}
		
		//출력
		for(int i = 0; i<R; i++) {
			for(int j = 0; i<C; j++) {
				System.out.print(map[i][j] );
			}System.out.println();
		}
	}
}
