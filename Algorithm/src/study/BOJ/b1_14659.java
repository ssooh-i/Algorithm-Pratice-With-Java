package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//한조 서열 정리하고 옴ㅋㅋ
public class b1_14659 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//총잡이 수
		
		int[] bong = new int[N];//봉우리 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {//봉우리 배열 입력받기
			bong[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;//최종 출력될 값
		
		for(int i = 0; i<N; i++) {
			int cnt = 0;//내부적으로 계산될 변수
			for(int j = i+1; j<N; j++) {
				if(bong[i]>bong[j]) {
					cnt++;
				}else {//자기보다 크면 더 이상 진행할 수 없음
					break;
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}

}
