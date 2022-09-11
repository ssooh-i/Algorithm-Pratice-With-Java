package boj.retry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 12891 - DNA 비밀번호(하루코딩 유튜브 강의)
public class BOJ_12891_s2_2 {
	static int[] myArr;
	static int[] checkArr;
	static int checkSecret;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());// 재료 길이
		int P = Integer.parseInt(st.nextToken());// 비밀번호 길이
		int result = 0;// 최종 결과값
		
		char[] A = br.readLine().toCharArray();

		
		checkSecret = 0;//부분문자열의 조건이 만족했는지 체크할 거 4면 4조건을 다만족한것으로 판별
		
		
		st = new StringTokenizer(br.readLine());

		checkArr =new int[4];
		myArr = new int[4];
		
		for(int i =0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken()); // 최소 조건 수
			if(checkArr[i] == 0) {
				checkSecret++;
			}
		}
		
		for(int i = 0; i<P; i++) {//부분문자열 처음 받을 때 세팅
			Add(A[i]);
			if(checkSecret == 4) result ++; //결과값 세팅
		}
		
		
		//슬라이딩 윈도우
		for(int i = P; i<S; i++) {
			int j = i-P; //맨 왼쪽, i는 맨 오른 쪽
			Add(A[i]); //새로들어가는 i만 넣어주기
			Remove(A[j]); //빠져나가는 j넣어주기
			if(checkSecret == 4) result ++;
		}
		System.out.println(result);
		br.close();
	}
	
	
	private static void Add(char c){
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) {
				checkSecret++;
			}
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) {
				checkSecret++;
			}
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) {
				checkSecret++;
			}
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) {
				checkSecret++;
			}
			break;
		
		}
		return;
	}
	
	private static void Remove(char c){
		switch(c) {
		case 'A':
			if(myArr[0] == checkArr[0]) {
				checkSecret--;
				myArr[0]--;
			}
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) {
				checkSecret--;
				myArr[1]--;
			}
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) {
				checkSecret--;
				myArr[2]--;
			}
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) {
				checkSecret--;
				myArr[3]--;
			}
			break;
		
		}
		return;
	}
	
}
