package algo_0801;

import java.util.Scanner;

public class SWEA_1289 {
	// 원재의 메모리 복구하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//라인으로 받은 값 바로 int형으로 바꿔주기
		int t = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc < t + 1; tc++) {
			//라인으로 받은 값 char형 배열로 만들어주기
			char[] ch = (sc.nextLine()).toCharArray();
			int cnt = 0; //바뀐 횟수 저장할 변수

			if (ch[0] == '1') // 초기값은 0, 1일때는 0으로 바꿔야하니까 cnt++
				cnt++;
			
			for (int i = 1; i < ch.length; i++) { // 맨처음 자리는 위에서 채결하니까 1부터 계산
				if (ch[i] != ch[i - 1])//인접한 값이랑 다르면 바꿔줘야하니까 cnt++ 
					cnt++;
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}