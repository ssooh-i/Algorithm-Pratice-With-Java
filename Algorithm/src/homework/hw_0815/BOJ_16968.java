package homework.hw_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 16968 - 차량번호판1
public class BOJ_16968 {
	static char[] arr;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = br.readLine().toCharArray();
		result = 1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'c') {
				result *= 9;
			}
			if(arr[i] == 'd') {
				result *= 26;
			}					

		}
		System.out.println(result);
	}
}
