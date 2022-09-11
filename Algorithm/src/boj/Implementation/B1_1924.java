package boj.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 - 2007년 - 런타임에러
public class B1_1924 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int month = Integer.parseInt(s[0]);
		int day = Integer.parseInt(s[1]);

		int sum = 0;
		int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 1; i <= 12; i++) {
			if (i == month) {
				break;
			}
			sum += months[i];
		}

		sum += day;

		int left = sum % 7;
		switch (left) {

		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;

		}

		/*
		 * String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		 * 
		 * switch (m) { case 1: System.out.println(days[d % 7]); break;
		 * 
		 * case 2: System.out.println(days[(d+4) % 7 -1]); break;
		 * 
		 * case 3: System.out.println(days[(d+4) % 7 -1]); break;
		 * 
		 * case 4: System.out.println(days[d % 7 - 1]); break;
		 * 
		 * case 5: System.out.println(days[(d+2) % 7 -1]); break;
		 * 
		 * case 6: System.out.println(days[(d+5) % 7 +-1]); break;
		 * 
		 * case 7: System.out.println(days[d % 7 - 1]); break;
		 * 
		 * case 8: System.out.println(days[(d+3) % 7 -1]); break;
		 * 
		 * case 9: System.out.println(days[(d+6) % 7 -1]); break;
		 * 
		 * case 10: System.out.println(days[d % 7]); break;
		 * 
		 * case 11: System.out.println(days[(d+4) % 7 - 1]); break;
		 * 
		 * case 12: System.out.println(days[(d+6) % 7 -1]); break;
		 * 
		 * }
		 */
	}
}
