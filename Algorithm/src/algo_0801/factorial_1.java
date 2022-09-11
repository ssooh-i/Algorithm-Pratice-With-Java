package algo_0801;

import java.util.Scanner;

public class factorial_1 {
	//loop
	//재귀 안씀
	/*static int factorial(int n) {
		int res =1;
		for(int i = n; n>=1; i--) {
			res *= i;
		}
		return res;
	}*/
	//재귀씀 - 1
	/*static int res =1; //멤버변수로 만듦
	static void factorial2(int n) { //i값을 기존 누적값에 곱함
		if(n<1) return;
		res *= n;
		factorial2(n-1);
	}*/
	//재귀씀 -2
	
	static int factorial3(int n) {//n! 계산
		if(n<=1) return 1;
		return n * factorial3(n-1);
		//return 자기자신 * 나머지 팩토리얼
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//System.out.println(factorial(n));
		//factorial2(n);
		//System.out.println(res);
		System.out.println(factorial3(n));
	}
}
