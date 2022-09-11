package EX;

//SWEA - 미로2 
import java.util.Scanner;

public class SWEA_maze2 {
	static int[][] map;
	static int[][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int find;
	
	public static void dfs(int x, int y) {
		if(find == 1)
			return;
		if(map[x][y] == 3) {
			find = 1;
			return;
		}
		v[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
				if(v[nx][ny] == 0 && map[nx][ny] != 1) {
					dfs(nx,ny);
				}
			}
		}
		v[x][y] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			map = new int[100][100];
			v = new int[100][100];
			int x = 0;
			int y = 0;
			find = 0;
			
			for(int i = 0; i < 100; i++) {
				String s = sc.next();
				for(int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			dfs(x, y);
			System.out.println("#" + t + " " + find);
		}
	}
}
