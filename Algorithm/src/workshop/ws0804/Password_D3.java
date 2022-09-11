package workshop.ws0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Password_D3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(25*10);
		
		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<>();

			String[] arr = br.readLine().split(" ");
			int[] arr2 = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Integer.parseInt(arr[i]);
			}

			// System.out.println(Arrays.toString(arr2));
			for (int i = 0; i < 8; i++) {// 값추가
				queue.add(arr2[i]);
			}
			// System.out.println(queue);
			int a = 1;
			while (a > 0) {
				for (int i = 1; i < 6; i++) {
					a = queue.poll() - i;
					if (a <= 0) {
						queue.add(0);
						break;
					}
					queue.add(a);
				}
			}

//			System.out.print("#" + N);
//
//			while (!queue.isEmpty()) {
//				System.out.print(" " + queue.poll());
//			}
//			System.out.println();
			
			
			sb.append("#"+N);
			while (!queue.isEmpty()) {
				sb.append(" " + queue.poll());
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}
}
