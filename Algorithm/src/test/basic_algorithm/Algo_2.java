package test.basic_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//1.입력받기
//2.tocharArray 써서 char배열 만들기
//3. 앞에요소가 모음이고 지금 요소가 p이면 p삭제하기

/*
 * 입력받기
 * 입력받은 문자열을 문자 배열로 만들기
 * 문자배열 받은 거를 큐에 넣어주기
 * 큐에 넣은 값에서 조건문을 만족한다면 큐안에 값 삭제하기
 * 큐의 다음 위치 연결해주기
 * 최종적으로 큐 출력하기
 * */
public class Algo_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//br을 이용해서 라인별로 입력받기
		String s = br.readLine();
		String[] a = new String[s.length()];
		
		
		char[] arr = s.toCharArray();
		Queue<String> q = new LinkedList();
		for(int i =0; i< arr.length; i++) {
			//q.add(arr[i]);
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == 'a' ||arr[i] == 'e' ||arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u' ) {
				if(arr[i+1] == 'p') {
					q.remove(i+1);
				}
			}
		}
		//System.out.println(q);
		System.out.println(Arrays.toString(arr));
	}

}
