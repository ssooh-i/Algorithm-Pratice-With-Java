package homework.hw_0818;

public class Solution_미로2 {
	//시작점, 도착점
	static Point start, end;
	static int[][] map;
	static int ans;
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	
	static void go(Point now) {
		map[now.i][now.j]=9;
		for(int d = 0 ;d<4; d++) {
			int nexti = now.i +di[d];
			int nextj = now.j +dj[d];
			
			if(0<=nexti && nexti<100 && 0<=nextj && nextj<100 &&map[nexti][nextj]==0) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j =j;
		}
	}
}
