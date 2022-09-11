package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int a = 0;
		int sum = 0;
		for(int i = 0;i<K ; i++) {
			a = Integer.parseInt(br.readLine());
			if(a == 0) {
				stack.pop();
			}
			else {
				stack.push(a);
			}
		}
		for(int i = stack.size()-1; i>=0; i--) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
	
}
