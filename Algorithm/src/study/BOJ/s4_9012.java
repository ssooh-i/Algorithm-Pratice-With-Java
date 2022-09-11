package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class s4_9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int t = 0; t< N; t++) {
			String str = br.readLine();
			
			int cnt = 0;
			Stack<Character> stack = new Stack<>();
			
			for(int i =0; i<str.length(); i++) {
				char a = str.charAt(i);
				if(a == ')') {
					if(stack.isEmpty()) {
						cnt = 1;
						break;
					}
					char b = stack.peek();
					if(b == '(') {
						stack.pop();
						cnt--;
					}
				}else {
					stack.push(a);
					cnt++;
				}
			}
			
			
			if(cnt == 0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
	
	}

}
