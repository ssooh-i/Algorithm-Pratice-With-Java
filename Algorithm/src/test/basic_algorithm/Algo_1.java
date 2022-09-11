package test.basic_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//냐옹이의 야바위게임
//1. 입력받아서 배열에 저장하기
//2. 두자리를 바꿔주는 temp 만들기
//3. 바꾸는 수만큼 바꿔주기
//배열 번호가 아니라 배열안에 들은 수가 바뀌어야함
//4. 마지막 명령어까지 실행한 후 자리에 무슨 값있는 지 확인하기

public class Algo_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//br을 이용해서 라인별로 입력받기
		int T = Integer.parseInt(br.readLine());//테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {//테스트 케이스만큼 반복문
			StringTokenizer st = new StringTokenizer(br.readLine());//스트링토크나이저를 이용해서 하나씩 들고 올것
			int N = Integer.parseInt(st.nextToken());// 종이컵수
			int[] arr = new int[N + 1];//N 배열 만들기

			for (int i = 1; i <= N; i++) {// 종이컵수만큼 배열에 값 초기화해서 넣어주기
				arr[i] = i;
			}

			int X = Integer.parseInt(st.nextToken());// 간식 위치
			int change = Integer.parseInt(st.nextToken());// 몇번바뀌는 지
			int[][] com = new int[change][2];//명령어들고 갈 배열

			for (int i = 0; i < change; i++) {// com 배열에 바뀔 위치 2개 저장
				st = new StringTokenizer(br.readLine());
				com[i][0] = Integer.parseInt(st.nextToken());
				com[i][1] = Integer.parseInt(st.nextToken());
			}

//			for (int i = 0; i < change; i++) {// 실재로 바뀔 공간(위치가 바뀌는 게 아니라 그 값을 갖고 있는 걸 바꿔줘야함
//
//				int temp = 0;
//				int a = com[i][0];
//				int b = com[i][1];
//				for(int j = 1; j<arr.length; j++) {
//					for(int k = 1; k<arr.length; k++) {
//						if(a == arr[j] && b == arr[k]) {
//							temp = arr[j];
//							arr[j] = arr[k];
//							arr[k] = temp;
//							break;
//						}
//						continue;
//					}
//					continue;
//				}
//				System.out.println(Arrays.toString(arr));
//				System.out.println();
//				
//				
//			}
			for (int i = 0; i < change; i++) {
				int temp = 0; //템프를 써서 바꾸기
				temp = arr[com[i][0]]; //템프 = a
				arr[com[i][0]] = arr[com[i][1]]; //a = b
				arr[com[i][1]] = temp;//b=템프

			}

			System.out.println("#"+tc +" "+arr[X + 1]);
		}
	}
}
