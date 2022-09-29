package homework.hw_0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//RGB 거리
public class s1_1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] RGB = new int[N][3];
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken()); //R
			RGB[i][1] = Integer.parseInt(st.nextToken()); //G
			RGB[i][2] = Integer.parseInt(st.nextToken()); //B
		}
		
		//1부터 N-1까지, i-1의 RGB 중 최소값 찾아서 더하기
		//0번째는 상관없음, 1이 판단하니까
		for(int i = 1; i<N; i++) {
			RGB[i][0] += Math.min(RGB[i-1][1], RGB[i-1][2]);//빨간색을 선택했으면 앞에 파랑이랑 초록을 봐줘야함
			RGB[i][1] += Math.min(RGB[i-1][0], RGB[i-1][2]);
			RGB[i][2] += Math.min(RGB[i-1][0], RGB[i-1][1]);
		}
		
		//N-1의 RGB중에 젤 최소값 출력
		System.out.println(Math.min(Math.min(RGB[N-1][0], RGB[N-1][1]),RGB[N-1][2]));	
	}

}
