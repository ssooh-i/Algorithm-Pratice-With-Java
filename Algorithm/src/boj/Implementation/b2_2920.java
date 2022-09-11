package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//음계
public class b2_2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*int[] nums = new int[8];
		boolean[] check = new boolean[8+1];
		check[0] = true;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		if (nums[0] == 1) {
			for (int i = 1; i < 9; i++) {
				if (nums[i - 1] != i) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
			return;
		}

		if (nums[0] == 8) {
			for (int i = 1; i < 9; i++) {
				if (nums[i-1] != 9-i) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			return;
		}
		System.out.println("mixed");
		return;*/
		
		int[] nums = new int[8];
		int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] desc = {8, 7, 6, 5, 4, 3, 2, 1};

		String res = null;
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums[0] = Integer.parseInt(st.nextToken());
		int[] cond = null;
		switch(nums[0]) {
		case 1:
			cond = asc;
			res = "ascending";
			break;
		case 8:
			cond = desc;
			res = "descending";
			break;
		default:
			System.out.println("mixed");
			return;
		}
		for (int i = 1; i < 8; i++) {
			if(Integer.parseInt(st.nextToken()) != cond[i]) {
				res = "mixed";
				break;
			}
		}
		System.out.println(res);
	}
}
