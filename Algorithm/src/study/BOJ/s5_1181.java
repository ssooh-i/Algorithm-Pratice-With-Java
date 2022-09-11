package study.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

//단어정렬
public class s5_1181 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();//중복 제거
		
		for (int i = 0; i < N; i++) {//입력받기
			set.add(br.readLine());
		}
		int size = set.size();//크기만큼 옮길꺼니까 
		String[] list = new String[size];//배열 만들어주기
		
		set.toArray(list);//사전순으로 한번 정렬
		
		Arrays.sort(list, new Comparator<String>() {//정렬되는 기준 만들어서 정렬
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {//길이가 같으면 사전순
					return s1.compareTo(s2);
				} else {//길이가 짧은 거 먼저
					return s1.length() - s2.length();
				}//양수면 위치 바뀜, 음수면 그대로
			}
		});//바꿔서 list안에 다시 넣어짐
		
		
		for(int i = 0; i< size; i++) {//출력
			System.out.println(list[i]);
		}
		
	}
}
