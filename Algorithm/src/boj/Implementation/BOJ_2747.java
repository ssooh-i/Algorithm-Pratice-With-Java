package boj.Implementation;

import java.util.Scanner;

//백준 2747 - 피보나치 수
public class BOJ_2747 {
	//시간초과남
//	private static int Fibonacci(int n) { 
//		if(n == 0) return 0;
//		if(n == 1) return 1;
//		return Fibonacci(n-1)+Fibonacci(n-2);
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		
//		System.out.println(Fibonacci(N));
//	}
	
	//누적합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] sum = new int[46]; //N범위가 45이하
		sum[0] = 0;
		sum[1] = 1;
		for(int i = 2; i<=N; i++) {
			sum[i] = sum[i-1]+sum[i-2];//
		}
		
		System.out.println(sum[N]);
	}
}
