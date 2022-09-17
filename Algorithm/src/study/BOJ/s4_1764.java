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
		
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i<N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			String s = br.readLine();
			if(set.contains(s)) {
				list.add(s);
			}
		}
		
//		System.out.println(N+"," +M);
//		System.out.println("N_list:"+ Arrays.toString(N_list));
//		System.out.println("M_list:"+ Arrays.toString(M_list));
		
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
	}
}
