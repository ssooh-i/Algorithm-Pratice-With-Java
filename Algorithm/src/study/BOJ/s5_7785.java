package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//회사에 있는 사람
public class s5_7785 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();//회사원이 중복이 없다고 했다, set이나 map으로 풀면 될 듯
		
		for (int i = 0; i < n; i++) {//입력받기
			String[] input = br.readLine().split(" ");
			String name = input[0];//사원이름
			String com = input[1];//명령

			if (com.equals("enter"))
				set.add(name);
			
			if (com.equals("leave")) {
				if (set.contains(name))//이름 포함되어있으면 삭제
					set.remove(name);
			}
		}
		ArrayList<String> answer = new ArrayList(set); // sort에 list가 들어가야해서 list로 바꿈
		Collections.sort(answer, Collections.reverseOrder());//역순으로 정렬
		
		for(String s : answer) {//출력하기
			System.out.println(s);
		}
		
		
	}
}
