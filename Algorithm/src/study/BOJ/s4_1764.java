package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//듣보잡
public class s4_1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//듣지 못한 사람
		int M = Integer.parseInt(st.nextToken());//보지 못한 사람
		
		
		Set<String> set = new HashSet<>();//set에 값 다 넣어주기
		for(int i = 0; i<N; i++) {
			set.add(br.readLine());
		}
		
		
		ArrayList<String> list = new ArrayList<>();//듣도보도 못한 사람 들어갈 리스트
		//리스트를 쓴 이유는 사전순으로 정렬하기 위해 Collections.sort쓰려고
		for(int i = 0; i<M; i++) {
			String s = br.readLine();
			if(set.contains(s)) {//set 안에 포함되어 있으면 리스트에 추가
				list.add(s);
			}
		}
		
		Collections.sort(list);//리스트 형태를 사전순으로 정렬
		
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
	}
}
