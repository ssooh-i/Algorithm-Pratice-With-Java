package study.BOJ;

import java.util.Scanner;

//킹
public class s3_1063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//킹,돌 좌표
		String king = sc.next();
		int kingX = king.charAt(0)-'A'+1;
		int kingY = king.charAt(1)-'0';
		String stone = sc.next();
		int stoneX = stone.charAt(0)-'A'+1;
		int stoneY = stone.charAt(1)-'0';
		//          R  L B T RT LT RB LB
		int[] dx = {1,-1,0,0,1, -1,1, -1};
		int[] dy = {0,0,-1,1,1, 1, -1,-1};
		
		//움직이는 횟수
		int n = Integer.parseInt(sc.next());
		for(int i=0;i<n;i++) {
			String move = sc.next();
			int idx = 0;
			int tmpX = kingX, tmpY = kingY;
			switch (move) {
			case "R": idx = 0; break;
			case "L": idx = 1; break;
			case "B": idx = 2; break;
			case "T": idx = 3; break;
			case "RT": idx = 4; break;
			case "LT": idx = 5; break;
			case "RB": idx = 6; break;
			case "LB": idx = 7; break;
			}
			tmpX += dx[idx];
			tmpY += dy[idx];
			//킹, 돌 둘다 범위 안 벗어나는지 확인
			if(tmpX>=1 && tmpX<=8 && tmpY>=1 && tmpY<=8) {
				if(tmpX==stoneX && tmpY==stoneY) {
					if(stoneX+dx[idx]>=1 && stoneX+dx[idx]<=8 && stoneY+dy[idx]>=1 && stoneY+dy[idx]<=8) {
						stoneX += dx[idx];
						stoneY += dy[idx];
					} else {
						continue;
					}
				}
				kingX = tmpX;
				kingY = tmpY;
			}
		}
		king = "";
		stone = "";
		
		king += Character.toString((char)(kingX+'A'-1)) + kingY;
		stone += Character.toString((char)(stoneX+'A'-1)) + stoneY;
		
		System.out.println(king);
		System.out.println(stone);
	}

}