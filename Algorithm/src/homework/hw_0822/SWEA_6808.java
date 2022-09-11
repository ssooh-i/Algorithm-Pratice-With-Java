package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//규영이와 인영이의 카드게임 (재재도전)
public class SWEA_6808 {
	static int[] gyu, in;
	static int[] remain;
	static boolean[] visited;
	static int win, lose;
	
	static void dfs(int idx) {
		
		if(idx == remain.length) {
			int gScore =0;
			int iScore =0;
			for(int i = 0; i< gyu.length; i++) {
				if(gyu[i] > in[i]) {
					gScore += gyu[i] + in[i];
				}else {
					iScore += gyu[i] + in[i];
				}
			}
			if(gScore > iScore) {
				win++;
			}else {
				lose++;
			}
			return;
		}
		
		for(int i =0 ; i<remain.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				in[idx] = remain[i];
				dfs(idx+1);
				visited[i] = false;
				in[idx] = 0;
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			gyu = new int[9];
			in = new int[9];
			remain = new int[9];
			visited = new boolean[9];
			
			win = 0;
			lose = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			for(int i = 1; i<19; i++) { //재설정
				for(int j =0; j<9; j++) {
					if(gyu[j] == i) {
						break;
					}
					if(j == 8) {
						remain[idx++] = i;
					}
				}
			}
			dfs(0);
			System.out.println("#"+tc+" "+win+" "+lose);
			
		}
	}

}
