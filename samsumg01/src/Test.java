
public class Test {
	static int[] dy = { -1, 1, 0, 0 };// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	static int search(int[][] map, int startY, int startX) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			//boolean flag = false;
			
			int nextY = startY;
			int nextX = startX;
			int cnt = 0;

			while (true) {

				nextY = nextY + dy[i];
				nextX = nextX + dx[i];

				if (0 <= nextY && nextY < map.length && 0 <= nextX && nextX < map[nextY].length) {
					if (map[nextY][nextX] != 0) {
						//flag = true;
						break;
					}
					cnt++;
				} else {
					min = Math.min(min, cnt);
					break;
				}

			}
//			if(!flag) {
//				min = Math.min(min, cnt);				
//			}

		}

		return min;
	}

	public static void main(String[] args) {

	}
}
