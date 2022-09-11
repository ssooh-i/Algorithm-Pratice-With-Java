package boj.Implementation;

import java.util.Scanner;

//세 수
public class b3_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		for(int i =0; i<3; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i <2; i++) {
			for(int j = i+1; j<3; j++) {
				int temp =0;
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(arr[1]);
	}
}
