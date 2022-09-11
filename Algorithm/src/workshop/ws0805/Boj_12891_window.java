package workshop.ws0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891_window {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());// 9
		int P = Integer.parseInt(st.nextToken());// 8

		st = new StringTokenizer(br.readLine());
		String str = st.nextToken(); // CCTGGATTG
		char[] in = str.toCharArray();

		st = new StringTokenizer(br.readLine(), " ");// 2 0 0 1
		int[] DNA = new int[4];// ACGT 공간
		DNA[0] = Integer.parseInt(st.nextToken());// A, 2
		DNA[1] = Integer.parseInt(st.nextToken());// C, 0
		DNA[2] = Integer.parseInt(st.nextToken());// G, 0
		DNA[3] = Integer.parseInt(st.nextToken());// T, 1
		
		
		
	}
}
