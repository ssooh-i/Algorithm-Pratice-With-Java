package workshop.ws0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*입력받기
 * 재료 받으면서 모음인지 자음인지 판단해서 각각의 큐에 넣어주기
 * 모음 부분집합을 도출하고
 * (L - 뽑힌 모음의 개수)로 자음 개수 뽑아오기
 * 뽑힌 문자를 합쳐서 정렬해서 출력
 * 
 * 순서상관O, 중복 X = 순열
 * */
public class BOJ_1759_g5 {
	static int L;//비밀번호 길이
	static Queue<String> vowel;
	static Queue<String> consonant;
	static String[] password;
	static boolean[] vVisited;
	static boolean[] cVisited;
	
	static void vo(int idx) {//모음은 부분집합
		if(idx == vVisited.length) {
			for(int i =0; i<vVisited.length; i++) {
				if(vVisited[i]) {
					System.out.println(vowel.peek()+" ");
					vowel.offer((vowel.poll()));
				}
			}
			return;
		}
		if(idx == vowel.size()) {
			return;
		}
		vVisited[idx] = true;
		vo(idx+1);
		vVisited[idx] = false;
		vo(idx+1);
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		vowel = new LinkedList<>();
		consonant = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			String s= st.nextToken();
			if(s.equals("a") ||s.equals("e") ||s.equals("i")||s.equals("o")||s.equals("u") ) {
				vowel.add(s);
			}else {
				consonant.add(s);
			}
				
		}
		
		password = new String[C];
		vVisited = new boolean[vowel.size()];
		cVisited = new boolean[consonant.size()];
		
		vo(0);
		
		
		System.out.println(vowel);
		System.out.println(consonant);
		
		
	}
}
