package workshop.ws0817;

import java.util.Scanner;

public class SquareNumberTest { //분할정복
	static int callCnt1, callCnt2;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(exp1(x, n));
		System.out.println(callCnt1);
		
		System.out.println(exp2(x, n));
		System.out.println(callCnt2);
	}
	
	
	static long exp1(long x, long n) {//분할정복 사용 X
		callCnt1++;
		if(n ==1) return x;
		
		return x * exp1(x, n-1); //자기 사진 곱하기 -1승 
		
	}
	
	static long exp2(long x, long n) {//분할정복 사용
		callCnt2++; 
		if(n == 1) return x;
		long y = exp2(x, n/2); 
		
		return n%2 == 0? y*y : y*y*x;
	}
}
