package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 - 열개씩 끊어서 출력하기
public class b3_11721 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		Queue<Character> q = new LinkedList<>();
		
		for(int i = 0; i< str.length; i++) {
			q.offer(str[i]);
		}
		
		while(!q.isEmpty()) {
			int s = q.size();
			if(10<s) {
				for(int i = 0; i<10; i++) {
					System.out.print(q.poll());
				}System.out.println();
			}else {
				for(int i = 0; i<s; i++) {
					System.out.print(q.poll());
				}
			}
		}
	
	}

}
