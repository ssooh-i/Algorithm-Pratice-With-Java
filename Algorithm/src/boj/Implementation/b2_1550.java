package boj.Implementation;

import java.util.Scanner;

public class b2_1550 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int decimal = Integer.parseInt(s, 16); // 16->10진수
		System.out.println(decimal);
		//10->16진수, toHexString 사용
//		String hex = Integer.toHexString(decimal);
//		System.out.println(hex);
	}

}
