package homework.hw_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 - 차량번호판1
/*
 * cc 가 나올 경우 26C1 * 25C1
 * dd 가 나올 경우 10C1 * 9C1
 * 
 * */
public class BOJ_16968_b1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int num = 1;
		String start = s.substring(0,1); //첫번째 자리
		
		if(start.equals("c")) num *= 26;
		else num *= 10;
		

		for (int i = 0; i < s.length()-1; i++) {
			String a = s.substring(i, i+1);
			String b = s.substring(i+1, i+2);
			
			if(a.equals("c")) {
				if(a.equals(b)) num *= 25;//중복되는 수 1개 빼기 , cc일 경우
				else num *= 10;
			}else if(a.equals("d")){
				if(a.equals(b)) num *= 9; //dd일 경우
				else num *= 26; //중복되는 수 1개 빼기
			}
			
		}
		System.out.println(num);

	}
}
